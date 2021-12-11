package model.DAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import util.PersistenceUnit;
import model.Author;
import model.Book;
import model.Part;
import model.interfaces.IDAO;

public class AuthorDAO implements IDAO<Author> {
	public static EntityManager createEM() {
		EntityManagerFactory emf = PersistenceUnit.getInstance();
		return emf.createEntityManager();
	}

	public static EntityTransaction beginSession() {
		EntityManager em = createEM();
		return em.getTransaction();
	}

	@Override
	public void save(Author a) {
		EntityManager em = createEM();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();

	}

	@Override
	public void delete(Author a) {
		EntityManager em = createEM();
		em.getTransaction().begin();
		em.remove(a);
		em.getTransaction().commit();
	}

	@Override
	public Author getById(Long id) {
		Author result = null;
		EntityManager em = createEM();
		em.getTransaction().begin();
		result = em.find(Author.class, id);
		em.getTransaction().commit();
		return result;

	}

	@Override
	public Set<Author> getByName(String name) {
		Set<Author> autores = new HashSet<Author>();
		List<Author> lista= new ArrayList<Author>();
		EntityManager em = createEM();
		em.getTransaction().begin();
		TypedQuery<Author> q = em.createNamedQuery("findAuthorbyName", Author.class);
		q.setParameter("name", name);
		lista= q.getResultList();
		autores= new  HashSet<>(lista);
		em.getTransaction().commit();
		return autores;
	}

	public Author getByNamePassword(String name, String password) {
		Author autor = new Author();
		EntityManager em = createEM();
		em.getTransaction().begin();
		TypedQuery<Author> q = em.createNamedQuery("findUserPassword", Author.class);
		q.setParameter("name", name);
		q.setParameter("password", password);
		autor =  q.getResultList().get(0);
		em.getTransaction().commit();
		return autor;

	}

	@Override
	public Set<Author> getAll() {
		Set<Author> autores = new HashSet<Author>();
		EntityManager em = createEM();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Author> cq = cb.createQuery(Author.class);
		Root<Author> rootEntry = cq.from(Author.class);
		CriteriaQuery<Author> all = cq.select(rootEntry);
		TypedQuery<Author> q = em.createQuery(all);
		return autores;
	}

	public static void addLibro(Author a, Book l) {
		EntityManager em = createEM();
		em.getTransaction().begin();
		Author ax = em.merge(a);
		l.setAuthor(ax);
		ax.getBooks().add(l);
		em.getTransaction().commit();
	}
}

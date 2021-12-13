package model.DAO;

import java.util.Set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import util.PersistenceUnit;
import model.Annotation;
import model.Author;
import model.Book;
import model.Character;
import model.Part;
import model.interfaces.IDAO;

public class BookDAO implements IDAO<Book> {

	@Override
	public void save(Book b) {
		EntityManager em = PersistenceUnit.getEM();
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();

	}

	@Override
	public void delete(Book b) {
		EntityManager em = PersistenceUnit.getEM();
		em.getTransaction().begin();
		em.remove(b);
		em.getTransaction().commit();

	}

	@Override
	public Book getById(Long id) {
		Book result = null;
		EntityManager em = PersistenceUnit.getEM();
		em.getTransaction().begin();
		result = em.find(Book.class, id);
		em.getTransaction().commit();
		return result;
	}

	@Override
	public Set<Book> getByName(String name) {
		Set<Book> books = new HashSet<Book>();
		EntityManager em = PersistenceUnit.getEM();
		em.getTransaction().begin();
		TypedQuery<Book> q = em.createNamedQuery("findAuthorbyName", Book.class);
		q.setParameter("name", name);
		books = (Set<Book>) q.getResultList();
		em.getTransaction().commit();
		return books;
	}
	
	public List<Book> getByAuthor(Author author) {
		List<Book> lista= new ArrayList<Book>();
		EntityManager em = PersistenceUnit.getEM();
		em.getTransaction().begin();
		TypedQuery<Book> q = em.createNamedQuery("findByAuthor", Book.class).setParameter("author",author.getId());
		lista= q.getResultList();
		em.getTransaction().commit();
		return lista;
	}

	@Override
	public Set<Book> getAll() {
		Set<Book> Books = new HashSet<Book>();
		EntityManager em = PersistenceUnit.getEM();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Book> cq = cb.createQuery(Book.class);
		Root<Book> rootEntry = cq.from(Book.class);
		CriteriaQuery<Book> all = cq.select(rootEntry);
		TypedQuery<Book> q = em.createQuery(all);
		return Books;
	}

	public static void addPart(Book l, Part p) {
		EntityManager em = PersistenceUnit.getEM();
		em.getTransaction().begin();
		Book ax = em.merge(l);
		p.setBook(ax);
		ax.getParts().add(p);
		em.getTransaction().commit();
	}

	public static void addAnnotation(Book l, Annotation p) {
		EntityManager em = PersistenceUnit.getEM();
		em.getTransaction().begin();
		Book ax = em.merge(l);
		p.setBook(ax);
		ax.getAnnotations().add(p);
		em.getTransaction().commit();
	}

	public static void addCharacter(Book l, Character p) {
		EntityManager em = PersistenceUnit.getEM();
		em.getTransaction().begin();
		Book ax = em.merge(l);
		p.getBooks().add(ax);
		ax.getCharacters().add(p);
		em.getTransaction().commit();
	}
}

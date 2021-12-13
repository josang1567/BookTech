package model.DAO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import model.Book;
import model.Character;
import model.interfaces.IDAO;
import util.PersistenceUnit;

public class CharacterDAO implements IDAO<Character> {

//	public static EntityManager createEM() {
//		EntityManagerFactory emf = PersistenceUnit.getInstance();
//		return emf.createEntityManager();
//	}
//
//	public static EntityTransaction beginSession() {
//		EntityManager em = createEM();
//		return em.getTransaction();
//	}

	@Override
	public void save(Character a) {
		EntityManager em = PersistenceUnit.getEM();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
	}

	@Override
	public void delete(Character a) {
		EntityManager em = PersistenceUnit.getEM();
		em.getTransaction().begin();
		em.remove(a);
		em.getTransaction().commit();

	}

	@Override
	public Character getById(Long id) {
		Integer I = id.intValue();
		Character result = null;
		EntityManager em = PersistenceUnit.getEM();
		em.getTransaction().begin();
		result = em.find(Character.class, id);
		em.getTransaction().commit();
		return result;
	}

	@Override
	public Set<Character> getByName(String name) {
		Set<Character> characters = new HashSet<Character>();
		List<Character> lista = new ArrayList<Character>();
		EntityManager em = PersistenceUnit.getEM();
		em.getTransaction().begin();
		TypedQuery<Character> q = em.createNamedQuery("findByName", Character.class);
		q.setParameter("name", name);
		lista = q.getResultList();
		characters = new HashSet<>(lista);
		em.getTransaction().commit();
		return characters;
	}

	public Character getByBook(Book book) {
		Character result = null;
		EntityManager em = PersistenceUnit.getEM();
		em.getTransaction().begin();
		result = em.find(Character.class, book);
		em.getTransaction().commit();
		return result;
	}

	@Override
	public Set<Character> getAll() {
		Set<Character> Characters = new HashSet<Character>();
		EntityManager em = PersistenceUnit.getEM();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Character> cq = cb.createQuery(Character.class);
		Root<Character> rootEntry = cq.from(Character.class);
		CriteriaQuery<Character> all = cq.select(rootEntry);
		TypedQuery<Character> q = em.createQuery(all);
		return Characters;
	}

	public Set<Character> getByFeatures(String features) {
		Set<Character> autores = new HashSet<Character>();
		List<Character> lista= new ArrayList<Character>();
		EntityManager em = PersistenceUnit.getEM();
		em.getTransaction().begin();
		TypedQuery<Character> q = em.createNamedQuery("findByFeatures", Character.class);
		q.setParameter("features", features);
	lista= q.getResultList();
		autores= new  HashSet<>(lista);
		em.getTransaction().commit();
		return autores;
	}

	public static void addBook(Character c, Book b) {
		EntityManager em = PersistenceUnit.getEM();
		em.getTransaction().begin();
		Character ax = em.merge(c);
		b.getCharacters().add(ax);
		ax.getBooks().add(b);
		em.getTransaction().commit();
	}
}

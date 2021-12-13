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
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import util.PersistenceUnit;
import model.Book;
import model.Chapter;
import model.Part;
import model.interfaces.IDAO;

public class ChapterDAO implements IDAO<Chapter> {
	public static EntityManager createEM() {
		EntityManagerFactory emf = PersistenceUnit.getInstance();
		return emf.createEntityManager();
	}

	public static EntityTransaction beginSession() {
		EntityManager em = createEM();
		return em.getTransaction();
	}

	@Override
	public void save(Chapter a) {
		EntityManager em = createEM();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();

	}

	@Override
	public void delete(Chapter a) {
		EntityManager em = createEM();
		em.getTransaction().begin();
		em.remove(a);
		em.getTransaction().commit();

	}

	@Override
	public Chapter getById(Long id) {
		Integer I = id.intValue();
		Chapter result = null;
		EntityManager em = createEM();
		em.getTransaction().begin();
		result = em.find(Chapter.class, id);
		em.getTransaction().commit();
		return result;
	}

	@Override
	public Set<Chapter> getByName(String name) {
		Set<Chapter> autores = new HashSet<Chapter>();
		List<Chapter> lista= new ArrayList<Chapter>();
		EntityManager em = createEM();
		em.getTransaction().begin();
		TypedQuery<Chapter> q = em.createNamedQuery("findByName", Chapter.class);
		q.setParameter("name", name);
		lista=q.getResultList();
		autores= new  HashSet<>(lista);
		em.getTransaction().commit();
		return autores;
	}

	public List<Chapter> getByPart(Part part) {
		List<Chapter> result = null;
		EntityManager em = createEM();
		em.getTransaction().begin();
		TypedQuery<Chapter> query = em.createNamedQuery("getChapterByPart", Chapter.class).setParameter("idPart", part.getId());
		result = query.getResultList();
		em.getTransaction().commit();
		return result;
	}

	
	@Override
	public Set<Chapter> getAll() {
		Set<Chapter> autores = new HashSet<Chapter>();
		EntityManager em = createEM();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Chapter> cq = cb.createQuery(Chapter.class);
		Root<Chapter> rootEntry = cq.from(Chapter.class);
		CriteriaQuery<Chapter> all = cq.select(rootEntry);
		TypedQuery<Chapter> q = em.createQuery(all);
		return autores;
	}

	public static void addPart(Chapter c, Part p) {
		EntityManager em = createEM();
		em.getTransaction().begin();
		Chapter ax = em.merge(c);
		p.getChapters().add(ax);
		ax.setPart(p);
		em.getTransaction().commit();
	}

	public static void addAnnotation(Chapter c, Part p) {
		EntityManager em = createEM();
		em.getTransaction().begin();
		Chapter ax = em.merge(c);
		p.getChapters().add(ax);
		ax.setPart(p);
		em.getTransaction().commit();
	}
}
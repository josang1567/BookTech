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

import util.PersistenceUnit;
import model.Annotation;
import model.Book;
import model.Chapter;
import model.interfaces.IDAO;

public class AnnotationDAO implements IDAO<Annotation>{

//	public static EntityManager createEM() {
//		EntityManagerFactory emf= PersistenceUnit.getInstance();
//		return emf.createEntityManager();
//	}
//	
//	public static EntityTransaction beginSession() {
//		EntityManager em = createEM();
//		return em.getTransaction();	
//	}
	
	@Override
	public void save(Annotation annotation) {
		EntityManager em = PersistenceUnit.getEM();
		em.getTransaction().begin();
		em.persist(annotation);
		em.getTransaction().commit();
		
	}

	@Override
	public void delete(Annotation annotation) {
		EntityManager em = PersistenceUnit.getEM();
		em.getTransaction().begin();
		em.remove(annotation);
		em.getTransaction().commit();
		
	}

	@Override
	public Annotation getById(Long id) {
		Annotation result= null;
		EntityManager em = PersistenceUnit.getEM();
		em.getTransaction().begin();
		result=em.find(Annotation.class, id);
		em.getTransaction().commit();
		return result;
	}

	public List<Annotation> getByBook(Book book) {
		List<Annotation> result = new ArrayList<>();
		EntityManager em = PersistenceUnit.getEM();
		em.getTransaction().begin();
		TypedQuery<Annotation> query = em.createNamedQuery("getAnnotationByBook", Annotation.class).setParameter("idBook", book.getId());
		result = query.getResultList();
		em.getTransaction().commit();
		return result;
	}

	@Override
	public Set<Annotation> getByName(String name) {
		Set<Annotation> Annotations= new HashSet<Annotation>();
		List<Annotation> lista= new ArrayList<Annotation>();
		EntityManager em = PersistenceUnit.getEM();
		em.getTransaction().begin();
		TypedQuery<Annotation> q= em.createNamedQuery("findByName", Annotation.class );
		q.setParameter("name", name);
		lista=q.getResultList();
		Annotations=new HashSet<>(lista);
		em.getTransaction().commit();		
		return Annotations;
	}

	public List<Annotation> getByChapter(Chapter chapter) {
		List<Annotation> result = null;
		EntityManager em = PersistenceUnit.getEM();
		em.getTransaction().begin();
		TypedQuery<Annotation> query = em.createNamedQuery("getAnnotationByChapter", Annotation.class).setParameter("idChapter", chapter.getId());
		result = query.getResultList();
		em.getTransaction().commit();
		return result;
	}

	@Override
	public Set<Annotation> getAll() {
		Set<Annotation> annotations= new HashSet<Annotation>();
		EntityManager em = PersistenceUnit.getEM();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<Annotation> cq = cb.createQuery(Annotation.class);
	    Root<Annotation> rootEntry = cq.from(Annotation.class);
	    CriteriaQuery<Annotation> all = cq.select(rootEntry);
		TypedQuery<Annotation> q= em.createQuery(all);
		return annotations;
	}
	


}
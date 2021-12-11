package model.DAO;

import model.Annotation;
import model.Book;
import model.Part;
import model.interfaces.IDAO;


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

public class PartDAO implements IDAO<Part> {
	  public static EntityManager createEM() {
	        EntityManagerFactory emf = PersistenceUnit.getInstance();
	        return emf.createEntityManager();
	    }

	    public static EntityTransaction beginSession() {
	        EntityManager em = createEM();
	        return em.getTransaction();
	    }

	    @Override
	    public void save(Part a) {
	        EntityManager em=createEM();
	        em.getTransaction().begin();
	        em.persist(a);
	        em.getTransaction().commit();
	        
	    }

	    @Override
	    public void delete(Part a) {
	        EntityManager em=createEM();
	        em.getTransaction().begin();
	        em.remove(a);
	        em.getTransaction().commit();
	    }

	 

	    @Override
	    public Set<Part> getByName(String name) {
	        Set<Part> partes= new HashSet<Part>();
	        List<Part> lista= new ArrayList<Part>();
	        EntityManager em=createEM();
	        em.getTransaction().begin();
	        TypedQuery<Part> q= em.createNamedQuery("findByName", Part.class );
	        q.setParameter("name", name);
	       lista= q.getResultList();
	       partes=new HashSet<>(lista);
	        em.getTransaction().commit();
	        return partes;
	    }
	    

	    public Part getByBook(Book book) {
			Part result= null;
			EntityManager em=createEM();
			em.getTransaction().begin();
			result=em.find(Part.class, book);
			em.getTransaction().commit();
			return result;
		}

		
		@Override
		public Set<Part> getAll() {
			  Set<Part> partes= new HashSet<Part>();
		        EntityManager em=createEM();
		        em.getTransaction().begin();
		        CriteriaBuilder cb = em.getCriteriaBuilder();
		        CriteriaQuery<Part> cq = cb.createQuery(Part.class);
		        Root<Part> rootEntry = cq.from(Part.class);
		        CriteriaQuery<Part> all = cq.select(rootEntry);
		        TypedQuery<Part> q= em.createQuery(all);
		        return partes;
		}

		@Override
		public Part getById(Long id) {
			  Part result= null;
		        EntityManager em=createEM();
		        em.getTransaction().begin();
		        result=em.find(Part.class, id);
		        em.getTransaction().commit();
		        return result;
		
		}
}

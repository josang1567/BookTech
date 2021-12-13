package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUnit {
	private static final String LOCAL = "aplicacionH2";
	private static final String REMOTE = "aplicacionMariaDB";
	private static EntityManagerFactory emf;
	private static EntityManager em;
	public static Boolean mode = true; // FALSE==LOCAL TRUE==REMOTE

	public static EntityManagerFactory getInstance(String name) {
		if (emf == null) {
			if (name.equals(LOCAL) || name.equals(REMOTE)) {
				emf = Persistence.createEntityManagerFactory(name);
			}
		}
		return emf;
	}

	public static EntityManagerFactory getInstance() {
		if (emf == null) {
			if (mode) {
				emf = Persistence.createEntityManagerFactory(REMOTE);
			} else {
				emf = Persistence.createEntityManagerFactory(LOCAL);
			}
		}
		return emf;
	}

	public static EntityManager getEM() {
		if (em == null) {
			em = PersistenceUnit.getInstance().createEntityManager();
			return em;
		} else {
			return em;
		}
	}
}

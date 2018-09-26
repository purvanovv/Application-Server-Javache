package main.database.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.TransactionException;

import main.database.entities.User;

public class UserRepository {
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("casebook");

	private EntityManager entityManager;

	private EntityTransaction entityTransaction;

	public UserRepository() {

	}

	private void initializeEntityTransaction() {
		this.entityTransaction = this.entityManager.getTransaction();
	}

	private void initializeEntitymanager() {
		this.entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
	}

	private void dismiss() {
		this.entityManager.close();
	}

	public void save(User user) {
		this.initializeEntityTransaction();
		this.initializeEntitymanager();

		try {
			this.entityTransaction.begin();
			this.entityManager.persist(user);
			this.entityTransaction.commit();
		} catch (TransactionException e) {
			if (this.entityTransaction != null && this.entityTransaction.isActive()) {
				this.entityTransaction.rollback();
			}
		}
		this.dismiss();

	}
	
	public static void close() {
		ENTITY_MANAGER_FACTORY.close();
	}
}

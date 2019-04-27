package com.example.demo.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class TestUser {

	@PersistenceContext
	EntityManager em;

	public static void main(String[] args) {
		// 1. 鍒涘缓EntityManagerFactory
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-demo");

		// 2. 鍒涘缓EntityManager
		EntityManager entityManager = factory.createEntityManager();
//		 addUser(entityManager);
//		 addAuthority(entityManager);
//		delUser(entityManager);
		delAuthority(entityManager);

		// 6. 鍏抽棴EntityManager
		entityManager.close();

		// 7. 鍏抽棴EntityManagerFactory
		factory.close();
	}

	
	public static void delAuthority(EntityManager entityManager) {
		// 3.寮�鍚簨鍔�?
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Authority a = entityManager.find(Authority.class, 1);
		System.out.println(a.getUserList());
		entityManager.remove(a);

		// 5. 鎻愪氦浜嬪姟
		transaction.commit();

	}
	
	public static void delUser(EntityManager entityManager) {
		// 3.寮�鍚簨鍔�?
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		User u = entityManager.find(User.class, 1);
		entityManager.remove(u);

		// 5. 鎻愪氦浜嬪姟
		transaction.commit();

	}

	public static void addAuthority(EntityManager entityManager) {
		// 3.寮�鍚簨鍔�?
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		// 4. 鎸佷箙鍖栨搷浣�
		Authority a = new Authority();

		a.setName("aaa");

		// 娣诲姞user鍒版暟鎹簱锛岀浉褰撲簬hibernate鐨剆ave();
		entityManager.persist(a);

		// 5. 鎻愪氦浜嬪姟
		transaction.commit();

	}

	public static void addUser(EntityManager entityManager) {
		// 3.寮�鍚簨鍔�?
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		List<Authority> authorityList = entityManager.createQuery("SELECT a FROM Authority a ").getResultList();
		// 4. 鎸佷箙鍖栨搷浣�
		User u = new User();
		u.setPassword("123456");
		u.setUsername("鐜嬩�?");
		u.setAuthorityList(authorityList);
		// 娣诲姞user鍒版暟鎹簱锛岀浉褰撲簬hibernate鐨剆ave();
		entityManager.persist(u);

		// 5. 鎻愪氦浜嬪姟
		transaction.commit();

	}

}

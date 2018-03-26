package com.zk.webshop.model.util;

import javax.persistence.EntityManagerFactory;

public class Utility {

	private static EntityManagerFactory emf;

	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null) {
			throw new IllegalArgumentException(
					"EntityManagerfactory is not initialized!!!");
		}
		return emf;
	}

	public static void setEntityManagerFactory(EntityManagerFactory emf) {
		Utility.emf = emf;
	}
}

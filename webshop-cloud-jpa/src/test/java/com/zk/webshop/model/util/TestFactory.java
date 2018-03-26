package com.zk.webshop.model.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zk.webshop.model.Product;
import com.zk.webshop.model.Supplier;

public class TestFactory {
	private static Logger logger = LoggerFactory.getLogger(TestFactory.class);
	
	public static final String TEST_JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	private static final String TEST_JDBC_URL_IN_MEMORY = "jdbc:derby:memory:DemoDB;create=true";
	public static final String TEST_JDBC_URL = "jdbc:derby:DemoDB;create=true";
	public static final String TEST_JDBC_USER = "demo";
	public static final String TEST_JDBC_PASSWORD = "demo";
	private static final String TEST_TARGET_DATABASE = "Derby";
	private static final String TEST_JPA_LOG_LEVEL = "INFO";
	public static final String PERSISTENCE_UNIT = "com.webshop.model";
	
	private static boolean inMemory = false;
	private static Map<String, String> defaultProperties = null;
	protected static EntityManagerFactory emf;
	
		
	public static EntityManagerFactory geEntityManagerFactory(String persistenceUnitName){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName, getDefaultTestProperties());
	//	EntityManagerFactory emf = new PersistenceProvider().createEntityManagerFactory(persistenceUnitName, getDefaultTestProperties());
		Utility.setEntityManagerFactory(emf);
		return emf;
	}
	
	public Boolean createProduct(EntityManager em, String productId){
		boolean status = true;
		Product product = new Product();
		try {
			em.getTransaction().begin();
			product.setProductId(productId);
			product.setCategory("SMARTPHONE");
			product.setQuantityUnit("EA");
			product.setWeightUnit("KG");
			product.setPrice(BigDecimal.valueOf(Double.parseDouble("500")));
			em.persist(product);
			em.getTransaction().commit();
		} catch (Exception e) {
			status = false;
			logger.error("Error occured during creation of product. Detailed info: "  + e);
		}
		
		return status;
	}
	
	public Boolean deleteProduct(EntityManager em, String productId) {
		Boolean status = true;
		Product product = null;
		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			product = em.find(Product.class, productId);
			if (product != null) {
				em.remove(product);
				em.getTransaction().commit();
			} else {
				logger.info("Product " + productId 	+ " does not exist in the db");
				status = false;
			}

		} catch (Exception e) {
			status = false;
			logger.error("Error occured during delete of product. Detailed info: "	+ e);
		}
		return status;
	}
	
	public boolean createSupplier(EntityManager em, String supplierId) {
		boolean status = true;
		Supplier supplier = null;
		
		try {
			if(!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			supplier = new Supplier();
			supplier.setSupplierId(supplierId);
			supplier.setPhoneNumber("89204427788");
			em.persist(supplier);
			em.getTransaction().commit();
		} catch (Exception e) {
			status = false;
			logger.error("Error occured during creation of Supplier. Detailed info: "+ e);
		}
		
		return status;
	}
	
	public boolean deleteSupplier(EntityManager em, String supplierId) {
		boolean status = true;
		Supplier supplier = null;
		
		try {
			if(!em.getTransaction().isActive())
				em.getTransaction().begin();
			supplier = em.find(Supplier.class, supplierId);
			if(supplier != null) {
				em.remove(supplier);
				em.getTransaction().commit();
			} else {
				logger.info("Supplier " + supplierId + " does not exist in the db");
				status = false;
			}
		} catch (Exception e) {
			status = false;
			logger.error("Error occured during delete of supplier. Detailed info: "	+ e);
		}
		return status;
	}
	
	private static Map<String, String> getDefaultTestProperties() {
		if (defaultProperties == null) {
			defaultProperties = new HashMap<String, String>();
			defaultProperties.put(PersistenceUnitProperties.JDBC_DRIVER, TEST_JDBC_DRIVER);
			if (inMemory) {
				defaultProperties.put(PersistenceUnitProperties.JDBC_URL, TEST_JDBC_URL_IN_MEMORY);
			} else {
				defaultProperties.put(PersistenceUnitProperties.JDBC_URL, TEST_JDBC_URL);
			}
			defaultProperties.put(PersistenceUnitProperties.JDBC_USER, TEST_JDBC_USER);
			defaultProperties.put(PersistenceUnitProperties.JDBC_PASSWORD, TEST_JDBC_PASSWORD);
			defaultProperties.put(PersistenceUnitProperties.TARGET_DATABASE, TEST_TARGET_DATABASE);
			defaultProperties.put(PersistenceUnitProperties.LOGGING_LEVEL, TEST_JPA_LOG_LEVEL);
			defaultProperties.put(PersistenceUnitProperties.DDL_GENERATION, PersistenceUnitProperties.DROP_AND_CREATE);
		}
		return defaultProperties;
	}

}

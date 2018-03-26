package com.zk.webshop.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;

import org.junit.Test;

import com.zk.webshop.model.util.TestFactory;

public class ProductTest extends AbstractTest{
	
	//Product prod = null;
	
	@Test
	public void testExistingProductSearchFind() {
		Product product = null;
		String productId = "SONY-1200";
		EntityManager em = emf.createEntityManager();
		TestFactory tf = new TestFactory();
		
		try {
			assertTrue("Product not created", tf.createProduct(em, productId));
			em.getTransaction().begin();
			product = em.find(Product.class, productId);
			assertNotNull("Search via find method: Added product SONY-1200 not persisted in database", product);
			if (product != null) {
				assertEquals("Added Product not persisted in the database ", "SONY-1200", product.getProductId());
				tf.deleteProduct(em, productId);
			}
			
		} finally {
			em.close();
		}
	}

}

package com.zk.webshop.model;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import org.junit.Test;
import com.zk.webshop.model.util.TestFactory;

public class SupplierTest extends AbstractTest{
	
	@Test
	public void testExistingSupplierSearchFind() {
		String supplierId = "99999";
		Supplier supplierAct = null;
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		TestFactory tf = new TestFactory();
		
		try {
			assertTrue("Supplier not created", tf.createSupplier(em, supplierId));
			supplierAct = em.find(Supplier.class, supplierId);
			assertNotNull("Search via find method: Added Supplier "	+ supplierId + " not persisted in database", supplierAct);
			
			if (supplierAct != null) {
				assertEquals("Added Supplier not persisted in the database ", supplierId, supplierAct.getSupplierId());
				tf.deleteSupplier(em, supplierId);
			}
		} catch (Exception e) {
			fail(" Exception" + e + "occured");
		} finally {
			em.close();
		}
	}
}

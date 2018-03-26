package com.zk.webshop.model;

import javax.persistence.EntityManagerFactory;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.zk.webshop.model.util.TestFactory;

public class AbstractTest {
	
	protected static EntityManagerFactory emf;
	
	@BeforeClass
	public static void setup(){
		emf = TestFactory.geEntityManagerFactory(TestFactory.PERSISTENCE_UNIT);
	}
	
	@AfterClass
	public static void shutdown(){
		emf.close();
	}

}

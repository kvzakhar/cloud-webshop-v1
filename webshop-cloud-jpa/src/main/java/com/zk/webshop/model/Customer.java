package com.zk.webshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "WEBSHOP_CUSTOMER")
public class Customer {
	
	@Id	
	@TableGenerator(name = "CustomerGenerator", table = "WEBSHOP_ID_GENERATOR", 
		pkColumnName = "GENERATOR_NAME", valueColumnName = "GENERATOR_VALUE", 
		pkColumnValue = "Customer", initialValue = 100000000, allocationSize = 100)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "CustomerGenerator")
	@Column(name="CUSTOMER_ID")
	private String customerId;
	
	@Column(name = "EMAIL_ADDRESS", unique = true)
	private String emailAddress;

	@Column(name = "PHONE_NUMBER", length = 30)
	private String phoneNumber;

	@Column(name = "FIRST_NAME", length = 40)
	private String firstName;

	@Column(name = "LAST_NAME", length = 40)
	private String lastName;
	

}

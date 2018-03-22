package com.zk.webshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WEBSHOP_PRODUCT")
public class Product {
	
	@Id
	@Column(name="PRODUCT_ID", length = 10)
	private String productId;
	
	private String name;
	
	@Column(name = "SHORT_DESCRIPTION")
	private String shortDescription;

	@Column(name = "LONG_DESCRIPTION")
	private String longDescription;

}

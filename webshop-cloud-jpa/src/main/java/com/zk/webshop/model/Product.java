package com.zk.webshop.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	@Column(length = 40)
	private String category;

	@Column(name = "CATEGORY_NAME", length = 40)
	private String categoryName;

	@Column(name = "QUANTITY_UNIT", length = 3)
	private String quantityUnit;

	@Column(name = "WEIGHT", precision = 13, scale = 3)
	private BigDecimal weight;

	@Column(name = "WEIGHT_UNIT", length = 3)
	private String weightUnit;

	@Column(precision = 23, scale = 3)
	private BigDecimal price;
	
	@Column(name = "CURRENCY_CODE", length = 5)
	private String currencyCode = "EUR";

	@Column(name = "DIMENSION_WIDTH", precision = 13, scale = 4)
	private BigDecimal dimensionWidth;

	@Column(name = "DIMENSION_DEPTH", precision = 13, scale = 4)
	private BigDecimal dimensionDepth;

	@Column(name = "DIMENSION_HEIGHT", precision = 13, scale = 4)
	private BigDecimal dimensionHeight;

	@Column(name = "DIMENSION_UNIT", length = 3)
	private String dimensionUnit;

	@Column(name = "PICTURE_URL")
	private String pictureUrl;
	
	@Column(name = "SUPPLIER_ID", length = 10)
	private String supplierId;
	
	@OneToOne
	private Supplier supplier;
	
	@OneToMany(mappedBy = "product", targetEntity = CustomerReview.class, fetch = FetchType.EAGER)
	private List<CustomerReview> reviews; 
	
	public Product(){
		this.reviews = new ArrayList<>();
	}
	
	public void setSupplierId(String param) {
		this.supplierId = param;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier param) {
		this.supplier = param;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getQuantityUnit() {
		return quantityUnit;
	}

	public void setQuantityUnit(String quantityUnit) {
		this.quantityUnit = quantityUnit;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public String getWeightUnit() {
		return weightUnit;
	}

	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public BigDecimal getDimensionWidth() {
		return dimensionWidth;
	}

	public void setDimensionWidth(BigDecimal dimensionWidth) {
		this.dimensionWidth = dimensionWidth;
	}

	public BigDecimal getDimensionDepth() {
		return dimensionDepth;
	}

	public void setDimensionDepth(BigDecimal dimensionDepth) {
		this.dimensionDepth = dimensionDepth;
	}

	public BigDecimal getDimensionHeight() {
		return dimensionHeight;
	}

	public void setDimensionHeight(BigDecimal dimensionHeight) {
		this.dimensionHeight = dimensionHeight;
	}

	public String getDimensionUnit() {
		return dimensionUnit;
	}

	public void setDimensionUnit(String dimensionUnit) {
		this.dimensionUnit = dimensionUnit;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	
	

}

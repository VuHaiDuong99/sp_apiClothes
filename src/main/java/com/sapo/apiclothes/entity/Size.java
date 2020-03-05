package com.sapo.apiclothes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the size database table.
 * 
 */
@Entity
@Table(name="size")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Size implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="size_id")
	private int sizeId;

	private String name;

	//bi-directional many-to-one association to ProductDetail
	@OneToMany(mappedBy="size")
	@JsonIgnore
	private List<ProductDetail> productDetails;

	public Size() {
	}

	public int getSizeId() {
		return this.sizeId;
	}

	public void setSizeId(int sizeId) {
		this.sizeId = sizeId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ProductDetail> getProductDetails() {
		return this.productDetails;
	}

	public void setProductDetails(List<ProductDetail> productDetails) {
		this.productDetails = productDetails;
	}

	public ProductDetail addProductDetail(ProductDetail productDetail) {
		getProductDetails().add(productDetail);
		productDetail.setSize(this);

		return productDetail;
	}

	public ProductDetail removeProductDetail(ProductDetail productDetail) {
		getProductDetails().remove(productDetail);
		productDetail.setSize(null);

		return productDetail;
	}

}
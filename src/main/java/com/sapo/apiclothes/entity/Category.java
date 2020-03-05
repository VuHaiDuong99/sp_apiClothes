package com.sapo.apiclothes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@Table(name = "category")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="categoru_id")
	private int categoruId;

	private String name;

	//bi-directional many-to-one association to Product
	/*@OneToMany(mappedBy="category")

	private List<Product> products;
*/
	public Category() {
	}

	public int getCategoruId() {
		return this.categoruId;
	}

	public void setCategoruId(int categoruId) {
		this.categoruId = categoruId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
/*

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setCategory(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setCategory(null);

		return product;
	}
*/

}
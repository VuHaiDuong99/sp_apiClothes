package com.sapo.apiclothes.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="product_detail")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProductDetail{
	@Id
	private int id;
	private int amount;
	//bi-directional many-to-one association to Color
	@ManyToOne
	@JoinColumn(name="id_color")
	private Color color;
	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	//bi-directional many-to-one association to Size
	@ManyToOne
	@JoinColumn(name="id_size")
	private Size size;
	public ProductDetail() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAmount() {
		return this.amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Color getColor() {
		return this.color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Product getProduct() {
		return this.product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Size getSize() {
		return this.size;
	}
	public void setSize(Size size) {
		this.size = size;
	}

}
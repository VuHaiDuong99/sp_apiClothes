package com.sapo.apiclothes.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the color database table.
 * 
 */
@Entity
@Table(name ="color")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Color implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="color_id")
	private int colorId;
	private String name;
	public Color() {
	}

	public int getColorId() {
		return this.colorId;
	}

	public void setColorId(int colorId) {
		this.colorId = colorId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}





}
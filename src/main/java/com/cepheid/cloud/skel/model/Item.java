package com.cepheid.cloud.skel.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "item")
public class Item extends AbstractEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "name")
	 private String name;
	
	@Column(name = "state")
	 private String state;
	 

	@OneToMany(mappedBy = "item")
	@JsonIgnore
	  private Set<Description> description;
	

	public String getName() {
		return name;
	}

	public Item(String name, String state) {
		super();
		this.name = name;
		this.state = state;
		
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Set<Description> getDescription() {
		return description;
	}

	public void setDescription(Set<Description> description) {
		this.description = description;
	}

	

	@Override
	public String toString() {
		return "Item [name=" + name + ", state=" + state + "]";
	}

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}

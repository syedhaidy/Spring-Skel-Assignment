package com.cepheid.cloud.skel.bean;

import java.util.Set;

import javax.validation.constraints.NotEmpty;

import com.cepheid.cloud.skel.model.Description;
import com.cepheid.cloud.skel.validation.ItemValidatorVal;

public class ItemSO {

	@NotEmpty(message = "{NotEmpty.itemSO.name}")
	private String name;

	@ItemValidatorVal(message = "{ItemSO.ItemValidatorValMessage}")
	private String state;

	private Set<DescriptionSO> description;
	
	@Override
	public String toString() {
		return "ItemSO [name=" + name + ", state=" + state + ", description=" + description + "]";
	}

	public ItemSO() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Set<DescriptionSO> getDescription() {
		return description;
	}

	public void setDescription(Set<DescriptionSO> description) {
		this.description = description;
	}

	public String getName() {
		return name;
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

	


	
}

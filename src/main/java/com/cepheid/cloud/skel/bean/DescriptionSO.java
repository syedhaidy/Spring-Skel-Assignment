package com.cepheid.cloud.skel.bean;

public class DescriptionSO {
	private long id;
	
	private String desc;

	public DescriptionSO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DescriptionSO(long id, String desc) {
		super();
		this.id = id;
		this.desc = desc;
	}

	public long getId() {
		return id;
	}

	public void setDescId(long id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "DescriptionSO [id=" + id + ", desc=" + desc + "]";
	}


	
}

package com.xworkz.equality.dto;

import java.io.Serializable;
import java.util.Objects;

public class CompanyDTO  implements Serializable{

	private Integer id;
	private String name;
	private String ceoName;
	private Integer turnOver;
	
	public CompanyDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompanyDTO(Integer id, String name, String ceoName, Integer turnOver) {
		super();
		this.id = id;
		this.name = name;
		this.ceoName = ceoName;
		this.turnOver = turnOver;
	}

	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof CompanyDTO)) {
			return false;
		}
		CompanyDTO other = (CompanyDTO) obj;
		return Objects.equals(name, other.name);
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCeoName() {
		return ceoName;
	}

	public void setCeoName(String ceoName) {
		this.ceoName = ceoName;
	}

	public Integer getTurnOver() {
		return turnOver;
	}

	public void setTurnOver(Integer turnOver) {
		this.turnOver = turnOver;
	}

	@Override
	public String toString() {
		return "CompanyDTO [id=" + id + ", name=" + name + ", ceoName=" + ceoName + ", turnOver=" + turnOver + "]";
	}
	
	
	
	
}

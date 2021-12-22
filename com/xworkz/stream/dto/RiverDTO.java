package com.xworkz.stream.dto;

public class RiverDTO {

	private Integer id;
	private String name;
	private String stateName;
	private Integer length;
	private Integer noOfDams;
	
	public RiverDTO(Integer id, String name, String stateName, Integer length, Integer noOfDams) {
		super();
		this.id = id;
		this.name = name;
		this.stateName = stateName;
		this.length = length;
		this.noOfDams = noOfDams;
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
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public Integer getNoOfDams() {
		return noOfDams;
	}
	public void setNoOfDams(Integer noOfDams) {
		this.noOfDams = noOfDams;
	}
	@Override
	public String toString() {
		return "RiverDTO [id=" + id + ", name=" + name + ", stateName=" + stateName + ", length=" + length
				+ ", noOfDams=" + noOfDams + "]";
	}
	
	
	
}

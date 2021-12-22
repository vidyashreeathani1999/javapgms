package com.xworkz.stream.dto;

public class TempleDTO {
	
	private Integer id;
	private String name;
	private String location;
	private String  mainGod;
	private Integer visitorsPerDay;
	
	public TempleDTO(Integer id, String name, String location, String mainGod, Integer visitorsPerDay) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.mainGod = mainGod;
		this.visitorsPerDay = visitorsPerDay;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMainGod() {
		return mainGod;
	}

	public void setMainGod(String mainGod) {
		this.mainGod = mainGod;
	}

	public Integer getVisitorsPerDay() {
		return visitorsPerDay;
	}

	public void setVisitorsPerDay(Integer visitorsPerDay) {
		this.visitorsPerDay = visitorsPerDay;
	}

	@Override
	public String toString() {
		return "TempleDTO [id=" + id + ", name=" + name + ", location=" + location + ", mainGod=" + mainGod
				+ ", visitorsPerDay=" + visitorsPerDay + "]";
	}
	
	
}

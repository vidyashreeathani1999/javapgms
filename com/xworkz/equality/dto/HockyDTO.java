package com.xworkz.equality.dto;

import java.io.Serializable;
import java.util.Objects;

public class HockyDTO implements Serializable{

	private String teamName;
	private Integer wins;
	private Integer loses;
	private String country;
	
	public HockyDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HockyDTO(String teamName, Integer wins, Integer loses, String country) {
		super();
		this.teamName = teamName;
		this.wins = wins;
		this.loses = loses;
		this.country = country;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(wins);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof HockyDTO)) {
			return false;
		}
		HockyDTO other = (HockyDTO) obj;
		return  Objects.equals(teamName, other.teamName);
	}

	
	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Integer getWins() {
		return wins;
	}

	public void setWins(Integer wins) {
		this.wins = wins;
	}

	public Integer getLoses() {
		return loses;
	}

	public void setLoses(Integer loses) {
		this.loses = loses;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "HockyDTO [teamName=" + teamName + ", wins=" + wins + ", loses=" + loses + ", country=" + country + "]";
	}
	
	
	
}

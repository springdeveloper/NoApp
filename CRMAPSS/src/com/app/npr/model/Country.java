package com.app.npr.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.app.npr.model.lead.*;
import com.fasterxml.jackson.annotation.JsonIgnore;;
@Entity
@Table(name="countries")
public class Country {
	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}


	@Id @GeneratedValue 
	private int id;
	@Column (name = "name")
	private String countryName;
	
	@Column (name = "sortname")
	@JsonIgnore
	private String sortName;
	
	public String getCountryName(){
		return countryName;
	}
	
	public void setCountryName(String CountryName){
		this.countryName = CountryName;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


}

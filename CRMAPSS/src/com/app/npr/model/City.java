package com.app.npr.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.app.npr.model.lead.*;

@Entity
@Table(name = "cities")
public class City {
	@Id
	@GeneratedValue
	private int id;
	@Column(name = "name")
	private String cityName;
	@Column(name = "state_id")
	private int stateId;


	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String CityName) {
		this.cityName = CityName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
package com.app.npr.model.lead;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.app.npr.dao.genric.JPAEntity;
import com.app.npr.model.City;
import com.app.npr.model.Country;
import com.app.npr.model.State;

@Entity
@Table(name = "adress_master")
public class Address extends JPAEntity<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "adress_id")
	private Long id;
	@Column(name = "postal_code")
	private String postalCode;
	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;
	@ManyToOne
	@JoinColumn(name = "state_id")
	private State states;
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public State getStates() {
		return states;
	}

	public void setStates(State states) {
		this.states = states;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}



}

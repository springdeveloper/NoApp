package com.app.npr.model.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.app.npr.model.City;
import com.app.npr.model.Country;
import com.app.npr.model.State;

@Entity
@Table(name = "billing_address")
public class BillingAddress {

	@Id
	@GeneratedValue
	@Column(name = "billing_id")
	private Integer id;

	@Column(name = "street_one")
	private String streetOne;

	@Column(name = "street_two")
	private String streetTwo;

	@Column(name = "postal_code")
	private String postalCode;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStreetOne() {
		return streetOne;
	}
	public void setStreetOne(String streetOne) {
		this.streetOne = streetOne;
	}
	public String getStreetTwo() {
		return streetTwo;
	}
	public void setStreetTwo(String streetTwo) {
		this.streetTwo = streetTwo;
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
	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;
	@ManyToOne
	@JoinColumn(name = "state_id")
	private State states;
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

}

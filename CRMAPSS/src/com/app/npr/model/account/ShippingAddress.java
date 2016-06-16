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
@Table(name="shiping_address")
public class ShippingAddress {

	@Id
	@GeneratedValue
	@Column(name="shipping_id")
	private Integer id;
	
	@Column(name="street_one")
	private String streetOne;
	
	@Column(name="street_two")
	private String streetTwo;
	
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
	
}

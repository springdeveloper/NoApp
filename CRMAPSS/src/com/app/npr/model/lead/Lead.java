package com.app.npr.model.lead;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.*;

import org.hibernate.validator.constraints.NotEmpty;

import com.app.npr.dao.genric.JPAEntity;
import com.app.npr.enums.LeadEnum.IndustryType;
import com.app.npr.enums.LeadEnum.LeadSourceType;
import com.app.npr.enums.LeadEnum.LeadStatus;

@Entity
@Table(name = "lead_details")
public class Lead extends JPAEntity<Long>  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6951477841594828312L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "lead_gkey")
	private Long id;
	@Column(name = "lead_owner")
	private String leadOwner;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "mobile")
	private String mobile;
	@Column(name = "phone")
	private String phone;
	@Column(name = "other_mobile")
	private String otherMobile;
	@Column(name = "company")
	private String company;
	@Column(name = "emails")
	private String emails;
	@Column(name = "other_emails")
	private String otherEmail;
	@Column(name = "website")
	private String website;
	@Enumerated(EnumType.STRING)
	@Column(name = "industry")
	private IndustryType industry;
	@Column(name = "rating")
	private String rating;
	@Column(name = "annual_revenue")
	private String annualRevenue;
	@Column(name = "skype_Id")
	private String skypeId;
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "lead_source")
	private LeadSourceType leadSource;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "lead_status")
	private LeadStatus leadStatus;
	@Column(name = "no_of_employee")
	private String noOfEmployee;
	@Column(name = "twitter_id")
	private String twiterId;
	@Column(name = "lead_description")
	private String leadDescription;

	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	public LeadStatus getLeadStatus() {
		return leadStatus;
	}

	public void setLeadStatus(LeadStatus leadStatus) {
		this.leadStatus = leadStatus;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLeadOwner() {
		return leadOwner;
	}

	public void setLeadOwner(String leadOwner) {
		this.leadOwner = leadOwner;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOtherMobile() {
		return otherMobile;
	}

	public void setOtherMobile(String otherMobile) {
		this.otherMobile = otherMobile;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getEmails() {
		return emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

	public String getOtherEmail() {
		return otherEmail;
	}

	public void setOtherEmail(String otherEmail) {
		this.otherEmail = otherEmail;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}


	public IndustryType getIndustry() {
		return industry;
	}

	public void setIndustry(IndustryType industry) {
		this.industry = industry;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getAnnualRevenue() {
		return annualRevenue;
	}

	public void setAnnualRevenue(String annualRevenue) {
		this.annualRevenue = annualRevenue;
	}

	public String getSkypeId() {
		return skypeId;
	}

	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}

	public LeadSourceType getLeadSource() {
		return leadSource;
	}

	public void setLeadSource(LeadSourceType leadSource) {
		this.leadSource = leadSource;
	}

	public String getNoOfEmployee() {
		return noOfEmployee;
	}

	public void setNoOfEmployee(String noOfEmployee) {
		this.noOfEmployee = noOfEmployee;
	}

	public String getTwiterId() {
		return twiterId;
	}

	public void setTwiterId(String twiterId) {
		this.twiterId = twiterId;
	}

	public String getLeadDescription() {
		return leadDescription;
	}

	public void setLeadDescription(String leadDescription) {
		this.leadDescription = leadDescription;
	}
}

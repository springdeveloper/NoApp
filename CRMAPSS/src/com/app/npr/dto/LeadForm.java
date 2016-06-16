package com.app.npr.dto;

import com.app.npr.enums.LeadEnum;
import com.app.npr.enums.LeadEnum.IndustryType;
import com.app.npr.enums.LeadEnum.LeadSourceType;
import com.app.npr.enums.LeadEnum.LeadStatus;
import com.app.npr.model.City;
import com.app.npr.model.Country;
import com.app.npr.model.State;
import com.app.npr.model.lead.Address;
import com.app.npr.model.lead.Lead;
import com.sun.istack.internal.NotNull;

public class LeadForm {
	@NotNull
	private String leadOwner;
	private String firstName;
	private String lastName;
	private String mobile;
	private String phone;
	private String otherMobile;
	private String company;
	private String emails;
	private LeadStatus leadenum;
	private String address;

	public String getAddress() {
		return address;
	}

	public LeadStatus getLeadenum() {
		return leadenum;
	}

	public void setLeadenum(LeadStatus leadenum) {
		this.leadenum = leadenum;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	private String otherEmail;
	private String website;
	private String industry;
	private String rating;
	private String annualRevenue;
	private String cityName;
	private String stateName;
	private int stateId;


	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}


	private int cityId;
	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	private String skypeId;
	private String leadSource;
	private String leadStatus;
	private String noOfEmployee;
	private String twiterId;
	private String countryName;
	private String postalCode;
	private String leadDescription;
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static Lead getPopulateBean(LeadForm form) {
		Address adrs = new Address();
		Lead lead = new Lead();
		Country cnt=new Country();
		City city=new City();
		State state=new State();
		
		cnt.setId(Integer.parseInt(form.getCountryName()));
		if (form.getId() != null) {
		lead.setId(form.getId());
		adrs.setId(form.getId());
		}
		city.setId((Integer.parseInt(form.getCityName())));
		state.setId(Integer.parseInt(form.getStateName()));
		adrs.setCountry(cnt);
		adrs.setCity(city);
		adrs.setStates(state);
		adrs.setPostalCode(form.getPostalCode());
		lead.setAddress(adrs);
		lead.setAnnualRevenue(form.annualRevenue);
		lead.setCompany(form.getCompany());
		lead.setEmails(form.emails);
		lead.setFirstName(form.firstName);
		lead.setIndustry(LeadEnum.getIndustryEnum(Integer.parseInt(form.industry)));
		lead.setLastName(form.lastName);
		lead.setLeadDescription(form.leadDescription);
		lead.setLeadOwner(form.leadOwner);
		lead.setLeadSource(LeadEnum.getLeadSourceTypeEnum(Integer.parseInt(form.leadSource)));
		lead.setMobile(form.mobile);
		lead.setNoOfEmployee(form.noOfEmployee);
		lead.setOtherEmail(form.otherEmail);
		lead.setOtherMobile(form.otherMobile);
		lead.setPhone(form.phone);
		lead.setRating(form.rating);
		lead.setSkypeId(form.skypeId);
		lead.setTwiterId(form.twiterId);
		lead.setWebsite(form.website);
		lead.setLeadStatus(LeadEnum.getLeadEnum(Integer.parseInt(form.getLeadStatus())));
		return lead;

	}

	public static LeadForm getLeadData(Lead lead) {
		LeadForm lf = new LeadForm();
		Address adrs = new Address();
		lf.setId(lead.getId());
		adrs.setCity(lead.getAddress().getCity());
		adrs.setCountry(lead.getAddress().getCountry());
		lf.setPostalCode(lead.getAddress().getPostalCode());
		lf.setCountryName(String.valueOf(lead.getAddress().getCountry().getId()));
		lf.setStateId(lead.getAddress().getStates().getId());
		lf.setStateName(lead.getAddress().getStates().getStateName());
		lf.setCityId(lead.getAddress().getCity().getId());
		lf.setCityName(lead.getAddress().getCity().getCityName());
		
			//adrs.setState(lead.getAddress().getState().);
		lf.setAnnualRevenue(lead.getAnnualRevenue());
		lf.setCompany(lead.getCompany());
		lf.setEmails(lead.getEmails());
		lf.setFirstName(lead.getFirstName());
		lf.setIndustry(LeadEnum.getIndustryEnum(lead.getIndustry()).toString());
		lf.setLastName(lead.getLastName());
		lf.setLeadDescription(lead.getLeadDescription());
		lf.setLeadOwner(lead.getLeadOwner());
		lf.setMobile(lead.getMobile());
		lf.setNoOfEmployee(lead.getNoOfEmployee());
		lf.setOtherEmail(lead.getOtherEmail());
		lf.setOtherMobile(lead.getOtherMobile());
		lf.setPhone(lead.getPhone());
		lf.setRating(lead.getRating());
		lf.setSkypeId(lead.getSkypeId());
		lf.setTwiterId(lead.getTwiterId());
		lf.setWebsite(lead.getWebsite());
		lf.setLeadStatus(LeadEnum.getLeadEnum(lead.getLeadStatus()).toString());
		lf.setLeadSource(LeadEnum.getLeadSourceTypeEnum(lead.getLeadSource()).toString());
		return lf;

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

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
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

	public String getLeadSource() {
		return leadSource;
	}

	public void setLeadSource(String leadSource) {
		this.leadSource = leadSource;
	}

	public String getLeadStatus() {
		return leadStatus;
	}

	public void setLeadStatus(String leadStatus) {
		this.leadStatus = leadStatus;
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

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getLeadDescription() {
		return leadDescription;
	}

	public void setLeadDescription(String leadDescription) {
		this.leadDescription = leadDescription;
	}

}

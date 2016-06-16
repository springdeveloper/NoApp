package com.app.npr.model.account;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.app.npr.dao.genric.JPAEntity;
import com.app.npr.enums.AccountEnum.AccountType;
import com.app.npr.enums.LeadEnum.IndustryType;

@Entity
@Table(name = "account_table")
public class Account extends JPAEntity<Integer> {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "account_id")
	private Integer id;

	@Column(name = "account_name")
	@NotEmpty
	private String accountName;
	
	@Column(name = "company")
	private String company;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "office_phone")
	private String officePhone;

	@Column(name = "office_fax")
	private String officeFax;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "industry")
	private IndustryType industry;
	@Column(name = "annual_revenue")
	private String annualRevenue;

	@Column(name = "no_of_employee")
	private String noOfEmployee;

	@Enumerated(EnumType.STRING)
	@Column(name = "acount_type")
	private AccountType accountType;

	@Column(name = "website_name")
	private String websiteName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
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

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getOfficeFax() {
		return officeFax;
	}

	public void setOfficeFax(String officeFax) {
		this.officeFax = officeFax;
	}

	public IndustryType getIndustry() {
		return industry;
	}

	public void setIndustry(IndustryType industry) {
		this.industry = industry;
	}

	public String getAnnualRevenue() {
		return annualRevenue;
	}

	public void setAnnualRevenue(String annualRevenue) {
		this.annualRevenue = annualRevenue;
	}

	public String getNoOfEmployee() {
		return noOfEmployee;
	}

	public void setNoOfEmployee(String noOfEmployee) {
		this.noOfEmployee = noOfEmployee;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public String getWebsiteName() {
		return websiteName;
	}

	public void setWebsiteName(String websiteName) {
		this.websiteName = websiteName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	@Column(name = "description")
	private String description;

	@OneToOne(cascade = CascadeType.ALL)
	private BillingAddress billingAddress;

	@OneToOne(cascade = CascadeType.ALL)
	private ShippingAddress shippingAddress;

}

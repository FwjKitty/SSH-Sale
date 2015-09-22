package com.hand.model;

import java.util.HashSet;
import java.util.Set;

/**
 * CustomersInfo entity. @author MyEclipse Persistence Tools
 */

public class CustomersInfo implements java.io.Serializable {

	// Fields

	private Integer customerId;
	private Organization organization;
	private Address address;
	private String customerCode;
	private String customerName;
	private String type;
	private String groupCompany;
	private String corporation;
	private Set priceListConfigs = new HashSet(0);
	private Set priceLists = new HashSet(0);
	private Set specialDiscounts = new HashSet(0);

	// Constructors

	/** default constructor */
	public CustomersInfo() {
	}

	/** minimal constructor */
	public CustomersInfo(Organization organization, Address address,
			String customerCode, String customerName, String type) {
		this.organization = organization;
		this.address = address;
		this.customerCode = customerCode;
		this.customerName = customerName;
		this.type = type;
	}

	/** full constructor */
	public CustomersInfo(Organization organization, Address address,
			String customerCode, String customerName, String type,
			String groupCompany, String corporation, Set priceListConfigs,
			Set priceLists, Set specialDiscounts) {
		this.organization = organization;
		this.address = address;
		this.customerCode = customerCode;
		this.customerName = customerName;
		this.type = type;
		this.groupCompany = groupCompany;
		this.corporation = corporation;
		this.priceListConfigs = priceListConfigs;
		this.priceLists = priceLists;
		this.specialDiscounts = specialDiscounts;
	}

	// Property accessors

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getCustomerCode() {
		return this.customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGroupCompany() {
		return this.groupCompany;
	}

	public void setGroupCompany(String groupCompany) {
		this.groupCompany = groupCompany;
	}

	public String getCorporation() {
		return this.corporation;
	}

	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}

	public Set getPriceListConfigs() {
		return this.priceListConfigs;
	}

	public void setPriceListConfigs(Set priceListConfigs) {
		this.priceListConfigs = priceListConfigs;
	}

	public Set getPriceLists() {
		return this.priceLists;
	}

	public void setPriceLists(Set priceLists) {
		this.priceLists = priceLists;
	}

	public Set getSpecialDiscounts() {
		return this.specialDiscounts;
	}

	public void setSpecialDiscounts(Set specialDiscounts) {
		this.specialDiscounts = specialDiscounts;
	}

}
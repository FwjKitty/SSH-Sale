package com.hand.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Address entity. @author MyEclipse Persistence Tools
 */

public class Address implements java.io.Serializable {

	// Fields

	private Integer addressId;
	private String country;
	private String state;
	private String city;
	private String addressLine1;
	private String addressLine2;
	private String postcode;
	private String portOfDestination;
	private String shippingMark;
	private String status;
	private Date inactiveDate;
	private Set customersInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Address() {
	}

	/** minimal constructor */
	public Address(String country, String postcode, String portOfDestination,
			String shippingMark, String status) {
		this.country = country;
		this.postcode = postcode;
		this.portOfDestination = portOfDestination;
		this.shippingMark = shippingMark;
		this.status = status;
	}

	/** full constructor */
	public Address(String country, String state, String city,
			String addressLine1, String addressLine2, String postcode,
			String portOfDestination, String shippingMark, String status,
			Date inactiveDate, Set customersInfos) {
		this.country = country;
		this.state = state;
		this.city = city;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.postcode = postcode;
		this.portOfDestination = portOfDestination;
		this.shippingMark = shippingMark;
		this.status = status;
		this.inactiveDate = inactiveDate;
		this.customersInfos = customersInfos;
	}

	// Property accessors

	public Integer getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return this.addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPortOfDestination() {
		return this.portOfDestination;
	}

	public void setPortOfDestination(String portOfDestination) {
		this.portOfDestination = portOfDestination;
	}

	public String getShippingMark() {
		return this.shippingMark;
	}

	public void setShippingMark(String shippingMark) {
		this.shippingMark = shippingMark;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getInactiveDate() {
		return this.inactiveDate;
	}

	public void setInactiveDate(Date inactiveDate) {
		this.inactiveDate = inactiveDate;
	}

	public Set getCustomersInfos() {
		return this.customersInfos;
	}

	public void setCustomersInfos(Set customersInfos) {
		this.customersInfos = customersInfos;
	}

}
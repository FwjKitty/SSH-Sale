package com.hand.model;

/**
 * Contactors entity. @author MyEclipse Persistence Tools
 */

public class Contactors implements java.io.Serializable {

	// Fields

	private Integer contactorsId;
	private CustomersInfo customersInfo;
	private String mailFrom;
	private String prePoMailTo;
	private String poMailTo;
	private String ocpiMailTo;
	private String invPklistMailto;

	// Constructors

	/** default constructor */
	public Contactors() {
	}

	/** minimal constructor */
	public Contactors(CustomersInfo customersInfo) {
		this.customersInfo = customersInfo;
	}

	/** full constructor */
	public Contactors(CustomersInfo customersInfo, String mailFrom,
			String prePoMailTo, String poMailTo, String ocpiMailTo,
			String invPklistMailto) {
		this.customersInfo = customersInfo;
		this.mailFrom = mailFrom;
		this.prePoMailTo = prePoMailTo;
		this.poMailTo = poMailTo;
		this.ocpiMailTo = ocpiMailTo;
		this.invPklistMailto = invPklistMailto;
	}

	// Property accessors

	public Integer getContactorsId() {
		return this.contactorsId;
	}

	public void setContactorsId(Integer contactorsId) {
		this.contactorsId = contactorsId;
	}

	public CustomersInfo getCustomersInfo() {
		return this.customersInfo;
	}

	public void setCustomersInfo(CustomersInfo customersInfo) {
		this.customersInfo = customersInfo;
	}

	public String getMailFrom() {
		return this.mailFrom;
	}

	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}

	public String getPrePoMailTo() {
		return this.prePoMailTo;
	}

	public void setPrePoMailTo(String prePoMailTo) {
		this.prePoMailTo = prePoMailTo;
	}

	public String getPoMailTo() {
		return this.poMailTo;
	}

	public void setPoMailTo(String poMailTo) {
		this.poMailTo = poMailTo;
	}

	public String getOcpiMailTo() {
		return this.ocpiMailTo;
	}

	public void setOcpiMailTo(String ocpiMailTo) {
		this.ocpiMailTo = ocpiMailTo;
	}

	public String getInvPklistMailto() {
		return this.invPklistMailto;
	}

	public void setInvPklistMailto(String invPklistMailto) {
		this.invPklistMailto = invPklistMailto;
	}

}
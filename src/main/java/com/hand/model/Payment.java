package com.hand.model;

/**
 * Payment entity. @author MyEclipse Persistence Tools
 */

public class Payment implements java.io.Serializable {

	// Fields

	private Integer paymentId;
	private CustomersInfo customersInfo;
	private String invoiceGroup;
	private String currency;
	private String paymentTerm;
	private String priceTerm1;
	private String priceTerm2;
	private String priceTerm3;
	private String markupName;
	private String discountName;

	// Constructors

	/** default constructor */
	public Payment() {
	}

	/** minimal constructor */
	public Payment(CustomersInfo customersInfo, String currency,
			String paymentTerm, String markupName, String discountName) {
		this.customersInfo = customersInfo;
		this.currency = currency;
		this.paymentTerm = paymentTerm;
		this.markupName = markupName;
		this.discountName = discountName;
	}

	/** full constructor */
	public Payment(CustomersInfo customersInfo, String invoiceGroup,
			String currency, String paymentTerm, String priceTerm1,
			String priceTerm2, String priceTerm3, String markupName,
			String discountName) {
		this.customersInfo = customersInfo;
		this.invoiceGroup = invoiceGroup;
		this.currency = currency;
		this.paymentTerm = paymentTerm;
		this.priceTerm1 = priceTerm1;
		this.priceTerm2 = priceTerm2;
		this.priceTerm3 = priceTerm3;
		this.markupName = markupName;
		this.discountName = discountName;
	}

	// Property accessors

	public Integer getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public CustomersInfo getCustomersInfo() {
		return this.customersInfo;
	}

	public void setCustomersInfo(CustomersInfo customersInfo) {
		this.customersInfo = customersInfo;
	}

	public String getInvoiceGroup() {
		return this.invoiceGroup;
	}

	public void setInvoiceGroup(String invoiceGroup) {
		this.invoiceGroup = invoiceGroup;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getPaymentTerm() {
		return this.paymentTerm;
	}

	public void setPaymentTerm(String paymentTerm) {
		this.paymentTerm = paymentTerm;
	}

	public String getPriceTerm1() {
		return this.priceTerm1;
	}

	public void setPriceTerm1(String priceTerm1) {
		this.priceTerm1 = priceTerm1;
	}

	public String getPriceTerm2() {
		return this.priceTerm2;
	}

	public void setPriceTerm2(String priceTerm2) {
		this.priceTerm2 = priceTerm2;
	}

	public String getPriceTerm3() {
		return this.priceTerm3;
	}

	public void setPriceTerm3(String priceTerm3) {
		this.priceTerm3 = priceTerm3;
	}

	public String getMarkupName() {
		return this.markupName;
	}

	public void setMarkupName(String markupName) {
		this.markupName = markupName;
	}

	public String getDiscountName() {
		return this.discountName;
	}

	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}

}
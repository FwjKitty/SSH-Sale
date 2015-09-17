package com.hand.model;

import java.util.HashSet;
import java.util.Set;

/**
 * SpecialDiscount entity. @author MyEclipse Persistence Tools
 */

public class SpecialDiscount implements java.io.Serializable {

	// Fields

	private Integer discountId;
	private CustomersInfo customersInfo;
	private String discountName;
	private String customerCode;
	private String amount;
	private Long appliedAmount;
	private Long balance;
	private String activity;
	private Set discountAppliedRecordses = new HashSet(0);

	// Constructors

	/** default constructor */
	public SpecialDiscount() {
	}

	/** minimal constructor */
	public SpecialDiscount(CustomersInfo customersInfo, String customerCode,
			String amount, Long appliedAmount, Long balance) {
		this.customersInfo = customersInfo;
		this.customerCode = customerCode;
		this.amount = amount;
		this.appliedAmount = appliedAmount;
		this.balance = balance;
	}

	/** full constructor */
	public SpecialDiscount(CustomersInfo customersInfo, String discountName,
			String customerCode, String amount, Long appliedAmount,
			Long balance, String activity, Set discountAppliedRecordses) {
		this.customersInfo = customersInfo;
		this.discountName = discountName;
		this.customerCode = customerCode;
		this.amount = amount;
		this.appliedAmount = appliedAmount;
		this.balance = balance;
		this.activity = activity;
		this.discountAppliedRecordses = discountAppliedRecordses;
	}

	// Property accessors

	public Integer getDiscountId() {
		return this.discountId;
	}

	public void setDiscountId(Integer discountId) {
		this.discountId = discountId;
	}

	public CustomersInfo getCustomersInfo() {
		return this.customersInfo;
	}

	public void setCustomersInfo(CustomersInfo customersInfo) {
		this.customersInfo = customersInfo;
	}

	public String getDiscountName() {
		return this.discountName;
	}

	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}

	public String getCustomerCode() {
		return this.customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Long getAppliedAmount() {
		return this.appliedAmount;
	}

	public void setAppliedAmount(Long appliedAmount) {
		this.appliedAmount = appliedAmount;
	}

	public Long getBalance() {
		return this.balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public String getActivity() {
		return this.activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public Set getDiscountAppliedRecordses() {
		return this.discountAppliedRecordses;
	}

	public void setDiscountAppliedRecordses(Set discountAppliedRecordses) {
		this.discountAppliedRecordses = discountAppliedRecordses;
	}

}
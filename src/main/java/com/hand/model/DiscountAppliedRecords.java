package com.hand.model;

import java.util.Date;

/**
 * DiscountAppliedRecords entity. @author MyEclipse Persistence Tools
 */

public class DiscountAppliedRecords implements java.io.Serializable {

	// Fields

	private Integer recordId;
	private SpecialDiscount specialDiscount;
	private String discountName;
	private String customerCode;
	private String adnIdentifyNum;
	private Long appliedAmount;
	private Date appliedDate;
	private Integer cancel;
	private Date cancelDate;

	// Constructors

	/** default constructor */
	public DiscountAppliedRecords() {
	}

	/** minimal constructor */
	public DiscountAppliedRecords(SpecialDiscount specialDiscount,
			String discountName, String customerCode, String adnIdentifyNum,
			Long appliedAmount, Date appliedDate) {
		this.specialDiscount = specialDiscount;
		this.discountName = discountName;
		this.customerCode = customerCode;
		this.adnIdentifyNum = adnIdentifyNum;
		this.appliedAmount = appliedAmount;
		this.appliedDate = appliedDate;
	}

	/** full constructor */
	public DiscountAppliedRecords(SpecialDiscount specialDiscount,
			String discountName, String customerCode, String adnIdentifyNum,
			Long appliedAmount, Date appliedDate, Integer cancel,
			Date cancelDate) {
		this.specialDiscount = specialDiscount;
		this.discountName = discountName;
		this.customerCode = customerCode;
		this.adnIdentifyNum = adnIdentifyNum;
		this.appliedAmount = appliedAmount;
		this.appliedDate = appliedDate;
		this.cancel = cancel;
		this.cancelDate = cancelDate;
	}

	// Property accessors

	public Integer getRecordId() {
		return this.recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	public SpecialDiscount getSpecialDiscount() {
		return this.specialDiscount;
	}

	public void setSpecialDiscount(SpecialDiscount specialDiscount) {
		this.specialDiscount = specialDiscount;
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

	public String getAdnIdentifyNum() {
		return this.adnIdentifyNum;
	}

	public void setAdnIdentifyNum(String adnIdentifyNum) {
		this.adnIdentifyNum = adnIdentifyNum;
	}

	public Long getAppliedAmount() {
		return this.appliedAmount;
	}

	public void setAppliedAmount(Long appliedAmount) {
		this.appliedAmount = appliedAmount;
	}

	public Date getAppliedDate() {
		return this.appliedDate;
	}

	public void setAppliedDate(Date appliedDate) {
		this.appliedDate = appliedDate;
	}

	public Integer getCancel() {
		return this.cancel;
	}

	public void setCancel(Integer cancel) {
		this.cancel = cancel;
	}

	public Date getCancelDate() {
		return this.cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}

}
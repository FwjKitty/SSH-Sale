package com.hand.model;

/**
 * NormalDiscount entity. @author MyEclipse Persistence Tools
 */

public class NormalDiscount implements java.io.Serializable {

	// Fields

	private Integer normalId;
	private String discountName;
	private String type;
	private String discountBase;
	private Integer baseQty;
	private Integer discountRate;
	private String activity;

	// Constructors

	/** default constructor */
	public NormalDiscount() {
	}

	/** minimal constructor */
	public NormalDiscount(String discountName, String type,
			String discountBase, Integer discountRate) {
		this.discountName = discountName;
		this.type = type;
		this.discountBase = discountBase;
		this.discountRate = discountRate;
	}

	/** full constructor */
	public NormalDiscount(String discountName, String type,
			String discountBase, Integer baseQty, Integer discountRate,
			String activity) {
		this.discountName = discountName;
		this.type = type;
		this.discountBase = discountBase;
		this.baseQty = baseQty;
		this.discountRate = discountRate;
		this.activity = activity;
	}

	// Property accessors

	public Integer getNormalId() {
		return this.normalId;
	}

	public void setNormalId(Integer normalId) {
		this.normalId = normalId;
	}

	public String getDiscountName() {
		return this.discountName;
	}

	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDiscountBase() {
		return this.discountBase;
	}

	public void setDiscountBase(String discountBase) {
		this.discountBase = discountBase;
	}

	public Integer getBaseQty() {
		return this.baseQty;
	}

	public void setBaseQty(Integer baseQty) {
		this.baseQty = baseQty;
	}

	public Integer getDiscountRate() {
		return this.discountRate;
	}

	public void setDiscountRate(Integer discountRate) {
		this.discountRate = discountRate;
	}

	public String getActivity() {
		return this.activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

}
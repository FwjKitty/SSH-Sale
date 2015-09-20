package com.hand.model;

/**
 * PriceListConfig entity. @author MyEclipse Persistence Tools
 */

public class PriceListConfig implements java.io.Serializable {

	// Fields

	private Integer priceListConfigId;
	private CustomersInfo customersInfo;
	private String type;
	private String displayName;
	private String priceListCol;
	private Integer excelCol;
	private String activity;

	// Constructors

	/** default constructor */
	public PriceListConfig() {
	}

	/** minimal constructor */
	public PriceListConfig(CustomersInfo customersInfo, String type,
			String priceListCol, String activity) {
		this.customersInfo = customersInfo;
		this.type = type;
		this.priceListCol = priceListCol;
		this.activity = activity;
	}

	/** full constructor */
	public PriceListConfig(CustomersInfo customersInfo, String type,
			String displayName, String priceListCol, Integer excelCol,
			String activity) {
		this.customersInfo = customersInfo;
		this.type = type;
		this.displayName = displayName;
		this.priceListCol = priceListCol;
		this.excelCol = excelCol;
		this.activity = activity;
	}

	// Property accessors

	public Integer getPriceListConfigId() {
		return this.priceListConfigId;
	}

	public void setPriceListConfigId(Integer priceListConfigId) {
		this.priceListConfigId = priceListConfigId;
	}

	public CustomersInfo getCustomersInfo() {
		return this.customersInfo;
	}

	public void setCustomersInfo(CustomersInfo customersInfo) {
		this.customersInfo = customersInfo;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getPriceListCol() {
		return this.priceListCol;
	}

	public void setPriceListCol(String priceListCol) {
		this.priceListCol = priceListCol;
	}

	public Integer getExcelCol() {
		return this.excelCol;
	}

	public void setExcelCol(Integer excelCol) {
		this.excelCol = excelCol;
	}

	public String getActivity() {
		return this.activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

}
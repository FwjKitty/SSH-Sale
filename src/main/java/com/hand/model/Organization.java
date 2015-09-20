package com.hand.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Organization entity. @author MyEclipse Persistence Tools
 */

public class Organization implements java.io.Serializable {

	// Fields

	private Integer organizationId;
	private String marketArea;
	private String businessManager;
	private String businessAssistant;
	private Set customersInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Organization() {
	}

	/** minimal constructor */
	public Organization(String marketArea, String businessManager,
			String businessAssistant) {
		this.marketArea = marketArea;
		this.businessManager = businessManager;
		this.businessAssistant = businessAssistant;
	}

	/** full constructor */
	public Organization(String marketArea, String businessManager,
			String businessAssistant, Set customersInfos) {
		this.marketArea = marketArea;
		this.businessManager = businessManager;
		this.businessAssistant = businessAssistant;
		this.customersInfos = customersInfos;
	}

	// Property accessors

	public Integer getOrganizationId() {
		return this.organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public String getMarketArea() {
		return this.marketArea;
	}

	public void setMarketArea(String marketArea) {
		this.marketArea = marketArea;
	}

	public String getBusinessManager() {
		return this.businessManager;
	}

	public void setBusinessManager(String businessManager) {
		this.businessManager = businessManager;
	}

	public String getBusinessAssistant() {
		return this.businessAssistant;
	}

	public void setBusinessAssistant(String businessAssistant) {
		this.businessAssistant = businessAssistant;
	}

	public Set getCustomersInfos() {
		return this.customersInfos;
	}

	public void setCustomersInfos(Set customersInfos) {
		this.customersInfos = customersInfos;
	}

}
package com.hand.model;

import java.util.Date;

/**
 * PriceList entity. @author MyEclipse Persistence Tools
 */

public class PriceList implements java.io.Serializable {

	// Fields

	private Integer priceListId;
	private CustomersInfo customersInfo;
	private String type;
	private String hyItem;
	private Date effectiveDateFrom;
	private Date effectiveDateTo;
	private String userDef1;
	private String userDef2;
	private String userDef3;
	private String userDef4;
	private String userDef5;
	private String userDef6;
	private String userDef7;
	private String userDef8;
	private String userDef9;
	private String userDef10;
	private String userDef11;
	private String userDef12;
	private String userDef13;
	private String userDef14;
	private String userDef15;
	private String userDef16;
	private String userDef17;
	private String userDef18;
	private String userDef19;
	private String userDef20;
	private String userDef21;
	private String userDef22;
	private String userDef23;
	private String userDef24;
	private String userDef25;
	private String userDef26;
	private String userDef27;
	private String userDef28;
	private String userDef29;
	private String userDef30;

	// Constructors

	/** default constructor */
	public PriceList() {
	}

	/** minimal constructor */
	public PriceList(CustomersInfo customersInfo, String type, String hyItem) {
		this.customersInfo = customersInfo;
		this.type = type;
		this.hyItem = hyItem;
	}

	/** full constructor */
	public PriceList(CustomersInfo customersInfo, String type, String hyItem,
			Date effectiveDateFrom, Date effectiveDateTo, String userDef1,
			String userDef2, String userDef3, String userDef4, String userDef5,
			String userDef6, String userDef7, String userDef8, String userDef9,
			String userDef10, String userDef11, String userDef12,
			String userDef13, String userDef14, String userDef15,
			String userDef16, String userDef17, String userDef18,
			String userDef19, String userDef20, String userDef21,
			String userDef22, String userDef23, String userDef24,
			String userDef25, String userDef26, String userDef27,
			String userDef28, String userDef29, String userDef30) {
		this.customersInfo = customersInfo;
		this.type = type;
		this.hyItem = hyItem;
		this.effectiveDateFrom = effectiveDateFrom;
		this.effectiveDateTo = effectiveDateTo;
		this.userDef1 = userDef1;
		this.userDef2 = userDef2;
		this.userDef3 = userDef3;
		this.userDef4 = userDef4;
		this.userDef5 = userDef5;
		this.userDef6 = userDef6;
		this.userDef7 = userDef7;
		this.userDef8 = userDef8;
		this.userDef9 = userDef9;
		this.userDef10 = userDef10;
		this.userDef11 = userDef11;
		this.userDef12 = userDef12;
		this.userDef13 = userDef13;
		this.userDef14 = userDef14;
		this.userDef15 = userDef15;
		this.userDef16 = userDef16;
		this.userDef17 = userDef17;
		this.userDef18 = userDef18;
		this.userDef19 = userDef19;
		this.userDef20 = userDef20;
		this.userDef21 = userDef21;
		this.userDef22 = userDef22;
		this.userDef23 = userDef23;
		this.userDef24 = userDef24;
		this.userDef25 = userDef25;
		this.userDef26 = userDef26;
		this.userDef27 = userDef27;
		this.userDef28 = userDef28;
		this.userDef29 = userDef29;
		this.userDef30 = userDef30;
	}

	// Property accessors

	public Integer getPriceListId() {
		return this.priceListId;
	}

	public void setPriceListId(Integer priceListId) {
		this.priceListId = priceListId;
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

	public String getHyItem() {
		return this.hyItem;
	}

	public void setHyItem(String hyItem) {
		this.hyItem = hyItem;
	}

	public Date getEffectiveDateFrom() {
		return this.effectiveDateFrom;
	}

	public void setEffectiveDateFrom(Date effectiveDateFrom) {
		this.effectiveDateFrom = effectiveDateFrom;
	}

	public Date getEffectiveDateTo() {
		return this.effectiveDateTo;
	}

	public void setEffectiveDateTo(Date effectiveDateTo) {
		this.effectiveDateTo = effectiveDateTo;
	}

	public String getUserDef1() {
		return this.userDef1;
	}

	public void setUserDef1(String userDef1) {
		this.userDef1 = userDef1;
	}

	public String getUserDef2() {
		return this.userDef2;
	}

	public void setUserDef2(String userDef2) {
		this.userDef2 = userDef2;
	}

	public String getUserDef3() {
		return this.userDef3;
	}

	public void setUserDef3(String userDef3) {
		this.userDef3 = userDef3;
	}

	public String getUserDef4() {
		return this.userDef4;
	}

	public void setUserDef4(String userDef4) {
		this.userDef4 = userDef4;
	}

	public String getUserDef5() {
		return this.userDef5;
	}

	public void setUserDef5(String userDef5) {
		this.userDef5 = userDef5;
	}

	public String getUserDef6() {
		return this.userDef6;
	}

	public void setUserDef6(String userDef6) {
		this.userDef6 = userDef6;
	}

	public String getUserDef7() {
		return this.userDef7;
	}

	public void setUserDef7(String userDef7) {
		this.userDef7 = userDef7;
	}

	public String getUserDef8() {
		return this.userDef8;
	}

	public void setUserDef8(String userDef8) {
		this.userDef8 = userDef8;
	}

	public String getUserDef9() {
		return this.userDef9;
	}

	public void setUserDef9(String userDef9) {
		this.userDef9 = userDef9;
	}

	public String getUserDef10() {
		return this.userDef10;
	}

	public void setUserDef10(String userDef10) {
		this.userDef10 = userDef10;
	}

	public String getUserDef11() {
		return this.userDef11;
	}

	public void setUserDef11(String userDef11) {
		this.userDef11 = userDef11;
	}

	public String getUserDef12() {
		return this.userDef12;
	}

	public void setUserDef12(String userDef12) {
		this.userDef12 = userDef12;
	}

	public String getUserDef13() {
		return this.userDef13;
	}

	public void setUserDef13(String userDef13) {
		this.userDef13 = userDef13;
	}

	public String getUserDef14() {
		return this.userDef14;
	}

	public void setUserDef14(String userDef14) {
		this.userDef14 = userDef14;
	}

	public String getUserDef15() {
		return this.userDef15;
	}

	public void setUserDef15(String userDef15) {
		this.userDef15 = userDef15;
	}

	public String getUserDef16() {
		return this.userDef16;
	}

	public void setUserDef16(String userDef16) {
		this.userDef16 = userDef16;
	}

	public String getUserDef17() {
		return this.userDef17;
	}

	public void setUserDef17(String userDef17) {
		this.userDef17 = userDef17;
	}

	public String getUserDef18() {
		return this.userDef18;
	}

	public void setUserDef18(String userDef18) {
		this.userDef18 = userDef18;
	}

	public String getUserDef19() {
		return this.userDef19;
	}

	public void setUserDef19(String userDef19) {
		this.userDef19 = userDef19;
	}

	public String getUserDef20() {
		return this.userDef20;
	}

	public void setUserDef20(String userDef20) {
		this.userDef20 = userDef20;
	}

	public String getUserDef21() {
		return this.userDef21;
	}

	public void setUserDef21(String userDef21) {
		this.userDef21 = userDef21;
	}

	public String getUserDef22() {
		return this.userDef22;
	}

	public void setUserDef22(String userDef22) {
		this.userDef22 = userDef22;
	}

	public String getUserDef23() {
		return this.userDef23;
	}

	public void setUserDef23(String userDef23) {
		this.userDef23 = userDef23;
	}

	public String getUserDef24() {
		return this.userDef24;
	}

	public void setUserDef24(String userDef24) {
		this.userDef24 = userDef24;
	}

	public String getUserDef25() {
		return this.userDef25;
	}

	public void setUserDef25(String userDef25) {
		this.userDef25 = userDef25;
	}

	public String getUserDef26() {
		return this.userDef26;
	}

	public void setUserDef26(String userDef26) {
		this.userDef26 = userDef26;
	}

	public String getUserDef27() {
		return this.userDef27;
	}

	public void setUserDef27(String userDef27) {
		this.userDef27 = userDef27;
	}

	public String getUserDef28() {
		return this.userDef28;
	}

	public void setUserDef28(String userDef28) {
		this.userDef28 = userDef28;
	}

	public String getUserDef29() {
		return this.userDef29;
	}

	public void setUserDef29(String userDef29) {
		this.userDef29 = userDef29;
	}

	public String getUserDef30() {
		return this.userDef30;
	}

	public void setUserDef30(String userDef30) {
		this.userDef30 = userDef30;
	}

}
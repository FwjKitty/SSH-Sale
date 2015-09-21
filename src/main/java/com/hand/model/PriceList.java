package com.hand.model;

import java.util.Date;

/**
 * PriceList entity. @author MyEclipse Persistence Tools
 */

public class PriceList implements java.io.Serializable {

	// Fields

	private Integer price_list_id;
	private CustomersInfo customersInfo;
	private String type;
	private String hy_item;
	private Date effective_date_from;
	private Date effective_date_to;
	private String user_def1;
	private String user_def2;
	private String user_def3;
	private String user_def4;
	private String user_def5;
	private String user_def6;
	private String user_def7;
	private String user_def8;
	private String user_def9;
	private String user_def10;
	private String user_def11;
	private String user_def12;
	private String user_def13;
	private String user_def14;
	private String user_def15;
	private String user_def16;
	private String user_def17;
	private String user_def18;
	private String user_def19;
	private String user_def20;
	private String user_def21;
	private String user_def22;
	private String user_def23;
	private String user_def24;
	private String user_def25;
	private String user_def26;
	private String user_def27;
	private String user_def28;
	private String user_def29;
	private String user_def30;

	// Constructors

	/** default constructor */
	public PriceList() {
	}

	/** minimal constructor */
	public PriceList(CustomersInfo customersInfo, String type, String hy_item) {
		this.customersInfo = customersInfo;
		this.type = type;
		this.hy_item = hy_item;
	}

	/** full constructor */
	public PriceList(CustomersInfo customersInfo, String type, String hy_item,
			Date effective_date_from, Date effective_date_to, String user_def1,
			String user_def2, String user_def3, String user_def4, String user_def5,
			String user_def6, String user_def7, String user_def8, String user_def9,
			String user_def10, String user_def11, String user_def12,
			String user_def13, String user_def14, String user_def15,
			String user_def16, String user_def17, String user_def18,
			String user_def19, String user_def20, String user_def21,
			String user_def22, String user_def23, String user_def24,
			String user_def25, String user_def26, String user_def27,
			String user_def28, String user_def29, String user_def30) {
		this.customersInfo = customersInfo;
		this.type = type;
		this.hy_item = hy_item;
		this.effective_date_from = effective_date_from;
		this.effective_date_to = effective_date_to;
		this.user_def1 = user_def1;
		this.user_def2 = user_def2;
		this.user_def3 = user_def3;
		this.user_def4 = user_def4;
		this.user_def5 = user_def5;
		this.user_def6 = user_def6;
		this.user_def7 = user_def7;
		this.user_def8 = user_def8;
		this.user_def9 = user_def9;
		this.user_def10 = user_def10;
		this.user_def11 = user_def11;
		this.user_def12 = user_def12;
		this.user_def13 = user_def13;
		this.user_def14 = user_def14;
		this.user_def15 = user_def15;
		this.user_def16 = user_def16;
		this.user_def17 = user_def17;
		this.user_def18 = user_def18;
		this.user_def19 = user_def19;
		this.user_def20 = user_def20;
		this.user_def21 = user_def21;
		this.user_def22 = user_def22;
		this.user_def23 = user_def23;
		this.user_def24 = user_def24;
		this.user_def25 = user_def25;
		this.user_def26 = user_def26;
		this.user_def27 = user_def27;
		this.user_def28 = user_def28;
		this.user_def29 = user_def29;
		this.user_def30 = user_def30;
	}

	// Property accessors

	public Integer getPrice_list_id() {
		return this.price_list_id;
	}

	public void setPrice_list_id(Integer price_list_id) {
		this.price_list_id = price_list_id;
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

	public String getHy_item() {
		return this.hy_item;
	}

	public void setHy_item(String hy_item) {
		this.hy_item = hy_item;
	}

	public Date getEffective_date_from() {
		return this.effective_date_from;
	}

	public void setEffective_date_from(Date effective_date_from) {
		this.effective_date_from = effective_date_from;
	}

	public Date getEffective_date_to() {
		return this.effective_date_to;
	}

	public void setEffective_date_to(Date effective_date_to) {
		this.effective_date_to = effective_date_to;
	}

	public String getUser_def1() {
		return this.user_def1;
	}

	public void setUser_def1(String user_def1) {
		this.user_def1 = user_def1;
	}

	public String getUser_def2() {
		return this.user_def2;
	}

	public void setUser_def2(String user_def2) {
		this.user_def2 = user_def2;
	}

	public String getUser_def3() {
		return this.user_def3;
	}

	public void setUser_def3(String user_def3) {
		this.user_def3 = user_def3;
	}

	public String getUser_def4() {
		return this.user_def4;
	}

	public void setUser_def4(String user_def4) {
		this.user_def4 = user_def4;
	}

	public String getUser_def5() {
		return this.user_def5;
	}

	public void setUser_def5(String user_def5) {
		this.user_def5 = user_def5;
	}

	public String getUser_def6() {
		return this.user_def6;
	}

	public void setUser_def6(String user_def6) {
		this.user_def6 = user_def6;
	}

	public String getUser_def7() {
		return this.user_def7;
	}

	public void setUser_def7(String user_def7) {
		this.user_def7 = user_def7;
	}

	public String getUser_def8() {
		return this.user_def8;
	}

	public void setUser_def8(String user_def8) {
		this.user_def8 = user_def8;
	}

	public String getUser_def9() {
		return this.user_def9;
	}

	public void setUser_def9(String user_def9) {
		this.user_def9 = user_def9;
	}

	public String getUser_def10() {
		return this.user_def10;
	}

	public void setUser_def10(String user_def10) {
		this.user_def10 = user_def10;
	}

	public String getUser_def11() {
		return this.user_def11;
	}

	public void setUser_def11(String user_def11) {
		this.user_def11 = user_def11;
	}

	public String getUser_def12() {
		return this.user_def12;
	}

	public void setUser_def12(String user_def12) {
		this.user_def12 = user_def12;
	}

	public String getUser_def13() {
		return this.user_def13;
	}

	public void setUser_def13(String user_def13) {
		this.user_def13 = user_def13;
	}

	public String getUser_def14() {
		return this.user_def14;
	}

	public void setUser_def14(String user_def14) {
		this.user_def14 = user_def14;
	}

	public String getUser_def15() {
		return this.user_def15;
	}

	public void setUser_def15(String user_def15) {
		this.user_def15 = user_def15;
	}

	public String getUser_def16() {
		return this.user_def16;
	}

	public void setUser_def16(String user_def16) {
		this.user_def16 = user_def16;
	}

	public String getUser_def17() {
		return this.user_def17;
	}

	public void setUser_def17(String user_def17) {
		this.user_def17 = user_def17;
	}

	public String getUser_def18() {
		return this.user_def18;
	}

	public void setUser_def18(String user_def18) {
		this.user_def18 = user_def18;
	}

	public String getUser_def19() {
		return this.user_def19;
	}

	public void setUser_def19(String user_def19) {
		this.user_def19 = user_def19;
	}

	public String getUser_def20() {
		return this.user_def20;
	}

	public void setUser_def20(String user_def20) {
		this.user_def20 = user_def20;
	}

	public String getUser_def21() {
		return this.user_def21;
	}

	public void setUser_def21(String user_def21) {
		this.user_def21 = user_def21;
	}

	public String getUser_def22() {
		return this.user_def22;
	}

	public void setUser_def22(String user_def22) {
		this.user_def22 = user_def22;
	}

	public String getUser_def23() {
		return this.user_def23;
	}

	public void setUser_def23(String user_def23) {
		this.user_def23 = user_def23;
	}

	public String getUser_def24() {
		return this.user_def24;
	}

	public void setUser_def24(String user_def24) {
		this.user_def24 = user_def24;
	}

	public String getUser_def25() {
		return this.user_def25;
	}

	public void setUser_def25(String user_def25) {
		this.user_def25 = user_def25;
	}

	public String getUser_def26() {
		return this.user_def26;
	}

	public void setUser_def26(String user_def26) {
		this.user_def26 = user_def26;
	}

	public String getUser_def27() {
		return this.user_def27;
	}

	public void setUser_def27(String user_def27) {
		this.user_def27 = user_def27;
	}

	public String getUser_def28() {
		return this.user_def28;
	}

	public void setUser_def28(String user_def28) {
		this.user_def28 = user_def28;
	}

	public String getUser_def29() {
		return this.user_def29;
	}

	public void setUser_def29(String user_def29) {
		this.user_def29 = user_def29;
	}

	public String getUser_def30() {
		return this.user_def30;
	}

	public void setUser_def30(String user_def30) {
		this.user_def30 = user_def30;
	}

}
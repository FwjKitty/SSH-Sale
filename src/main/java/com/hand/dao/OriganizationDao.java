package com.hand.dao;

import java.util.List;

import com.hand.model.Organization;

public interface OriganizationDao {

	public List<Organization> getOriganization();
	public Organization getOriganization(int customer_id);
	public void update(Organization origanization, int addressid);
	public void add(Organization origanization);
	public void delete(Organization origanization);
	
}

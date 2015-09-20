package com.hand.dao;

import java.util.List;

import com.hand.model.Address;
import com.hand.model.CustomersInfo;

public interface AddressDao {
	
	public List<Address> getAddress();
	public Address getAddress(int  customer);
	
	public void update(Address address, int addressid);
	public void add(Address address);
	public void delete(Address address);
	
}


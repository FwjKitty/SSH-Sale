package com.hand.dao;

import java.util.List;
import com.hand.model.Contactors;

public interface ContactorsDao {
	public List<Contactors> getContactors();
	public Contactors getContactors(int customer_id);
	
	public void update(Contactors contactors, int Contactors_id);
	public void add(Contactors contactors);
	public void delete(Contactors contactors);
}

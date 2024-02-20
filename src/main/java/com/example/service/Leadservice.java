package com.example.service;

import java.util.List;

import com.example.entity.Lead;

public interface Leadservice {
	public void saveLead(Lead lead);

	public List <Lead> findAllLeads();

	public void deleteLeadById(long id);

	public Lead findLeadById(long id);

}

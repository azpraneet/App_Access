package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Lead;
import com.example.repository.LeadRepository;
@Service
public class LeadserviceImpl implements Leadservice {
	@Autowired
	private LeadRepository leadrepo;
	
	@Override
	public void saveLead(Lead lead) {
		leadrepo.save(lead);
	}

	@Override
	public List<Lead> findAllLeads() {
		List<Lead> leads = leadrepo.findAll();
		return leads;
	}

	@Override
	public void deleteLeadById(long id) {
		leadrepo.deleteById(id);
		
		
	}

	@Override
	public Lead findLeadById(long id) {
		Optional<Lead> findById = leadrepo.findById(id);
		Lead lead=findById.get();
		return lead;
	}

	
	
		
	}



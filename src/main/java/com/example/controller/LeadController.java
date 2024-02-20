package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Dto.Leaddto;
import com.example.entity.Lead;
import com.example.service.Leadservice;
import com.example.util.EmailService;
@Controller
public class LeadController {
	@Autowired
	private Leadservice leadService;
	@Autowired
	private EmailService emailservice;
	
	@RequestMapping("/createLead")
	public String createViewLead() {
		return "create_lead";
	}
	@RequestMapping("/saveLead")
	public String saveOneLead(@ModelAttribute Lead lead, Model model) {
		leadService.saveLead(lead);
		emailservice.sendEmail(lead.getEmail(), "test", "Hello you");
		model.addAttribute("msg", "Lead is Saved!!");
		return "create_lead";
	}
	
//	@RequestMapping("/saveLead")
//	public String saveOneLead(@RequestParam ("firstname") String firstname,@RequestParam ("lastname") String lastname,@RequestParam ("email") String email,@RequestParam ("mobile") long mobile,ModelMap model) {
//		Lead l = new Lead();
//		l.setFirstname(firstname);
//		l.setLastname(lastname);
//		l.setEmail(email);
//		l.setMobile(mobile);
//		model.addAttribute("msg", "Lead Saved");
//		leadService.saveLead(l);
//		return "create_lead";
//	}
//	@RequestMapping("/saveLead")
//	public String saveOneLead(Leaddto dto, Model model) {
//		Lead lead = new Lead();
//		lead.setFirstname(dto.getFirstname());
//		lead.setLastname(dto.getLastname());
//		lead.setEmail(dto.getEmail());
//		lead.setMobile(dto.getMobile());
//		leadService.saveLead(lead);
//		model.addAttribute("msg", "Lead is Saved!!");
//		return "create_lead";
//	} 
	@RequestMapping("/list")
	public String getAllLeads(Model model) {
		List<Lead> leads = leadService.findAllLeads();
		model.addAttribute("leads", leads);
		return"list_leads";
	}
	@RequestMapping("/delete")
	public String deleteLeadById(@RequestParam("id")long id, Model model) {
		leadService.deleteLeadById(id);
		List<Lead> leads = leadService.findAllLeads();
		model.addAttribute("leads", leads);
		return"list_leads";
		
	}
	@RequestMapping("/update")
	public String updateLead(@RequestParam ("id") long id,Model model) {
		Lead lead =leadService.findLeadById(id);
		model.addAttribute("lead", lead);
		return "update_lead";
	}
	@RequestMapping("/editreg")
	public String editReg(Leaddto dto, Model model ) {
		Lead lead = new Lead();
		lead.setId(dto.getId());
		lead.setFirstname(dto.getFirstname());
		lead.setLastname(dto.getLastname());
		lead.setEmail(dto.getEmail());
		lead.setMobile(dto.getMobile());
		leadService.saveLead(lead);
		List<Lead> leads = leadService.findAllLeads();
		model.addAttribute("leads", leads);
		return"list_leads";
	}
	
}

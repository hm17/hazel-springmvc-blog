package com.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Entry;
import com.example.service.EntryService;

@Controller
public class EntryController {

	@Autowired
	private EntryService entryService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addEntry(@ModelAttribute("entry") Entry entry, BindingResult result) {
		entryService.addEntry(entry);
		return "redirect:/entries/";
	}
	
	@RequestMapping("/")
	public String listEntries(Map<String, Object> map) {
		map.put("entry", new Entry());
		map.put("entries", entryService.listEntries());
		
		return "entries";
	}
	
	@RequestMapping("/delete/{entryId}")
	public String deleteEntry(@PathVariable("entryId") Integer entryId) {
		entryService.removeEntry(entryId);
		return "redirect:/entries/";
	}
}

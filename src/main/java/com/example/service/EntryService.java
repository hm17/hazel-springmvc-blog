package com.example.service;

import java.util.List;

import com.example.model.Entry;

public interface EntryService {

	public void addEntry(Entry entry);
	public List<Entry> listEntries();
	public void removeEntry(Integer id);
}

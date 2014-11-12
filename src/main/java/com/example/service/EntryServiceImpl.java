package com.example.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Entry;

@Service
public class EntryServiceImpl implements EntryService {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public void addEntry(Entry entry) {
		em.persist(entry);
	}
	
	@Transactional
	public List<Entry> listEntries() {
		CriteriaQuery<Entry> c = em.getCriteriaBuilder().createQuery(Entry.class);
		c.from(Entry.class);
		return em.createQuery(c).getResultList();
	}
	
	public void removeEntry(Integer id) {
		Entry entry = em.find(Entry.class, id);
		if (null != entry) {
			em.remove(entry);
		}
	}
	
}

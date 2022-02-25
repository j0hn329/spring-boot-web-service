package com.assignment.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// defines the business logic 
@Service
public class ContactService {

	// injects an instance of ContactRepository
	@Autowired
	ContactRepository repository;

	/**
	 * @return the contact records that match the searchString 
	 * 	using the search() method of CrudRepository if searchString is not null
	 * 
	 * @return all the contact records using the findAll() method of CrudRepository
	 * 	if the searchString is null 
	 */
	public List<Contact> getSearch(String searchString) {
		if (searchString != null) {
			return repository.search(searchString);
		}
		return repository.findAll();
	}
	
	/**
	 * saving a contact using the save() method of CrudRepository
	 */
	public void createContact(Contact contact) {
		repository.save(contact);
	}

	/**
	 * getting a specific contact using the findById method of CrudRepository
	 */
	public Contact getContact(String telephoneNumber) {
		return repository.findById(telephoneNumber).get();
	}

	/**
	 * deleting a specific contact using deleteById() method of CrudRepository
	 */
	public void deleteContact(String telephoneNumber) {
		repository.deleteById(telephoneNumber);
	}
}
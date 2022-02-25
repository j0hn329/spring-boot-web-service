package com.assignment.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * repository interface is a mechanism for encapsulating storage, retrieval, and
 * search behaviour repository emulates a collection of objects
 */
@Repository
public interface ContactRepository extends CrudRepository<Contact, String> {

	// creates a database query that selects Contacts with similar entries in any
	// column to that of the searchString
	@Query("SELECT p FROM Contact p WHERE CONCAT(p.telephoneNumber, p.lastName, p.firstName, p.address, p.city, p.postcode) LIKE %?1%")
	public List<Contact> search(String searchString);

	// returns a list of all Contacts within the database
	public List<Contact> findAll();

}

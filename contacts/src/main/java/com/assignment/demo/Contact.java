package com.assignment.demo;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

// specifies the class Contact is an entity and is mapped to a database table
@Entity

// specifies the name of the database table to be used for mapping 
@Table(name = "contact")
public class Contact {

	// specifies the primary key of the entity
	@Id
	// specifies the column name
	@Column(name = "telephoneNumber")
	// used to validate regex pattern - phone number must be 11 consecutive digits
	@Pattern(regexp = "^\\d{11}$", message = "Valid UK phone number required")
	private String telephoneNumber;

	@Column(name = "lastName")
	// used to validate regex pattern - lastName must only contain alphabetic
	// characters
	@Pattern(regexp = "[A-Za-z]+", message = "Valid last name required")
	private String lastName;

	@Column(name = "firstName")
	// used to validate regex pattern - firstName must only contain alphabetic
	// characters
	@Pattern(regexp = "[A-Za-z]+", message = "Valid first name required")
	private String firstName;

	@Column(name = "address")
	// used to validate regex pattern - address can contain alphanumeric characters
	// and whitespace
	@Pattern(regexp = "[A-Za-z0-9 ]+", message = "Valid address required")
	private String address;

	@Column(name = "city")
	// used to validate regex pattern - city can contain alphanumeric characters and
	// whitespace
	@Pattern(regexp = "[A-Za-z ]+", message = "Valid town/city required")
	private String city;

	@Column(name = "postcode")
	// used to validate regex pattern - postcode must be in a correct UK format
	@Pattern(regexp = "[A-Za-z]{1,2}[0-9Rr][0-9A-Za-z]? [0-9][ABD-HJLNP-UW-Zabd-hjlnp-uw-z]{2}", message = "Valid UK postcode required")
	private String postcode;

	public Contact() {
	}

	/**
	 * creates an object of the Contact class containing all the information
	 * associated with a contact
	 */
	public Contact(String telephoneNumber, String lastName, String firstName, String address, String city,
			String postcode) {
		this.telephoneNumber = telephoneNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.city = city;
		this.postcode = postcode;
	}

	/**
	 * @return the telephone number
	 */
	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	/**
	 * @param set the telephone number
	 */
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	/**
	 * @return the last name of the contact
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param set the last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the first name of the contact
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param set the first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the current address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param set the address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the current city/town
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param set the city/town
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the current postcode
	 */
	public String getPostcode() {
		return postcode;
	}

	/**
	 * @param set the postcode
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
	 * @return the string representation of the contact object
	 */
	@Override
	public String toString() {
		return "Contact{" + "telephoneNumber='" + telephoneNumber + '\'' + ", lastName='" + lastName + '\''
				+ ", firstName='" + firstName + +'\'' + ", address='" + address + '\'' + ", city='" + city + '\''
				+ ", postcode='" + postcode + '\'' + '}';
	}
}

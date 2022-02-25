package com.assignment.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import javax.validation.Valid;

// defines the class as a Spring MVC controller 
@RestController
// indicates all handling methods are relative to the '/' path
@RequestMapping("/")
public class ContactController {

	// injects an instance of ContactService
	@Autowired
	private ContactService service;
	
	/**
	 * creates a mapping that retrieves the list of contacts similar to the searchString 
	 * @Return the index view 
	 */
	@RequestMapping("/contacts")
	public ModelAndView findContacts(Model model, @Param("searchString") String searchString) {
		List<Contact> listContacts = service.getSearch(searchString);
		model.addAttribute("listContacts", listContacts);
		model.addAttribute("searchString", searchString); 

		return new ModelAndView("index");
	}
	
	/**
	 * creates a mapping that adds a new contact 
	 * @Return the add contact view 
	 */
	@RequestMapping("/new")
	public ModelAndView addContact(Model model) {
		Contact contact = new Contact();
		model.addAttribute("contact", contact);

		return new ModelAndView("add_contact");
	}

	/**
	 * creates a mapping that edits a contact specified with its telephone number
	 * @Return the edit contact view
	 */
	@RequestMapping("/edit/{telephoneNumber}")
	public ModelAndView editContact(@PathVariable(name = "telephoneNumber") String telephoneNumber) {
		ModelAndView modv = new ModelAndView("edit_contact");
		Contact contact = service.getContact(telephoneNumber);
		modv.addObject("contact", contact);

		return modv;
	}

	/**
	 * creates a mapping that deletes a contact specified with its telephone number 
	 * @return a redirection to the '/' mapping
	 */
	@RequestMapping("/delete/{telephoneNumber}")
	public ModelAndView deleteContact(@PathVariable(name = "telephoneNumber") String telephoneNumber) {
		service.deleteContact(telephoneNumber);

		return new ModelAndView("redirect:/");
	}

	/**
	 * @return the add contact view if validation errors are present 
	 * @return a redirection to the '/' mapping otherwise 
	 */
	@RequestMapping("/add")
	public ModelAndView saveNewContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult bindRes) {

		if (bindRes.hasErrors()) {
			return new ModelAndView("add_contact");
		}

		service.createContact(contact);

		return new ModelAndView("redirect:/");
	}

	/**
	 * @return the edit contact view if validation errors are present 
	 * @return a redirection to the '/' mapping otherwise 
	 */
	@RequestMapping("/update")
	public ModelAndView saveUpdateContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult bindRes) {

		if (bindRes.hasErrors()) {
			return new ModelAndView("edit_contact");
		}

		service.createContact(contact);

		return new ModelAndView("redirect:/");
	}
}

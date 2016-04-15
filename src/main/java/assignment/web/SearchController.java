package assignment.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import assignment.model.Contact;
import assignment.model.Organisation;
import assignment.service.ContactService;

@Controller
public class SearchController {

	@Autowired
	private ContactService contactService;

	@Autowired
	WebUtil webUtil;

	@RequestMapping(value = "/searchContact", method = RequestMethod.GET)
	String initSearchPage() {
		return "search";
	}

	@RequestMapping(value = "/searchContact", method = RequestMethod.POST)
	String searchContact(Contact contact, ModelMap model) {
		model.addAttribute("contact", contact);
		List<Contact> contacts = this.contactService.findByFirstNameLastNameOrg(contact.getFirstName(),
				contact.getLastName(), contact.getOrg().getName());
		if (contacts.size() == 1) {
			model.addAttribute("contact", contacts.get(0));
			return "view";
		}
		model.addAttribute("contacts", contacts);
		return "search";
	}

	@ModelAttribute("contact")
	public Contact contact() {
		Contact contact = new Contact();
		contact.setOrg(new Organisation());
		return contact;
	}

	@ModelAttribute("webUtil")
	public WebUtil webUtil() {
		return this.webUtil;
	}

	// Automatically trim space for form input
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
	}
}

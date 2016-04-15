package assignment.web;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import assignment.model.Contact;
import assignment.model.Organisation;
import assignment.service.ContactService;
import assignment.service.OrganisationService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

	@Autowired
	private WebUtil webUtil;

	@Autowired
	private OrganisationService orgService;

	@RequestMapping("/viewContact")
	public String viewContact(int contactId, ModelMap model) {
		return "view";
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/editContact", method = RequestMethod.GET)
	public String editContact(int contactId, ModelMap model) {
		Iterator<Organisation> it = this.orgService.getAll().iterator();
		Map orgMap = new HashMap();
		orgMap.put(null, "--");
		while (it.hasNext()) {
			Organisation org = (Organisation) it.next();
			orgMap.put(org.getId(), this.webUtil.formatNameWithABN(org));
		}
		model.addAttribute("orgMap", orgMap);
		return "edit";
	}

	@RequestMapping(value = "/editContact", method = RequestMethod.POST)
	public String saveContact(@Valid Contact contact, BindingResult bindingResult, ModelMap model) {
		if (bindingResult.hasErrors()) {
			return "edit";
		}
		// Contact can have no organisation
		if (contact.getOrg() != null && contact.getOrg().getId() == null) {
			contact.setOrg(null);
		}
		this.contactService.updateContact(contact);
		// reload contact to reload org info.
		contact = this.contactService.findById(contact.getId());
		model.addAttribute("contact", contact);
		return "view";
	}

	@ModelAttribute
	public Contact getContact(@RequestParam Integer contactId) {
		Contact contact = this.contactService.findById(contactId);
		return contact;
	}

	@ModelAttribute
	private WebUtil webUtil() {
		return this.webUtil;
	}

	/* Converts empty strings into null for org.id when form is submitted */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Integer.class, "org.id", new StringTrimmerEditor(true));
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
	}
}

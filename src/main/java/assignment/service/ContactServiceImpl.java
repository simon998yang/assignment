package assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import assignment.dao.ContactDao;
import assignment.model.Contact;

@Service("contactService")
@Transactional
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDao dao;

	@Override
	public Contact findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Contact> findByFirstNameLastNameOrg(String firstName, String lastName, String orgName) {
		return this.dao.findByFirstNameLastNameOrg(firstName, lastName, orgName);
	}

	@Override
	public void updateContact(Contact contact) {
		this.dao.updateContact(contact);
	}

}

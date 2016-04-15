package assignment.dao;

import java.util.List;

import assignment.model.Contact;

public interface ContactDao {
	Contact findById(int id);

	List<Contact> findByFirstNameLastNameOrg(String firstName, String lastName, String orgName);

	void updateContact(Contact contact);

}

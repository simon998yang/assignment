package assignment.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import assignment.model.Contact;

@Repository("contactDao")
@Transactional
public class ContactDaoImpl implements ContactDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Contact findById(int id) {
		return (Contact) this.sessionFactory.getCurrentSession().get(Contact.class, id);
	}

	@Override
	public void updateContact(Contact contact) {
		this.sessionFactory.getCurrentSession().update(contact);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Contact> findByFirstNameLastNameOrg(String firstName, String lastName, String orgName) {
		// if no criteria is given, then return
		if (firstName.length() == 0 && lastName.length() == 0 && orgName.length() == 0)
			return new ArrayList();

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Contact.class);
		criteria.createAlias("org", "org", JoinType.LEFT_OUTER_JOIN);
		Disjunction or = Restrictions.disjunction();
		// "*" can be used as wildcard so replace "*" with "%", also use ilike
		// for case insensitive
		if (firstName.length() > 0)
			or.add(Restrictions.ilike("firstName", firstName.replace("*", "%"), MatchMode.START));
		if (lastName.length() > 0)
			or.add(Restrictions.ilike("lastName", lastName.replace("*", "%"), MatchMode.START));
		if (orgName.length() > 0)
			or.add(Restrictions.ilike("org.name", orgName.replace("*", "%"), MatchMode.START));
		criteria.add(or);
		List<Contact> list = criteria.list();
		return list;

	}
}

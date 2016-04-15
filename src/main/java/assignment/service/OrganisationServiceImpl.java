package assignment.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import assignment.model.Organisation;

@Service("organasitionService")
@Transactional
public class OrganisationServiceImpl implements OrganisationService {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Organisation> getAll() {
		return this.sessionFactory.getCurrentSession().createQuery("from Organisation").list();
	}
}

package assignment.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import assignment.AssignmentApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(AssignmentApplication.class)
public class OrganisationServiceTest {

	@Autowired
	private OrganisationService orgService;

	@Test
	public void testLoadAll() {
		List<?> orgs = this.orgService.getAll();
		assertEquals("Initiated 5 organisations", 5, orgs.size());		
	}

}

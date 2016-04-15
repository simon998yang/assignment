package assignment.dao;

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
public class ContactDaoImplTest {

	@Autowired
	private ContactDao contactDao;

	@Test
	public void testFindByFirstNameLastNameOrg() {
		String d = "df";
		System.out.println(d);
		List<?> lst = this.contactDao.findByFirstNameLastNameOrg("tom", "", "");
		assertEquals("Should return 1 record", 1, lst.size());
	}

}

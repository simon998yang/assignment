package assignment.web;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import assignment.AssignmentApplication;
import assignment.model.Organisation;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(AssignmentApplication.class)
public class WebUtilTest {

	@Autowired
	private WebUtil webUtil;

	@Test
	public void testFormatABN() {
		Organisation org = new Organisation();
		org.setAbn("12345678901");
		org.setName("name");
		String formatedABN = webUtil.formatNameWithABN(org);
		assertEquals("should equals name (12 345 678 901)", "name (12 345 678 901)", formatedABN);
	}

}

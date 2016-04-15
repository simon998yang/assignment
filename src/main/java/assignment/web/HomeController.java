package assignment.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@Value("${application.authorName:Simon}")
	private String authorName = "";

	@RequestMapping("/")
	String home() {
		return "home";
	}

	@ModelAttribute("authorName")
	public String getAuthorName() {
		return this.authorName;
	}

}

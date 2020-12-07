package ie.walshmedia.dealership.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebSiteController
{

	@RequestMapping(WebsiteMappings.HomePage)
	public ModelAndView getHomePage()
	{
		System.out.println("getHomePage");

		String viewName = WebsitePageViews.HomePage;
		return new ModelAndView(viewName);
	}
}

/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.dealership.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebSiteController
{

	@RequestMapping(WebsiteMappings.HomePage)
	public ModelAndView getHomePage()
	{
		String viewName = WebsitePageViews.HomePage;
		return new ModelAndView(viewName);
	}
}

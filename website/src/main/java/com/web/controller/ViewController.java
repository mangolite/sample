package com.web.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller to handle all view related requests
 * 
 * @author <a mailto:lalit.tanwar07@gmail.com> Lalit Tanwar</a>
 * @version 1.0
 * @lastModified Aug 19, 2014
 */
@Controller
public class ViewController {
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String home(ModelAndView modelAndView) throws IOException {
		return "index";
	}

	@RequestMapping(value = "/utils", method = RequestMethod.GET)
	public String utils(ModelAndView modelAndView) throws IOException {
		return "utils";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(ModelAndView modelAndView, String p) throws IOException {
		return p;
	}
}

package com.web.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String utils(ModelAndView modelAndView, HttpServletResponse res,
			@RequestParam String uid) throws IOException {
		res.addCookie(new Cookie("user", uid));
		return "utils";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Model model, String p, HttpServletResponse res,
			@RequestParam(required = false) String uid) throws IOException {
		String uidTemp = (uid == null) ? "0" : uid;
		res.addCookie(new Cookie("user", uidTemp));
		model.addAttribute("user", uidTemp);
		return p;
	}

	@RequestMapping(value = "/bootstrap", method = RequestMethod.GET)
	public String bootstrap(ModelAndView modelAndView) throws IOException {
		return "bootstrap";
	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashboard(ModelAndView modelAndView) throws IOException {
		return "dashboard";
	}

	@RequestMapping(value = "/template/*", method = RequestMethod.GET)
	public String template(ModelAndView modelAndView, String _handler)
			throws IOException {
		if (_handler == null) {
			return "template/defaultView";
		} else {
			return "template/" + _handler;
		}
	}
}

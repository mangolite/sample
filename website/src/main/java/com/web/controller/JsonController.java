package com.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.web.models.HelloMessage;

@Controller
public class JsonController {

	@RequestMapping(value = "/json/auth", method = RequestMethod.GET)
	@ResponseBody
	public HelloMessage home(ModelAndView modelAndView, HttpServletRequest request) throws IOException {
		HelloMessage hm = new HelloMessage();
		HttpSession session = request.getSession(true);	    
        session.setAttribute("currentSessionUser",user); 
		return hm;
	}
}

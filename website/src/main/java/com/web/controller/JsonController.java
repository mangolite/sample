package com.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.web.models.AuthResponse;
import com.web.models.UserBean;
import com.webutils.WebAppContext;

@Controller
public class JsonController {

	@RequestMapping(value = "/json/auth", method = RequestMethod.GET)
	@ResponseBody
	public AuthResponse home(ModelAndView modelAndView, HttpServletRequest request,
			@RequestParam String username,@RequestParam String password) throws IOException {
		AuthResponse hm = new AuthResponse();
		UserBean user = (UserBean) WebAppContext.getUser();
		user.auth(username,password);
		if(user.isValid()){
			hm.setSessionID(user.getSessionID());
			hm.setSuccess(true);
		}
		return hm;
	}
}

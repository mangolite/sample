package com.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.web.app.AppClient;
import com.web.models.AuthResponse;
import com.web.models.Greeting;
import com.web.models.UserBean;
import org.spamjs.mangolite.abstracts.AbstractDataController;

@Controller
public class DataController extends AbstractDataController {

	@RequestMapping(value = "/json/auth", method = RequestMethod.GET)
	@ResponseBody
	public AuthResponse home(ModelAndView modelAndView,
			HttpServletRequest request, @RequestParam String username,
			@RequestParam String password) throws IOException {
		AuthResponse hm = new AuthResponse();
		UserBean user = (UserBean) AppClient.getContext().getUser();
		user.setUserName(username);
		user.setPassword(password);
		user.auth(username, password);
		if (user.isValid()) {
			hm.setSessionID(user.getSessionID());
			hm.setSuccess(true);
		}
		return hm;
	}
	
	@Autowired
	public AppClient rxController;

	@MessageMapping("/hello")
	@SendTo("/event/greetings")
	public Greeting greeting(AuthResponse message) throws Exception {
		// Thread.sleep(3000); // simulated delay
		return new Greeting("Hello, " + "!");
	}

}

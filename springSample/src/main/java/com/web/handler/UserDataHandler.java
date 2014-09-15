package com.web.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import com.web.AbstractHandler;
import com.web.ActionHandler;
import com.web.HandlerAction;
import com.web.models.HelloMessage;
import com.web.models.Name;
import com.web.models.UserDetails;

/**
 * THis is sampe test handler.
 *
 * @author <a mailto:lalit.tanwar07@gmail.com> Lalit Tanwar</a>
 * @version 1.0
 * @lastModified Aug 19, 2014
 */
@ActionHandler(name = "userdata")
public class UserDataHandler extends AbstractHandler {
	
	public static UserDetails user;
	@Autowired private SimpMessagingTemplate templ;
	
	static {
		user = new UserDetails();
		user.setName(new Name("Lalit","Tanwar"));
		user.setAge(100);
	}

	/**
	 * My method.
	 *
	 * @param message
	 *            the message
	 * @return the greeting
	 */
	@HandlerAction(name = "get_data")
	public UserDetails getData(HelloMessage message) {
		return user;
	}

	@HandlerAction(name = "get_data2")
	public UserDetails getData2(HelloMessage message,HelloMessage message2) {
		return user;
	}
}

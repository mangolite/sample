package com.web.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import com.web.models.HelloMessage;
import com.web.models.Name;
import com.web.models.UserDetails;
import com.webutils.AbstractHandler;
import com.webutils.annotations.ActionHandler;
import com.webutils.annotations.HandlerAction;
import com.web.app.MessageClient;

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
	@Autowired
	private SimpMessagingTemplate templ;

	static {
		user = new UserDetails();
		user.setName(new Name("ABC", "DEF"));
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
	public UserDetails getData2(HelloMessage message, HelloMessage message2) {
		return user;
	}

	@HandlerAction(name = "name.fname")
	public UserDetails getData2(UserDetails message) {
		try {
			user.getName().setFname(message.getName().getFname());
			//MessageClient.sendToUser("testuser", "details_updated", user);
			//MessageClient.send("details_updated", user);
			MessageClient.sendToAll("all_updated", user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}

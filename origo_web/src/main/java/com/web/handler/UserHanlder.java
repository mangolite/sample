package com.web.handler;

import com.web.models.AuthModel;
import com.web.models.UserBean;
import org.spamjs.mangolite.abstracts.AbstractHandler;
import org.spamjs.mangolite.abstracts.HandlerResponse;
import org.spamjs.mangolite.annotations.ActionHandler;
import org.spamjs.mangolite.annotations.HandlerAction;

/**
 * THis is sampe test handler.
 *
 * @author <a mailto:lalit.tanwar07@gmail.com> Lalit Tanwar</a>
 * @version 1.0
 * @lastModified Aug 19, 2014
 */
@ActionHandler(name = "user")
public class UserHanlder extends AbstractHandler {

	@HandlerAction(name = "authByCompany")
	public AuthModel auth(AuthModel model, UserBean user, HandlerResponse resp) {

		if (user.isValid()) {
			model.setStatus("Already Validated");
			resp.setSuccess(true);
		} else if ("admin".equals(model.getUsername())) {
			user.setUserName(model.getUsername());
			user.setPassword(model.getPassword());
			user.isValid(Boolean.TRUE);
			model.setStatus("Validated");
			resp.setSuccess(true);
		} else {
			resp.setSuccess(false);
			model.setStatus("Who R U ?");
		}
		return model;
	}
	
	@HandlerAction(name = "isValid")
	public AuthModel isValid(AuthModel model, UserBean user, HandlerResponse resp) {

		if (user.isValid()) {
			//model.setStatus("Already Validated");
			resp.setSuccess(true);
		} else {
			resp.setSuccess(false);
			//model.setStatus("Who R U ?");
		}
		return model;
	}
	
	@HandlerAction(name = "logout")
	public AuthModel logout(AuthModel model, UserBean user, HandlerResponse resp) {
		user.isValid(Boolean.FALSE);
		return model;
	}
}

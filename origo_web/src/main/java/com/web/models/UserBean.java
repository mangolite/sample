package com.web.models;

import org.spamjs.mangolite.abstracts.AbstractUser;
import org.spamjs.mangolite.annotations.RxModel;
import org.spamjs.mangolite.annotations.RxModel.ModelType;

@RxModel(ModelType.USER)
public class UserBean extends AbstractUser {
	private String firstName;
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String newFirstName) {
		firstName = newFirstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String newLastName) {
		lastName = newLastName;
	}
	
	public int getSessionTimout() {
		return 30;
	}

	@Override
	public void auth(String userName, String passWord) {
		if("admin".equals(userName)){
			this.isValid(true);
		}
	}
	
	@Override
	public boolean isValid() {
		return true;
	}
}

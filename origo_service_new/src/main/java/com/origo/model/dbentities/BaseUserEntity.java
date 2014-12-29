/*------------------------------------------------------------------------------

This source is part of the OrigoXtreme Pvt Ltd.

All rights reserved.  No part of this work may be reproduced, stored in a
retrieval system, adopted or transmitted in any form or by any means,
electronic, mechanical, photographic, graphic, optic recording or otherwise,
translated in any language or computer language, without the prior written
permission of OrigoXtreme Pvt Limited.

OrigoXtreme Pvt Ltd
Gurgaon
India

Copyright � 2014 OrigoXtreme Pvt Ltd.

Modification History

Date		Version		Author			Description
----------	-----------	--------------- ----------------------------------------
07 12 2014	1			Ram G Suri		Initial Version								
------------------------------------------------------------------------------*/
package com.origo.model.dbentities;
//--------------------------------------------------------
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
//--------------------------------------------------------
@MappedSuperclass
public class BaseUserEntity {
	
	public  BaseUserEntity() {
		super();
	}
	/**
	 * This field describes the uniquely generated id for Origo Entities.
	 * This is primary key of the table. 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORIGO_ID", unique = true, nullable = false)
	public Integer id;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime
				* result
				+ ((profileActiveFlag == null) ? 0 : profileActiveFlag
						.hashCode());
		result = prime * result
				+ ((userLogo == null) ? 0 : userLogo.hashCode());
		result = prime * result
				+ ((userType == null) ? 0 : userType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseUserEntity other = (BaseUserEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (profileActiveFlag == null) {
			if (other.profileActiveFlag != null)
				return false;
		} else if (!profileActiveFlag.equals(other.profileActiveFlag))
			return false;
		if (userLogo == null) {
			if (other.userLogo != null)
				return false;
		} else if (!userLogo.equals(other.userLogo))
			return false;
		if (userType == null) {
			if (other.userType != null)
				return false;
		} else if (!userType.equals(other.userType))
			return false;
		return true;
	}
	@Column(name = "LOGO")
	protected String userLogo;
	
	/**
	 * This field describes the name of entity. 
	 * Entity can be Company or User. 
	 * For Company this contains Company Name.
	 * For User this contains User Name  
	 */
	@Column(name = "NAME", length=100)
	protected String name;
	
	/**
	 * This field describes the user type of Origo Customers.
	 * 
	 * Valid Values can be 
	 * <ul>
	 *  <li>B001 - For Business User of a Company</li>
	 *  <li>E001 - For end user</li>
	 * </ul>
	 * 
	 */
	// This can be enumeration
	@Column(name = "USER_TYPE",length=3)
	protected String userType;
	
	/**
	 * This field describes the active flag for origo customer.
	 * Valid Values : Y or N
	 */
	@Column(name = "PROFILE_ACTIVE_FLAG",length=1)
	protected Character profileActiveFlag;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserLogo() {
		return userLogo;
	}

	public void setUserLogo(String userLogo) {
		this.userLogo = userLogo;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Character getProfileActiveFlag() {
		return profileActiveFlag;
	}

	public void setProfileActiveFlag(Character profileActiveFlag) {
		this.profileActiveFlag = profileActiveFlag;
	}
	
}

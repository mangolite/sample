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

Copyright © 2014 OrigoXtreme Pvt Ltd.

Modification History

Date		Version		Author			Description
----------	-----------	--------------- ----------------------------------------
07 12 2014	1			Ram G Suri		Initial Version								
------------------------------------------------------------------------------*/
package com.origo.dao;
//-----------------------------------------------------------------------------
import java.util.Collection;
import java.util.List;

import com.origo.model.dbentities.BaseUserEntity;
import com.origo.model.dbentities.CompanyProfileEntity;
import com.origo.model.dbentities.OrigoChannelUserEntity;
import com.origo.model.dbentities.UserProfileEntity;
//-----------------------------------------------------------------------------
public interface UserDao {
	
	/**
	 * This method is to persist User in DB.
	 * 
	 * @param user   Requires Input UserProfileEntity
	 * @return		 UserProfileEntity
	 * 
	 */
	UserProfileEntity saveUserEntity (
		UserProfileEntity user
	) throws Exception;
	
	/**
	 * This method is to persist Company in DB.
	 * 
	 * 
	 * @param company
	 * @return
	 */
	CompanyProfileEntity saveCompanyEntity (
		CompanyProfileEntity company
	) throws Exception;
	
	/**
	 * This method is to list all the companies.
	 * 
	 * @return
	 */
	Collection<CompanyProfileEntity> listCompanies() throws Exception;
	
	/**
	 * This method is to list all the users of OrigoXtreme.
	 * 
	 * @return
	 */
	Collection<UserProfileEntity> listUsers() throws Exception;
	
	/**
	 * 
	 * This method is used to find the origo entity from email
	 * and user type.
	 * 
	 * @param emailId
	 * @param userType
	 * @return
	 */
	OrigoChannelUserEntity findEntityByEmailId (
		String emailId
	, 	String userType
	) throws Exception;
	
	/**
	 * This method is to find the origo entity from origo Id.
	 * 
	 * @param origoId
	 * @return
	 */
	BaseUserEntity findEntityByOrigoId(OrigoChannelUserEntity origoChannelUserEntity) throws Exception;
	
	/**
	 * This method is to persist OrigoChannelUserEntity object in DB.
	 * 
	 * @param OrigoChannelUserEntity object
	 * @return boolean
	 */
	
	public boolean registration(OrigoChannelUserEntity origoChannelUserEntity) throws Exception;
	
	/**
	 * This method is to list all the companies.
	 * 
	 * @return
	 */
	public List<OrigoChannelUserEntity> getOrigoChannelUserEntityList() throws Exception;
	
	/**
	 * This method is to persist token in database.
	 * 
	 * @return
	 */
	public boolean insertForgotPasswordToken(String email,String token) throws Exception;
}	

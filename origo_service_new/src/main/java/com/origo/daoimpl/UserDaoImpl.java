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
package com.origo.daoimpl;
//-----------------------------------------------------------------------------
import java.util.Collection;

import javax.sql.DataSource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.origo.dao.UserDao;
import com.origo.model.dbentities.BaseUserEntity;
import com.origo.model.dbentities.CompanyProfileEntity;
import com.origo.model.dbentities.OrigoChannelUserEntity;
import com.origo.model.dbentities.UserProfileEntity;
import com.origo.services.apps.endpoints.UserService;
//-----------------------------------------------------------------------------
@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	SessionFactory  mysqlSessionFactory;

	private static final Logger SLF4JLOGGER = LoggerFactory.getLogger(UserDaoImpl.class);
	 
	
	@Autowired
	private DataSource dataSource;
	
	private static final String QUERY_LIST_COMPANIES = "from CompanyProfileEntity";
	
	@Override
	public UserProfileEntity saveUserEntity (
		UserProfileEntity user
	) throws HibernateException , Exception{
		
		Session session=mysqlSessionFactory.getCurrentSession();
		if (user.getId() == null) {
			session.persist(user);
		} else {
			session.merge(user);
		}
		UserProfileEntity copyUser = new UserProfileEntity();
		BeanUtils.copyProperties(user, copyUser);
		return copyUser;
		
	}

	@Override
	@Transactional
	public CompanyProfileEntity saveCompanyEntity(CompanyProfileEntity company)
			throws Exception {
		SLF4JLOGGER.debug("---- Persisting Company Entity ----");
		Session session=mysqlSessionFactory.getCurrentSession();

		SLF4JLOGGER.debug("---- Session ----"+session);
		if (company.getId() == null) {
			session.persist(company);
		} else {
			session.merge(company);
		}

		SLF4JLOGGER.debug("---- Exit Persisting Company Entity ----");
		
		CompanyProfileEntity copyUser = new CompanyProfileEntity();
		BeanUtils.copyProperties(company, copyUser);

		SLF4JLOGGER.debug("---- Exit Persisting Company Entity ----");
		
		return copyUser;
		
	}

	@Override
	public Collection<CompanyProfileEntity> listCompanies() throws Exception {
		
		Session session=mysqlSessionFactory.getCurrentSession();
		Query query = session.createQuery(QUERY_LIST_COMPANIES);
	       
		return null;
	}

	@Override
	public Collection<UserProfileEntity> listUsers() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrigoChannelUserEntity findEntityByEmailId(String emailId, String userType)
			throws Exception {
		Session session=mysqlSessionFactory.getCurrentSession();
		Query query = session.createQuery("from OrigoChannelUserEntity as origoUser where origoUser.emailId= :emailId and origoUser.type=:userType" );
		query.setParameter("emailId", emailId);
		query.setParameter("userType", userType);
		OrigoChannelUserEntity origoChannelUserEntity=(OrigoChannelUserEntity) query.list().get(0);
		return origoChannelUserEntity;
	}

	@Override
	public BaseUserEntity findEntityByOrigoId(OrigoChannelUserEntity origoChannelUserEntity) throws Exception {
		
		 // using 'join fetch' because a single query should load both owners and pets
        // using 'left join fetch' because it might happen that an owner does not have pets yet
   //     Query query = this.em.createQuery("SELECT owner FROM Owner owner left join fetch owner.pets WHERE owner.id =:id");
  //      query.setParameter("id", id);
		Session session=mysqlSessionFactory.getCurrentSession();
		Query query = session.createQuery("from CompanyProfileEntity as companyProfile where companyProfile.id=:origoId" );
		query.setParameter("origoId", origoChannelUserEntity.getIdUser());
		BaseUserEntity baseUserEntity=(BaseUserEntity) query.list().get(0);
		return baseUserEntity;
		
	}

	
	
}	

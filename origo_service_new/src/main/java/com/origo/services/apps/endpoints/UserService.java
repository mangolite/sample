package com.origo.services.apps.endpoints;
//------------------------------------------------------------------------
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.origo.dao.UserDao;
import com.origo.model.dbentities.BaseUserEntity;
import com.origo.model.dbentities.CompanyProfileEntity;
import com.origo.model.dbentities.OrigoChannelUserEntity;
import com.origo.model.dbentities.UserProfileEntity;
import com.origo.services.apps.interfaces.UserServiceInterface;
//-----------------------------------------------------------------------
@Service
public class UserService implements UserServiceInterface{
	
	
	private UserDao userDao; 
	
	private static final Logger SLF4JLOGGER = LoggerFactory.getLogger(UserService.class);
	 
	
	@Autowired
	public  UserService(UserDao userDao) {
		this.userDao =userDao;
	}
	
	
/*	public UserService() {
		super();
	}
*/

	@Override
    @Transactional
	public UserProfileEntity saveUserEntity(UserProfileEntity user)
			throws Exception {
		
		SLF4JLOGGER.debug("---- Inside Save User Entity ----");
		 
		UserProfileEntity userProfile = userDao.saveUserEntity(user);
		
		SLF4JLOGGER.debug("---- Exit Save User Entity ----");
		
		return userProfile;
		
	}

	@Override
    @Transactional
	public CompanyProfileEntity saveCompanyEntity(CompanyProfileEntity company)
			throws Exception {
		SLF4JLOGGER.debug("---- Inside Save Company Entity ----");
		
		CompanyProfileEntity companyProfile = userDao.saveCompanyEntity(company);

		SLF4JLOGGER.debug("---- Exit Save Company Entity ----");
		return companyProfile;
		
	}

	@Override
    @Transactional(readOnly = true)
	public Collection<CompanyProfileEntity> listCompanies() throws Exception {
		return userDao.listCompanies();
		
	}

	@Override
    @Transactional(readOnly = true)
	public Collection<UserProfileEntity> listUsers() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    @Transactional(readOnly = true)
	public OrigoChannelUserEntity findEntityByEmailId(String emailId, String userType)
			throws Exception {
		// TODO Auto-generated method stub
		OrigoChannelUserEntity origoChannelUserEntity=userDao.findEntityByEmailId(emailId, userType);
		return origoChannelUserEntity;
	}

	@Override
    @Transactional(readOnly = true)
	public BaseUserEntity findEntityByOrigoId(OrigoChannelUserEntity origoChannelUserEntity) throws Exception {
		// TODO Auto-generated method stub
		BaseUserEntity baseUserEntity=userDao.findEntityByOrigoId(origoChannelUserEntity);
		return baseUserEntity;
	}

	
}


package com.origo.services.test.endpoints;
//---------------------------------------------------------------------

import java.util.ArrayList;
import java.util.List;

import org.hibernate.mapping.Array;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.origo.model.dbentities.CompanyProfileEntity;
import com.origo.model.dbentities.CompanyResourceEntity;
import com.origo.model.dbentities.ProductEntity;
import com.origo.services.apps.endpoints.UserService;
import com.origo.services.apps.interfaces.UserServiceInterface;

/**
 * <p> Base class for {@link UserService} integration tests. </p> <p> Subclasses should specify Spring context
 * configuration using {@link ContextConfiguration @ContextConfiguration} annotation </p> <p>
 * AbstractUserServiceTests and its subclasses benefit from the following services provided by the Spring
 * TestContext Framework: </p> <ul> <li><strong>Spring IoC container caching</strong> which spares us unnecessary set up
 * time between test execution.</li> <li><strong>Dependency Injection</strong> of test fixture instances, meaning that
 * we don't need to perform application context lookups. See the use of {@link Autowired @Autowired} on the <code>{@link
 * AbstractUserServiceTests#userService userService}</code> instance variable, which uses autowiring <em>by
 * type</em>. <li><strong>Transaction management</strong>, meaning each test method is executed in its own transaction,
 * which is automatically rolled back by default. Thus, even if tests insert or otherwise change database state, there
 * is no need for a teardown or cleanup script. <li> An {@link org.springframework.context.ApplicationContext
 * ApplicationContext} is also inherited and can be used for explicit bean lookup if necessary. </li> </ul>
 *
 * @author Ram G Suri
 */
public abstract class AbstractUserServiceTests {

    @Autowired
    protected UserServiceInterface userServiceInterface;


	@Test
	@Transactional
	public void addCompanyProfile() throws Exception {
		

		CompanyProfileEntity companyProfile = new CompanyProfileEntity();
		companyProfile.setCompanyCEOName("Tony Stark");
		companyProfile.setYearEstablishedIn(2000);
		companyProfile.setCertifications("ISO,ABC,DEF,GHHH");
		companyProfile.setProfileActiveFlag('Y');
		companyProfile.setName("Microsoft");
		companyProfile.setIndustryType("Softwarae");
		companyProfile.setCompanyDesc("Leader in manufacturing of Motherboard");
		companyProfile.setEmployeeCount(2000000);
		companyProfile.setCompanyStockCode("MS");
		// Product
		ProductEntity prodEntity = new ProductEntity();
		prodEntity.setCompany(companyProfile);
		prodEntity.setProductName("AntiVirus");
		prodEntity.setProductSpecification("total size : 3 mb");
		prodEntity.setProductDesc("latest revised updates for all types of malwares".getBytes());
		
		ProductEntity prodEntity2 = new ProductEntity();
		prodEntity2.setCompany(companyProfile);
		prodEntity2.setProductName("iphone");
		prodEntity2.setProductSpecification("13 mb camera");
		prodEntity2.setProductDesc("phone bigger than previous one".getBytes());

			
		List<ProductEntity> prodList = new ArrayList<ProductEntity>();
		prodList.add(prodEntity);
		prodList.add(prodEntity2);
		companyProfile.setProductEntity(prodList);
		// Resources
		
		CompanyResourceEntity cre = new CompanyResourceEntity();
		cre.setCompany(companyProfile);
		cre.setResourceName("Iphone Manual");
		
		List<CompanyResourceEntity> resourceList = new ArrayList<CompanyResourceEntity>();
		resourceList.add(cre);
		
		companyProfile.setResourceDetailsEntity(resourceList);
		
		//Contacts
		
		
		//Address
		
		
		// AmountCurrency
		
		
		try{
		
		this.userServiceInterface.saveCompanyEntity(companyProfile);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("--------------ERROR -------------");
		}
	}


}


package com.origo.services.test.endpoints;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;  
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * <p> Integration test using the jpa profile. 
 * @see AbstractUserServiceTests AbstractUserServiceTests for more details. </p>
 *
 * @author Ram G Suri
 */

@ContextConfiguration(locations = {"classpath:spring/business-config-entry.xml"})
@TransactionConfiguration(defaultRollback = false)  // Important Point
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("jpa")
public class UserServiceJpaTests extends AbstractUserServiceTests {
		
	
	
}
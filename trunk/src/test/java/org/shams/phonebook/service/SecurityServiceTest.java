package org.shams.phonebook.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.shams.phonebook.domain.impl.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.acegisecurity.userdetails.UserDetailsService;
import org.acegisecurity.userdetails.UserDetails;

/**
 * @version 0.0.0
 *          Date: Feb 11, 2008
 * @auther <a href="mailto:m.h.shams@gmail.com"> M. H. Shamsi </a>
 */

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "txManager")
@ContextConfiguration(locations = {"classpath:org/shams/phonebook/config/hibernate-application-context.xml"})
public class SecurityServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    SecurityService service;


    @Before
    public void init() throws Exception {
        deleteFromTables("_user");
    }

    @After
    public void destroy() throws Exception {
        deleteFromTables("_user");
    }

    @Test
    public void insert() {
        service.save(getUser());
        assertEquals(1, countRowsInTable("_user"));
    }

    @Test
    public void load() {
        service.save(getUser());
        assertEquals(1, countRowsInTable("_user"));
        User user = (User) ((UserDetailsService) service).loadUserByUsername("demo");
        assertNotNull(user);
        assertEquals(user.getPassword(), "demo");
    }


    private User getUser() {
        User u = new User();
        u.setName("demo user");
        u.setUsername("demo");
        u.setPassword("demo");
        return u;
    }
}

package org.shams.phonebook.dao.user;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.shams.phonebook.dao.UserDao;
import org.shams.phonebook.domain.impl.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * @version 0.0.0
 *          Date: Feb 11, 2008
 * @auther <a href="mailto:m.h.shams@gmail.com"> M. H. Shamsi </a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "txManager")
public abstract class BaseUserDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    private UserDao dao;

    @Before
    public void init() throws Exception {
        deleteFromTables("_user");
    }

    @After
    public void destroy() throws Exception {
        deleteFromTables("_user");
    }

    public void save() {
        dao.save(getUser());
        Assert.assertEquals(countRowsInTable("_user"), 1);
    }

    public void duplicate() {
        dao.save(getUser());
        dao.save(getUser());
    }

    public void load() {
        dao.save(getUser());
        User user = dao.load("demo");
        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getId());
        Assert.assertEquals(user.getUsername(), "demo");
        Assert.assertEquals(user.getPassword(), "demo");
    }

    private User getUser() {
        User user = new User();
        user.setName("demo user");
        user.setUsername("demo");
        user.setPassword("demo");
        return user;
    }
}

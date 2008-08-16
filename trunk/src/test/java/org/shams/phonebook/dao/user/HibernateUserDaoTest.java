package org.shams.phonebook.dao.user;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

/**
 * @version 0.0.0
 *          Date: Feb 11, 2008
 * @auther <a href="mailto:m.h.shams@gmail.com"> M. H. Shamsi </a>
 */
@ContextConfiguration(locations = {"classpath:org/shams/phonebook/config/hibernate-application-context.xml"})
public class HibernateUserDaoTest extends BaseUserDaoTest {

    @Test
    public void save() {
        super.save();
    }

    @Test
    public void load() {
        super.load();
    }

    @Test(expected = org.springframework.dao.DataIntegrityViolationException.class)
    public void duplicate() {
        super.duplicate();
    }
}

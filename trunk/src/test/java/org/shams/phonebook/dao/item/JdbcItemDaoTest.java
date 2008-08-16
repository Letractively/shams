package org.shams.phonebook.dao.item;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

/**
 * @version 0.0.0
 *          Date: Feb 12, 2008
 * @auther <a href="mailto:m.h.shams@gmail.com"> M. H. Shamsi </a>
 */
@ContextConfiguration(locations = {"classpath:org/shams/phonebook/config/jdbc-application-context.xml"})
public class JdbcItemDaoTest extends BaseItemDaoTest {

    @Test
    public void save() {
        super.save();
    }

    @Test
    public void load() {
        super.load();
    }
    
    @Test
    public void delete() {
        super.delete();
    }
}

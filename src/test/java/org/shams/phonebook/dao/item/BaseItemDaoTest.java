package org.shams.phonebook.dao.item;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.shams.phonebook.dao.ItemDao;
import org.shams.phonebook.domain.impl.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.util.List;

/**
 * @version 0.0.0
 *          Date: Feb 12, 2008
 * @auther <a href="mailto:m.h.shams@gmail.com"> M. H. Shamsi </a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "txManager")
public abstract class BaseItemDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    private ItemDao dao;

    @Before
    public void init() throws Exception {
        deleteFromTables("_item");
    }

    @After
    public void destroy() throws Exception {
        deleteFromTables("_item");
    }

    public void save() {
        dao.save(getItem());
        assertEquals(countRowsInTable("_item"), 1);
    }

    public void load() {
        Item item = getItem();
        dao.save(item);
        assertEquals(countRowsInTable("_item"), 1);
        List<Item> items = dao.load();
        assertEquals(items.size(), 1);
        assertEquals(items.get(0).getFirstName(), "f");

        Item item1 = dao.load(items.get(0).getId());
        assertNotNull(item1);
        assertEquals(item1.getLastName(), "l");

        assertEquals(dao.load("@").size(), 1);
        assertEquals(dao.load("@1").size(), 0);
    }

    public void delete() {
        dao.save(getItem());
        List<Item> items = dao.load();
        assertEquals(1, items.size());
        dao.delete(items.get(0));
        assertEquals(0, dao.load().size());
    }

    private Item getItem() {
        return new Item("f", "l", "p", "m", "@", "A");
    }
}

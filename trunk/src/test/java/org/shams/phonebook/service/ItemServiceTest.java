package org.shams.phonebook.service;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.shams.phonebook.domain.impl.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
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
@ContextConfiguration(locations = {"classpath:org/shams/phonebook/config/hibernate-application-context.xml"})
public class ItemServiceTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    private ItemService service;

    @Before
    public void init() throws Exception {
        deleteFromTables("_item");
    }

    @After
    public void destroy() throws Exception {
        deleteFromTables("_item");
    }

    @Test
    public void insert() {
        service.save(getItem());
        assertEquals(1, countRowsInTable("_item"));
    }

    @Test
    public void load() {
        service.save(getItem());
        assertEquals(1, countRowsInTable("_item"));
        List<Item> items = service.load("f");
        assertEquals(1, items.size());
        assertEquals("@", items.get(0).getMail());
        Item item = service.load(items.get(0).getId());
        assertNotNull(item);
        assertEquals("A", item.getAddress());
    }

    @Test
    public void delete() {
        service.save(getItem());
        assertEquals(1, countRowsInTable("_item"));
        List<Item> items = service.load("f");
        assertEquals(1, items.size());
        service.delete(items.get(0));
        assertEquals(0, service.load("f").size());
    }


    private Item getItem() {
        return new Item("f", "l", "p", "m", "@", "A");
    }

}

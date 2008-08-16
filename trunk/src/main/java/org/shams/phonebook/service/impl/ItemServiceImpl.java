package org.shams.phonebook.service.impl;

import org.shams.phonebook.dao.ItemDao;
import org.shams.phonebook.domain.impl.Item;
import org.shams.phonebook.service.ItemService;

import java.util.List;

/**
 * @author <a href="mailto:m.h.shams@gmail.com">M. H. Shamsi</a>
 * @version 1.0.0
 *          Date Dec 31, 2007
 */

public class ItemServiceImpl extends ServiceImpl implements ItemService {
    ItemDao itemDao;

    public void setItemDao(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public List<Item> load(String token) {
        if (token == null || token.trim().equals("")) {
            return itemDao.load();
        } else {
            return itemDao.load(token);
        }
    }

    public Item load(long id) {
        return itemDao.load(id);
    }

    public void save(Item item) {
        itemDao.save(item);
    }

    public void update(Item item) {
        itemDao.update(item);
    }

    public void delete(Item item) {
        itemDao.delete(item);
    }
}

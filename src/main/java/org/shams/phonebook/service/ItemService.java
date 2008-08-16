package org.shams.phonebook.service;

import org.shams.phonebook.dao.ItemDao;
import org.shams.phonebook.domain.impl.Item;

import java.util.List;

/**
 * @author <a href="mailto:m.h.shams@gmail.com">M. H. Shamsi</a>
 * @version 1.0.0
 *          Date Dec 31, 2007
 */

public interface ItemService extends Service {
    public void setItemDao(ItemDao itemDao);

    public Item load(long id);

    public List<Item> load(String token);

    public void save(Item item);

    public void update(Item item);

    public void delete(Item item);
}

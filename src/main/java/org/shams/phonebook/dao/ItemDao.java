package org.shams.phonebook.dao;

import org.shams.phonebook.domain.impl.Item;

import java.util.List;

/**
 * @author <a href="mailto:m.h.shams@gmail.com">M. H. Shamsi</a>
 * @version 1.0.0
 *          Date Jan 15, 2008
 */

public interface ItemDao extends Dao {
    public List<Item> load();

    public List<Item> load(String token);

    public Item load(long id);

    public void save(Item item);

    public void update(Item item);

    public void delete(Item item);
}

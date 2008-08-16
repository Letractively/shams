package org.shams.phonebook.dao.impl.jpa;

import org.shams.phonebook.dao.ItemDao;
import org.shams.phonebook.domain.impl.Item;

import java.util.List;

/**
 * @author <a href="mailto:m.h.shams@gmail.com">M. H. Shamsi</a>
 * @version 1.0.0
 *          Date Jan 20, 2008
 */

@SuppressWarnings({"unchecked"})
public class ItemDaoImpl extends DaoImpl implements ItemDao {
    public List<Item> load() {
        return getJpaTemplate().find("select i from Item i");
    }

    public List<Item> load(String token) {
        String query = "select distinct i from Item i where " +
                "i.firstName like ?1 or " +
                "i.lastName like ?1 or " +
                "i.phone like ?1 or " +
                "i.mobile like ?1 or " +
                "i.mail like ?1 or " +
                "i.address like ?1";

        return getJpaTemplate().find(query, token);
    }

    public Item load(long id) {
        return getJpaTemplate().find(Item.class, id);
    }

    public void save(Item item) {
        getJpaTemplate().persist(item);
    }

    public void update(Item item) {
        getJpaTemplate().merge(item);
    }

    public void delete(Item item) {
        Item attached = getJpaTemplate().find(Item.class, item.getId());
        getJpaTemplate().remove(attached);
    }
}

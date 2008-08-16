package org.shams.phonebook.dao.impl.hibernate;

import org.shams.phonebook.dao.ItemDao;
import org.shams.phonebook.domain.impl.Item;

import java.util.List;

/**
 * @author <a href="mailto:m.h.shams@gmail.com">M. H. Shamsi</a>
 * @version 1.0.0
 *          Date Jan 20, 2008
 */

public class ItemDaoImpl extends DaoImpl implements ItemDao {

    @SuppressWarnings({"unchecked"})
    public List<Item> load() {
        return getHibernateTemplate().find("select i from Item i");
    }

    @SuppressWarnings({"unchecked"})
    public List<Item> load(String token) {
        String query = "select distinct i from Item i where " +
                "i.firstName like :param or " +
                "i.lastName like :param or " +
                "i.phone like :param or " +
                "i.mobile like :param or " +
                "i.mail like :param or " +
                "i.address like :param";

        return getHibernateTemplate().findByNamedParam(query, "param", token);
    }

    public Item load(long id) {
        return (Item) getHibernateTemplate().get(Item.class, id);
    }

    public void save(Item item) {
        getHibernateTemplate().save(item);
    }

    public void update(Item item) {
        getHibernateTemplate().update(item);
    }

    public void delete(Item item) {
        getHibernateTemplate().delete(item);
    }
}
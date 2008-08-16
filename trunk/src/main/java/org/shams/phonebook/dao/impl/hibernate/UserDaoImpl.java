package org.shams.phonebook.dao.impl.hibernate;

import org.shams.phonebook.dao.UserDao;
import org.shams.phonebook.domain.impl.User;

import java.util.List;

/**
 * @author <a href="mailto:m.h.shams@gmail.com">M. H. Shamsi</a>
 * @version 1.0.0
 *          Date Jan 20, 2008
 */

public class UserDaoImpl extends DaoImpl implements UserDao {
    
    public User load(String username) {
        List list = getHibernateTemplate().findByNamedParam("select u from User u where u.username = :un", "un", username);
        return (User) list.get(0);
    }

    public void save(User user) {
        getHibernateTemplate().save(user);
    }
}
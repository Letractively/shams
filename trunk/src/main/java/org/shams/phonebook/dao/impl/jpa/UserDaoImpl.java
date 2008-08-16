package org.shams.phonebook.dao.impl.jpa;

import org.shams.phonebook.dao.UserDao;
import org.shams.phonebook.domain.impl.User;

/**
 * @author <a href="mailto:m.h.shams@gmail.com">M. H. Shamsi</a>
 * @version 1.0.0
 *          Date Jan 20, 2008
 */

public class UserDaoImpl extends DaoImpl implements UserDao {
    public User load(String username) {
        return (User) getJpaTemplate().find("select u from User u where u.username = ?1", username).get(0);
    }

    public void save(User user) {
        getJpaTemplate().persist(user);
    }
}

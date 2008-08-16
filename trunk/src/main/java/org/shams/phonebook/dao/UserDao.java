package org.shams.phonebook.dao;

import org.shams.phonebook.domain.impl.User;

/**
 * @author <a href="mailto:m.h.shams@gmail.com">M. H. Shamsi</a>
 * @version 1.0.0
 *          Date Jan 15, 2008
 */

public interface UserDao extends Dao {
    public User load(String username);

    public void save(User user);
}

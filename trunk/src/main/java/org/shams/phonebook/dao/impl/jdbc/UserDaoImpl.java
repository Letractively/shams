package org.shams.phonebook.dao.impl.jdbc;

import org.shams.phonebook.dao.UserDao;
import org.shams.phonebook.domain.impl.User;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author <a href="mailto:m.h.shams@gmail.com">M. H. Shamsi</a>
 * @version 1.0.0
 *          Date Jan 15, 2008
 */

public class UserDaoImpl extends DaoImpl implements UserDao {
    public User load(String username) {
        String query = "select * from _user where username = ?";
        return getSimpleJdbcTemplate().queryForObject(query, new UserRowMapper(), username);
    }

    public void save(User user) {
        String query = "insert into _user (name, username, password) values (?, ?, ?)";
        getSimpleJdbcTemplate().update(query,
                user.getName(), user.getUsername(), user.getPassword());
    }

    private class UserRowMapper implements ParameterizedRowMapper<User> {
        public User mapRow(ResultSet rs, int i) throws SQLException {
            return new User(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("username"),
                    rs.getString("password")
            );
        }
    }
}

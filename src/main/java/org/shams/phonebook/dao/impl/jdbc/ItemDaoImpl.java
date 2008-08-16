package org.shams.phonebook.dao.impl.jdbc;

import org.shams.phonebook.dao.ItemDao;
import org.shams.phonebook.domain.impl.Item;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author <a href="mailto:m.h.shams@gmail.com">M. H. Shamsi</a>
 * @version 1.0.0
 *          Date Jan 15, 2008
 */

public class ItemDaoImpl extends DaoImpl implements ItemDao {
    public List<Item> load() {
        String query = "select * from _item";
        return getSimpleJdbcTemplate().query(query, new ItemRowMapper());
    }

    public List<Item> load(String token) {
        String query = "select distinct * from _item where " +
                "name like ? or " +
                "family like ? or " +
                "phone like ? or " +
                "mobile like ? or " +
                "mail like ? or " +
                "address like ?";
        return getSimpleJdbcTemplate().query(query, new ItemRowMapper(), token, token, token, token, token, token);
    }

    public Item load(long id) {
        String query = "select * from _item where id = ?";
        return getSimpleJdbcTemplate().queryForObject(query, new ItemRowMapper(), id);
    }

    public void save(Item item) {
        String query = "insert into _item (name, family, phone, mobile, mail, address) values (?,?,?,?,?,?)";
        getSimpleJdbcTemplate().update(query, item.getFirstName(), item.getLastName(),
                item.getPhone(), item.getMobile(), item.getMail(), item.getAddress());
    }

    public void update(Item item) {
        String query = "update _item set name = ?, family = ?, phone = ?, mobile = ?, mail = ?, address = ? where id = ?";
        getSimpleJdbcTemplate().update(query, item.getFirstName(), item.getLastName(),
                item.getPhone(), item.getMobile(), item.getMail(), item.getAddress(), item.getId());
    }

    public void delete(Item item) {
        String query = "delete from _item where id = ?";
        getSimpleJdbcTemplate().update(query, item.getId());
    }

    private class ItemRowMapper implements ParameterizedRowMapper<Item> {
        public Item mapRow(ResultSet rs, int i) throws SQLException {
            Item item = new Item();
            item.setId(rs.getLong("id"));
            item.setFirstName(rs.getString("name"));
            item.setLastName(rs.getString("family"));
            item.setPhone(rs.getString("phone"));
            item.setMobile(rs.getString("mobile"));
            item.setMail(rs.getString("mail"));
            item.setAddress(rs.getString("address"));
            return item;
        }
    }
}

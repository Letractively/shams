package org.shams.phonebook.service.impl;

import org.acegisecurity.Authentication;
import org.acegisecurity.context.SecurityContext;
import org.acegisecurity.userdetails.UserDetails;
import org.acegisecurity.userdetails.UserDetailsService;
import org.acegisecurity.userdetails.UsernameNotFoundException;
import org.shams.phonebook.dao.UserDao;
import org.shams.phonebook.domain.impl.User;
import org.shams.phonebook.service.SecurityService;
import org.springframework.dao.DataAccessException;

/**
 * @author <a href="mailto:m.h.shams@gmail.com">M. H. Shamsi</a>
 * @version 1.0.0
 *          Date Dec 31, 2007
 */
public class SecurityServiceImpl extends ServiceImpl implements UserDetailsService, SecurityService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save(User user) {
        userDao.save(user);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        try {
            return userDao.load(username);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException("Invalid username or password", e);
        }
    }

    public boolean isUserAuthenticated(SecurityContext context) {
        if (context == null) {
            return false;
        }

        Authentication authentication = context.getAuthentication();
        return authentication != null && authentication.isAuthenticated();
    }

    public String getAuthenticatedUserName(SecurityContext context) {
        if (context == null) {
            return null;
        }

        Authentication authentication = context.getAuthentication();
        if (authentication == null) {
            return null;
        }
        Object principal = authentication.getPrincipal();
        if ((principal == null) || !(principal instanceof User)) {
            return null;
        }
        return ((User) principal).getName();
    }
}

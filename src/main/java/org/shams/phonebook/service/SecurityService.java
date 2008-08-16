package org.shams.phonebook.service;

import org.acegisecurity.context.SecurityContext;
import org.shams.phonebook.dao.UserDao;
import org.shams.phonebook.domain.impl.User;

/**
 * @author <a href="mailto:m.h.shams@gmail.com">M. H. Shamsi</a>
 * @version 1.0.0
 *          Date Dec 31, 2007
 */
public interface SecurityService extends Service {
    public static final String SECURITY_CONTEXT = "ACEGI_SECURITY_CONTEXT";
    public static final String SECURITY_LOGOUT = "/j_acegi_logout";
    public static final String SECURITY_LOGIN = "/j_acegi_security_check";
    public static final String SECURITY_USERNAME = "j_username";
    public static final String SECURITY_PASSWORD = "j_password";

    public void setUserDao(UserDao userDao);

    public void save(User user);

    public boolean isUserAuthenticated(SecurityContext context);

    public String getAuthenticatedUserName(SecurityContext context);
}

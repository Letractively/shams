package org.shams.phonebook.web.pages;

import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Service;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.Response;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Service;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Response;
import org.apache.tapestry5.services.Request;
import org.shams.phonebook.domain.impl.User;
import org.shams.phonebook.service.SecurityService;
import org.springframework.dao.DataIntegrityViolationException;

import java.io.IOException;

/**
 * @author <a href="mailto:m.h.shams@gmail.com">M. H. Shamsi</a>
 * @version 1.0.0
 *          Date Jan 16, 2008
 */

public class Signup {
    @Inject
    private Request request;

    @Inject
    private Response response;

    @Inject
    @Service("securityService")
    private SecurityService service;

    @Persist
    private User user;

    @Persist
    private String confirm;

    @Persist
    private boolean duplicate;

    @Persist
    private boolean notmatched;

    @OnEvent(value = "submit")
    public Object save() throws IOException {
        duplicate = false;
        notmatched = false;

        if (!confirm.equals(user.getPassword())) {
            notmatched = true;
            return Signup.class;
        }

        try {
            service.save(user);

            StringBuffer path = new StringBuffer(request.getContextPath())
                    .append(SecurityService.SECURITY_LOGIN)
                    .append("?")
                    .append(SecurityService.SECURITY_USERNAME).append("=").append(user.getUsername())
                    .append("&")
                    .append(SecurityService.SECURITY_PASSWORD).append("=").append(user.getPassword());

            response.sendRedirect(path.toString());
            return null;
        } catch (DataIntegrityViolationException e) {
            duplicate = true;
            return Signup.class;
        }
    }

    public User getUser() {
        if (user == null) {
            user = new User();
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public boolean isDuplicate() {
        return duplicate;
    }

    public boolean isNotmatched() {
        return notmatched;
    }
}

package org.shams.phonebook.web.pages;

import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.Response;
import org.shams.phonebook.service.SecurityService;

import java.io.IOException;

/**
 * @author <a href="mailto:m.h.shams@gmail.com">M. H. Shamsi</a>
 * @version 1.0.0
 *          Date Oct 14, 2007
 */
public class Login {
    @Inject
    private Request request;

    @Inject
    private Response response;

    @Persist
    private String username;

    private String password;

    private boolean failed = false;

    void onActivate(String extra) {
        if ("failed".equals(extra)) {
            failed = true;
        }
    }

    @OnEvent(value = "submit")
    public void login() throws IOException {
        StringBuffer path = new StringBuffer(request.getContextPath())
                .append(SecurityService.SECURITY_LOGIN)
                .append("?")
                .append(SecurityService.SECURITY_USERNAME).append("=").append(username)
                .append("&")
                .append(SecurityService.SECURITY_PASSWORD).append("=").append(password);
        response.sendRedirect(path.toString());
    }

    public boolean isFailed() {
        return failed;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

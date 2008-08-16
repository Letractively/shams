package org.shams.phonebook.web.components;

import org.acegisecurity.context.SecurityContext;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.IncludeStylesheet;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Service;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PersistentLocale;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.Response;
import org.shams.phonebook.service.SecurityService;

import java.io.IOException;
import java.util.Locale;

/**
 * @author <a href="mailto:m.h.shams@gmail.com">M. H. Shamsi</a>
 * @version 1.0.0
 *          Date Oct 14, 2007
 */

@IncludeStylesheet({"context:/style/main.css", "context:/style/direction.css"})
public class Layout {
    private static final Locale ENGLISH_LOCAL = new Locale("en", "US", "");
    private static final Locale PERSIAN_LOCAL = new Locale("fa_IR", "", "");

    @Inject
    private PersistentLocale localeService;

    @Inject
    private Request request;

    @Inject
    private Response response;

    @Inject
    @Service("securityService")
    private SecurityService securityService;

    @Inject
    private ComponentResources resources;

    @Parameter(required = true)
    private String title;

    @OnEvent(value = "action", component = "locale")
    void changeLocale() {
        Locale current = localeService.get();
        if (current == null || current.equals(PERSIAN_LOCAL)) {
            localeService.set(ENGLISH_LOCAL);
        } else {
            localeService.set(PERSIAN_LOCAL);
        }
    }

    @OnEvent(value = "action")
    Object changePage(String page) {
        return "secure/" + page;
    }

    @OnEvent(value = "action", component = "logout")
    Object logout() throws IOException {
        String path = request.getContextPath() + SecurityService.SECURITY_LOGOUT;
        response.sendRedirect(path);
        return null;
    }

    public String getContext() {
        return request.getContextPath();
    }

    public boolean isAuthenticated() {
        SecurityContext context = (SecurityContext)
                request.getSession(true).getAttribute(SecurityService.SECURITY_CONTEXT);
        return securityService.isUserAuthenticated(context);
    }

    public String getLoginName() {
        SecurityContext context = (SecurityContext)
                request.getSession(true).getAttribute(SecurityService.SECURITY_CONTEXT);
        return securityService.getAuthenticatedUserName(context);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getHomeCss() {
        String page = getPage();
        return page.contains("/Home") ? "selected" : "";
    }

    public String getListCss() {
        return getPage().contains("/List")
                || getPage().contains("/View")
                || getPage().contains("/Edit")
                ? "selected" : "";
    }

    public String getInsertCss() {
        return getPage().contains("/Insert") ? "selected" : "";
    }

    private String getPage() {
        return resources.getPageName();
    }
}

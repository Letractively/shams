package org.shams.phonebook.web.services;

import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.Configuration;

/**
 * @author <a href="mailto:m.h.shams@gmail.com">M. H. Shamsi</a>
 * @version 1.0.0
 *          Date Oct 17, 2007
 */

public class PhoneBookModule {
    public static void contributeApplicationDefaults(MappedConfiguration<String, String> configuration) {
        configuration.add("tapestry.supported-locales", "en,fa");
    }

    public void contributeValidationMessagesSource(Configuration<String> configuration) {
        configuration.add("org/shams/phonebook/web/validators/ValidationMessages.properties");
    }
}

**for more about localization see [http://tapestry.apache.org/tapestry5/tapestry-core/guide/localization.html](http://tapestry.apache.org/tapestry5/tapestry-core/guide/localization.html)**

# Localization in Tapestry 5 #

Localization is all about getting the right text to the user, in the right language.

Localization support is well integrated into Tapestry. Tapestry allows you to easily separate the text you present to your users from the rest of your application ... pull it out of your Java code and even out of your component templates. You can then translate your messages into other languages and let Tapestry put everything together.

# Hints & Tips #

### How To Support New Languages ? ###
  * If you want to support New languages in you application, you most add following code to your `AppModule` class to contribute application new locales and languages :
```
    public static void contributeApplicationDefaults(
              MappedConfiguration<String, String> configuration) {

        configuration.add("tapestry.supported-locales", "en,fa,fr");
    }
```

> this example tells that three locales -English(en) , Persian(fa) and French(fr)- most be    supported by application.

### Page and Component Message Catalog ###
  * Like most of Java applications Tapestry use Java property files for localize messages.
> Each component and page may have a message catalog. A message catalog is a set of     property files (`PageName.properties`, `PageName_fr.properties`...). These property files are the same format used by `java.util.ResourceBundle`, just lines of key=value. These files are packaged with the component's pages HTML template.

> _note that message catalog name most be its page or component name_

### Application Message Catalog ###
  * If the file `WEB-INF/AppName.properties` exists in the context, it will be used as an application-wide message catalog. The `AppName` is derived from the name of the filter inside the `web.xml` file. The search for the file is case sensitive. The properties file may be localized.

> Individual pages and components can override the values defined in this message catalog. in other word if you used a message in a component, Tapestry will search Component Message Catalog, Components Parent Message Catalog, Page Message Catalog and Application Message Catalog respectively for resolve message value.

### How To Localize Validation Messages ? ###
  * For localize validation error messages, you most add a message catalog in `org.apache.tapestry.internal` package. this message catalog name is `ValidationMessages`

> if you want to put this message catalog in other package you most add following code to contribute application validation messages source :

```
 public void contributeValidationMessagesSource(Configuration<String> configuration) {
        configuration.add("path/to/your/package/ValidationMessages.properties");
    }
```

### How To Access Messages From Templates ? ###
  * For access a message from a template you most use message binding prefix `(message:)` just before your message name in template.
```
<input type="submit" value="${message:save}"/>
...
<h1>${message:welcome}</h1>
```

### How To Switch Between Application Locales ? ###
  * For change locale in your application you can use `PersistentLocale` class
> > here is a example of changing locale with `PersistentLocale` :
```
    @Inject 
    private PersistentLocale localeService;

    @OnEvent(value = "action", component = "locale")
    void changeLocale() {
        if ("fr".equalsIgnoreCase(localeService.get().getLanguage())) {
            localeService.set(new Locale("en"));
        } else {
            localeService.set(new Locale("fr"));
        }
    }

```

**for more about localization see
[http://tapestry.apache.org/tapestry5/tapestry-core/guide/localization.html](http://tapestry.apache.org/tapestry5/tapestry-core/guide/localization.html)**

good luck.
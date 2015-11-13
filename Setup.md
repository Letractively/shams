**for more information see http://tapestry.apache.org/tapestry5/tutorial1/env.html**
# Setting up a tapestry application #
create a web application or web module in your IDE.

### Application Library ###
add this jar file to your projects library :
  * `tapestry-core.jar`
  * `tapestry-ioc.jar`
  * `commons-codec.jar`
  * `tapestry-annotation.jar`
  * `javassist.jar`
  * `slf4j-api.jar`
  * `slf4j-log4j12.jar`

all libraries could be found in tapestry binary zip file.
**download tapestry from this location [http://tapestry.apache.org/download.html](http://tapestry.apache.org/download.html)**

### Web Config (web.xml) ###
your `web.xml` most be look likes this :
```
<?xml version="1.0" encoding="UTF-8"?>
<web-app version="2.4"
         xmlns="http://java.sun.com/xml/ns/j2ee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee  http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd">

    <context-param>
        <param-name>tapestry.app-package</param-name>
        <param-value>org.myapp.mypackage</param-value>
    </context-param>
    <filter>
        <filter-name>app</filter-name>
        <filter-class>org.apache.tapestry.TapestryFilter</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>app</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
</web-app>

```

- `org.myapp.mypackage` is tapestry application root package.
you most set a package as a tapestry application root package.

- you may want to set another filter name (`app`).

### Create Application Packages ###
after creating `application root package` you most create following sub packages :
  * `pages` (all page classes most put in this package or its sub package.)
  * `components` (all components classes and templates most put in this package or its sub package.)
  * `mixins` (all mixin classes and templates most put in this package or its sub package.)
  * `services` (all services classes most put in this package or its sub package.)

**note that if you don't want to implement any component,mixin or service you can omit `components` , `services` or `mixins` packages.**

### Create Start Page ###

add new class in `pages` package, set this class name `Start`
put this code in Start class :
```
public class Start {
   public String getName() {
      return "World!"
   }
}
```

create Start.tml in your web root directory (beside WEB-INF directory)
put this code in Start template :
```
<html xmlns:t="http://tapestry.apache.org/schema/tapestry_5_0_0.xsd">
<head>
    <title>Sample App</title>
</head>
<body>
   <h1> Hello ${name} </h1>
</body>
</html>
```

### Run Application ###
set your run options such ass application server,application context and ...
then run application.

**for more information see http://tapestry.apache.org/tapestry5/tutorial1/env.html**

good luck.
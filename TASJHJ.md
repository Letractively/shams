# New Release Features #
In this release i used :
  * `Tapestry 5.0.7` as a Web MVC framework.
  * `Acegi 1.0.5` as a Security System.
  * `Spring 2.5` as a Application framework.
  * `Spring JDBC`  for Data Access Layer.
  * `Hibernate 3.2.4` an alternative for Data Access Layer.
  * `JPA (Hibernate Implementation)` another alternative for Data Access Layer.
  * `HSQLDB 1.8.0.7` for application database.


# Change Data Access Layer #

  1. - in web.xml just change context config location.
```
     <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>
            <!--/WEB-INF/jdbc-application-context.xml-->
            <!--/WEB-INF/jpa-application-context.xml-->
            /WEB-INF/hibernate-application-context.xml
            /WEB-INF/security-context.xml
        </param-value>
    </context-param>
```

> 2 - in security-context.xml change applicaton context resource.

```
    <!--<import resource="jdbc-application-context.xml"/>-->
    <!--<import resource="jpa-application-context.xml"/>-->
    <import resource="hibernate-application-context.xml"/>
```

# Database Config #
> Lets have a look at `database.properties`
```
    driverClassName=org.hsqldb.jdbcDriver
    url=jdbc:hsqldb:file:E:/new-projects/t5m/phb/phbdb
    username=sa
    password=
```

> You have to change **url** value to point your database path.


download source code from http://shams.googlecode.com/files/spring-acegi-hibernate-jpa-jdbc-hsqldb-phonebook-src.zip
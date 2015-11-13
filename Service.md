**for more about Tapestry Service go  [http://tapestry.apache.org/tapestry5/tapestry-ioc/service.html](http://tapestry.apache.org/tapestry5/tapestry-ioc/service.html)**

# Tapestry Services #
Services consist of two main parts: a service interface and a service implementation.
The service interface is how the service will be represented throughout the rest of the application.

### Service Interface and Implementation ###
Create an Interface (`Service.java`) in `services` package.
declare service methods in interface.

Create a Class (`ServiceImpl.java`) in `services` package.
this class most implement 'Service' Interface.

### Add Service To Your Application ###
Each Tapestry Application could have special class that called Module class.
A module class exists for the following reasons:

  * To bind service interfaces to service implementations
  * To contribute configuration data into services
  * To decorate services by providing interceptors around them
  * To provide explicit code for building a service
  * To set a default marker for all services defined in the module

Module Class name consist of two parts : <tapestry filter name> + `Module`. This class most be in `services` package. for example if your application filter name is `myapp` your module class name most be `MyAppModule.java` or `MyappModule.java`(the filter name is case insensitive).
> _note that application filter name was defined in `web.xml`._

> put this code in your `AppModule` class :
```
    public static void bind(ServiceBinder binder) {
        binder.bind(Service.class, ServiceImpl.class);
    }
```

### Inject Service to Page ###
> put this code in your page class :
```
    @Inject
    private Service service;
```

> after this you can use `service` and call its methods in your page

**for more about Tapestry Service go  [http://tapestry.apache.org/tapestry5/tapestry-ioc/service.html](http://tapestry.apache.org/tapestry5/tapestry-ioc/service.html)**

good luck.
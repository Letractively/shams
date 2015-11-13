**for more about Tapestry Components go [http://tapestry.apache.org/tapestry5/tapestry-core/](http://tapestry.apache.org/tapestry5/tapestry-core/)**

# Web Page Layout #

Suppose that you want to have same `footer` , `header` and `menubar` for all or a group of pages in your web application. in this case you can simply develop a Layout Component and set it as a container for application pages.

### About Tapestry Components ###
Each Tapestry component has its Java class and optionally its Template and Message Catalogs. component class, template and message catalogs most be put in `components` package or its sub packages.

There is no need to tapestry components extend from special class.

### Create Layout Template ###
after Setting Up your Tapestry Application Environment (see my [Setup](http://code.google.com/p/shams/wiki/Setup) Wiki page for Setup Tapestry Application) in your components package create a Template File (i choose `Layout.tml` for its name)

put the following code in your components template :
```
<html xmlns:t="http://tapestry.apache.org/schema/tapestry_5_0_0.xsd">
<head>
    <title>${title}</title>
</head>
<body>
<div id="header-div">
    <h2> My Application Header</h2>
    <hr/>
</div>
<div id="body-div">
    <t:body/>
</div>
<div id="footer-div">
    <hr/>
    copyright 2000-2007 ...
</div>
</body>
</html>
```

> - you see `<t:body/>` in this template. your pages template will be go here.

> - you see an expression (`${title}`) here for page title. you most set each page title from page template.

### Create Layout Class ###
Create a Java class(`Layout.java`, component class and template name most be same) in your application components package.
put the following code in your class file :
```

    @Parameter(required = true)
    private String title;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
```

> - the `@Parameter` annotation indicate that `title` is a parameter and this parameter is mandatory (`required=true`). you most write setter and getter for change or access value of this parameter from pages and component template.

## Change The Page Templates ##
all pages that you want to have layout most be like this :

```
<span t:type="layout" t:title="literal:PageTitle" xmlns:t="http://tapestry.apache.org/schema/tapestry_5_0_0.xsd">
  Page Content goes here...
</span>
```

**for more about Tapestry Components go [http://tapestry.apache.org/tapestry5/tapestry-core/](http://tapestry.apache.org/tapestry5/tapestry-core/)**

good luck.
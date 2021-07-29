package qio.support;

import qio.Qio;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//either declared in web.xml <listeners> or via annotation, here we are using web.xml definition
//@WebListener
public class StartupListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        try {

            ServletContext servletContext = sce.getServletContext();

            new Qio.Injector()
                    .devMode(true)//tells Qio to initialize h2
                    .withDataEnabled(true)//is needed when accessing a database
                    .asEmbedded(true)//yes, as we are using the maven jetty plugin
                    .withContext(servletContext)//qio needs this to store information to be used later
                    .withWebResources(new String[]{ "assets" })//any directory within webapps that will serve static content
                    .withPropertyFiles(new String[]{ "app.props" })//our properties files
                    .inject();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("context destroyed...");
    }
}

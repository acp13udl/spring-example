package com.udl.softarch.springexample.init;

import com.udl.softarch.springexample.config.GreetingAppContext;
import com.udl.softarch.springexample.filters.SimpleCORSFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class Initializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(GreetingAppContext.class);
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(rootContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
        servletContext.addFilter("CORSFilter", new SimpleCORSFilter()).addMappingForUrlPatterns(null, false, "/*");
        servletContext.addFilter("httpMethodFilter", new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null, false, "/*");
        servletContext.addListener(new ContextLoaderListener(rootContext));
    }

}

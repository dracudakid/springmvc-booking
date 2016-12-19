package com.mgmtp.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;


public class SimpleWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    private final String DEFAULT_PROFILE = "prod";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        String activeProfile = System.getProperty("spring.profiles.active");
        if(activeProfile == null){
            servletContext.setInitParameter("spring.profiles.active", DEFAULT_PROFILE);
        }
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { RootConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{ WebConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

}


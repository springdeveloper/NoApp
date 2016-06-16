package com.app.npr.config.core;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.app.npr.config.AppsConfig;
import com.app.npr.config.SecurityConfiguration;
import com.app.npr.config.listner.CacheListener;
import com.app.npr.config.listner.SessionListner;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		super.onStartup(servletContext);
		servletContext.addListener(new SessionListner());
		servletContext.addListener(new CacheListener());
	}
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class []{AppsConfig.class,SecurityConfiguration.class
				};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[]{"/"};
	}

}

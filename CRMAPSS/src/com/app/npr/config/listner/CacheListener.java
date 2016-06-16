package com.app.npr.config.listner;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.npr.model.Country;
import com.app.npr.service.util.common.UtilsService;


/**
 * Fill the cache at startup.
 * It put a test value in cache (customerId:1, Name:Smith, Address:Smith Address).
 * @author drieu
 *
 */
public class CacheListener implements ServletContextListener {

	final Logger logger = Logger.getLogger(getClass().getName());
	
    @Autowired
    public CacheManager cacheManager;
    
    @Autowired 
    private UtilsService utilService;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("========> contextInitialized() : BEGIN. ");
  
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

	
	
}
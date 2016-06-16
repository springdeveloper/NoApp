package com.app.npr.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.npr.model.Admin;
import com.app.npr.model.City;
import com.app.npr.model.Country;
import com.app.npr.model.State;
import com.app.npr.model.lead.Address;
import com.app.npr.model.lead.Lead;
import com.app.npr.model.lead.LeadSource;
import com.app.npr.service.lead.AddressService;
import com.app.npr.service.lead.LeadService;
import com.app.npr.service.lead.SourceService;
import com.app.npr.service.lead.UtilsCommon;
import com.app.npr.service.util.common.UtilsService;
import com.app.npr.util.UrlApi;

@Controller
@Scope("request")
public class HomeController {
   private static Logger LOG = LoggerFactory.getLogger(HomeController.class);
	
    @Autowired 
    private SourceService sourceService;
	
    @Autowired 
    @Qualifier("utilCommonBusiness")
    private UtilsCommon utilsCommon;
    
    @Autowired 
    @Qualifier("utilCommonImpl")
    private UtilsCommon utilsCommons;
	
    @Autowired
    @Qualifier("utilsServiceImpl")
    private UtilsService utils;

	@Autowired
	private UtilsService utilsService;
	
	@Autowired
	 ListableBeanFactory localListableBeanFactory ;
    
	@RequestMapping(value="/")
	public String home() throws Exception{
	System.out.println();
		return "index";
	}
	
	

 
		
}

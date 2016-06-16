package com.app.npr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;

import com.app.npr.model.lead.LeadSource;
import com.app.npr.service.lead.SourceService;
import com.app.npr.util.LogUtil;

@Configuration
@PropertySource("classpath:/application.properties")
@ComponentScan({ "com.app.npr.*", "com.app.npr.config.*", "com.app.npr.dao", "com.app.npr.service" })
@EnableAspectJAutoProxy
@Import({

		WebMvcConfigurerAdapterConfig.class, HibernateConfig.class, CacheConfig.class })
public class AppsConfig {

}

package com.app.npr.config;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import com.app.npr.config.debug.Settings;
import com.app.npr.dao.Impl.lead.LeadRepositoryImpl;
import com.app.npr.service.util.common.UtilsService;
import com.app.npr.util.LogUtil;
import com.app.npr.util.LoggingAspect;
import com.app.npr.util.MyInterceptor;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

@EnableWebMvc
@Lazy
public class WebMvcConfigurerAdapterConfig extends WebMvcConfigurerAdapter {
		/** The debug. */
	private Boolean debug = Settings.WEB_MVC_CONFIGURER_ADAPTER_CONFIG.getValue();
	// private static String DATE_FORMAT = "YYYY-MM-dd HH:mm:ss";
	private static String DATE_FORMAT = "yyyy-MM-dd HH:mm";

	/**
	 * View resolver.
	 *
	 * @return the internal resource view resolver
	 */
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setCache(true);

		return viewResolver;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
	 * #addResourceHandlers(org.springframework.web.servlet.config.annotation.
	 * ResourceHandlerRegistry)
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(31556926);
		registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/*")
				.addResourceLocations("/resources/").setCachePeriod(31556926);
		registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/resources/template_lib/js/*")
				.addResourceLocations("/resources/").setCachePeriod(31556926);
		registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/resources/template_lib/css/*")
				.addResourceLocations("/resources/").setCachePeriod(31556926);
		registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/resources/template_lib/images/*")
				.addResourceLocations("/resources/").setCachePeriod(31556926);
		registry.addResourceHandler("/fonts/**").addResourceLocations("/WEB-INF/resources/template_lib/fonts/*")
				.addResourceLocations("/resources/").setCachePeriod(31556926);
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}
	 
	public MappingJackson2HttpMessageConverter jacksonMessageConverter() {
		MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();

		ObjectMapper mapper = new ObjectMapper();

		Hibernate4Module hibernate4Module = new Hibernate4Module();
		hibernate4Module.disable(Hibernate4Module.Feature.USE_TRANSIENT_ANNOTATION);

		mapper.registerModule(hibernate4Module);
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
		mapper.configure(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS, false);
		mapper.setSerializationInclusion(Include.NON_NULL);
		DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Dhaka"));
		mapper.setDateFormat(dateFormat);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false);

		if (debug) {
			messageConverter.setPrettyPrint(true);
		}

		messageConverter.setObjectMapper(mapper);
		return messageConverter;
	}

	/**
	 * String message converter.
	 *
	 * @return the string http message converter
	 */
	public StringHttpMessageConverter stringMessageConverter() {
		StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();

		return stringHttpMessageConverter;
	}

	/**
	 * Buffered image http message converter.
	 *
	 * @return the buffered image http message converter
	 */
	public BufferedImageHttpMessageConverter bufferedImageHttpMessageConverter() {
		BufferedImageHttpMessageConverter bufferedImageHttpMessageConverter = new BufferedImageHttpMessageConverter();
		return bufferedImageHttpMessageConverter;
	}

	/**
	 * Mapper.
	 *
	 * @return the object mapper
	 */
	@Bean(name = "mapper")
	public ObjectMapper mapper() {
		ObjectMapper mapper = new ObjectMapper();

		Hibernate4Module hibernate4Module = new Hibernate4Module();
		hibernate4Module.disable(Hibernate4Module.Feature.USE_TRANSIENT_ANNOTATION);

		mapper.registerModule(hibernate4Module);

		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.setDateFormat(new SimpleDateFormat(DATE_FORMAT));
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false);

		return mapper;
	}

	@Bean(name = "messageSource")
	public MessageSource getMessageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

	@Bean
	public LoggingAspect loggingAspect() {
		return new LoggingAspect();
	}
	@Bean
	public LogUtil logUtil() {
		return new LogUtil();
	}

	@Bean
	public MyInterceptor myint() {
		return new MyInterceptor();
	}

}

package com.store.firstmotors.config;


import java.util.List;

import com.store.firstmotors.domain.serealization.converter.YamlJackson2HttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		
		converters.add(new YamlJackson2HttpMessageConverter());
	}


	private static final MediaType MEDIA_TYPE_APPLICATION_YML = MediaType.valueOf("application/x-yaml");

	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		
		
//		configurer.favorParameter(true)
//		    .parameterName("mediaType").ignoreAcceptHeader(true)
//		    .useRegisteredExtensionsOnly(false)
//		    .defaultContentType(MediaType.APPLICATION_JSON)
//		       .mediaType("json",MediaType.APPLICATION_JSON)
//		       .mediaType("xml",MediaType.APPLICATION_ATOM_XML); 
		
		configurer.favorParameter(false)
	    .ignoreAcceptHeader(false)
	    .useRegisteredExtensionsOnly(false)
	    .defaultContentType(MediaType.APPLICATION_JSON)
	       .mediaType("json",MediaType.APPLICATION_JSON)
	       .mediaType("xml",MediaType.APPLICATION_ATOM_XML)
		   .mediaType("yaml", MEDIA_TYPE_APPLICATION_YML); 
	}
	

}

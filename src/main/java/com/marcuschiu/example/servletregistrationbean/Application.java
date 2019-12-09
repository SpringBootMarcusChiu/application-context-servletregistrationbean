package com.marcuschiu.example.servletregistrationbean;

import com.marcuschiu.example.servletregistrationbean.config.CustomWebMvcConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@EnableAutoConfiguration
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public ServletRegistrationBean apiV2() {
		DispatcherServlet dispatcherServlet = new DispatcherServlet();

		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.register(CustomWebMvcConfigurer.class);
		dispatcherServlet.setApplicationContext(applicationContext);

		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet, "/api/2/*");
		servletRegistrationBean.setName("api-v2");
		return servletRegistrationBean;
	}

//    @Bean
//    public ServletRegistrationBean apiV1() {
//        DispatcherServlet dispatcherServlet = new DispatcherServlet();
//
//        XmlWebApplicationContext applicationContext = new XmlWebApplicationContext();
//        applicationContext.setConfigLocation("classpath:/META-INF/spring/webmvc-context.xml");
//        dispatcherServlet.setApplicationContext(applicationContext);
//
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet, "/api/1/*");
//        servletRegistrationBean.setName("api-v1");
//
//        return servletRegistrationBean;
//    }
}

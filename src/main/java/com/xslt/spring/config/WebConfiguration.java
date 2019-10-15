package com.xslt.spring.config;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;
import org.springframework.web.servlet.view.xslt.XsltView;
import org.springframework.web.servlet.view.xslt.XsltViewResolver;
 
@Configuration
@ComponentScan(basePackages="net.codejava.spring")
@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer{
 
    @Bean
    public ViewResolver getXSLTViewResolver(){
         
        XsltViewResolver xsltResolover = new XsltViewResolver();
        xsltResolover.setOrder(1);
        xsltResolover.setSourceKey("xmlSource");
         
        xsltResolover.setViewClass(XsltView.class);
        xsltResolover.setViewNames(new String[] {"XSLTView"});
        xsltResolover.setPrefix("/WEB-INF/xsl/");
        xsltResolover.setSuffix(".xsl");
         
        return xsltResolover;
    }
     
    @Bean
    public ViewResolver getJSPViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".html");
        resolver.setOrder(2);
        return resolver;
    }
     
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
}
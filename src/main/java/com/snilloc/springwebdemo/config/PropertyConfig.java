package com.snilloc.springwebdemo.config;

import com.snilloc.springwebdemo.repositories.FakeDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
// Good for one file
//@PropertySource({"classpath:datasource.properties", "classpath:jms.properties" })
@PropertySources( {
        @PropertySource("classpath:datasource.properties"),
        @PropertySource("classpath:jms.properites")
})
public class PropertyConfig {

    @Autowired
    Environment env;

    @Value("snilloc.user")
    String user;

    @Value("${snilloc.pwd")
    String passwd;

    @Value("${snilloc.url")
    String url;

    @Value("${snilloc.jms.user}")
    String jmsUSer;

    @Bean
    public FakeDataSource fakeDataSource() {
        String realUser = env.getProperty("SNILLOC_USER");
        FakeDataSource fakeDataSource = new FakeDataSource(realUser, passwd, url);
        return fakeDataSource;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }

}

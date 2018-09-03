package com.sie.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.sun.java.swing.plaf.windows.resources.windows_es;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druid(){
        return new DruidDataSource();
    }

    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String,String> initParam = new HashMap<>();
        initParam.put("jmxUsername","admin");
        initParam.put("jmxPassword","123456");
        bean.setInitParameters(initParam);
        return bean;
    }

    @Bean
    public FilterRegistrationBean statViewFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String,String> initParam = new HashMap<>();
        initParam.put("exclusions","*.css,*.js,/druid/*");
        bean.setInitParameters(initParam);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}

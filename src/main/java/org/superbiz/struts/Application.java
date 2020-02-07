package org.superbiz.struts;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filter = new FilterRegistrationBean<>(new SiteMeshFilter());
        filter.addUrlPatterns("/*");
        filter.setOrder(1);
        return filter;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBeanStrutsPrepareAndExecuteFilter() {
        FilterRegistrationBean filter = new FilterRegistrationBean<>(new StrutsPrepareAndExecuteFilter());
        filter.addUrlPatterns("/");
        filter.addUrlPatterns("/addUserForm.action");
        filter.addUrlPatterns("/addUser.action");
        filter.addUrlPatterns("/findUserForm.action");
        filter.addUrlPatterns("/findUser.action");
        filter.addUrlPatterns("/listAllUsers.action");
        filter.setOrder(2);
        return filter;
    }

}

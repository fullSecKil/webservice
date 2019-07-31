package com.cxfd.demo.config;

import com.cxfd.demo.service.UserService;
import com.cxfd.demo.service.impl.UserServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;


/**
 * CxfConfig
 *
 * @author dusk
 * @since 2019/7/31
 */
@Configuration
public class CxfConfig {

    @Autowired
    private UserService userService;

    // 网上很多教程的配置类中，第一个@Bean的方法名都是 dispatcherServlet, 改一下就行
    @Bean
    public ServletRegistrationBean doDisServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/test/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public Endpoint endpoint(SpringBus springBus) {
        EndpointImpl endpoint = new EndpointImpl(springBus, userService);
        endpoint.publish("/user");
        return endpoint;
    }
}

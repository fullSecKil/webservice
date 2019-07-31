package com.cxfd.demo;

import com.cxfd.demo.pojo.User;
import com.cxfd.demo.utils.JsonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONUtil;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void cxfTest() throws Exception {
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost:6930/test/user?wsdl");
        Object[] name = client.invoke("getName", "xr");
        String n1 = (String) name[0];
        System.out.println(n1);
        Object[] objects = client.invoke("getUser", "411001");
        Object o1 = objects[0];
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(o1);
        System.out.println("-------->" + json);
    }

}

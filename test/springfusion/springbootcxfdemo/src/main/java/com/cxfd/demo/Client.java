package com.cxfd.demo;

import com.cxfd.demo.pojo.User;
import com.cxfd.demo.utils.JsonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import java.util.List;
import java.util.Map;

/**
 * Client
 *
 * @author dusk
 * @since 2019/7/31
 */
public class Client {
    public static void main(String[] args) throws Exception {
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        org.apache.cxf.endpoint.Client client = dcf.createClient("http://localhost:6930/test/user?wsdl");
        //getUser 为接口中定义的方法名称  张三为传递的参数   返回一个Object数组
        Object[] objects = client.invoke("getUser", "411001");
        //输出调用结果
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(objects);
        System.out.println(JsonUtils.jsonToList(json, User.class));
        List u = mapper.readValue(json, List.class);
        System.out.println(((Map) u.get(0)).get("age"));
    }
}

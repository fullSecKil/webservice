package com.cxfd.demo.service;

import com.cxfd.demo.pojo.User;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceProvider;

/**
 * UserService
 *
 * @author dusk
 * @since 2019/7/31
 */
@WebService
@WebServiceProvider
public interface UserService {
    @WebMethod
    String getName(String userId);

    @WebMethod
    User getUser(String userId);
}

package com.systechafrica.app.api.soap;

import com.systechafrica.app.bean.UserBeanI;
import com.systechafrica.app.model.entity.User;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public class UserSoapApi {

    @EJB
    private UserBeanI userBean;

    @WebMethod
    public List<User> list() {
        System.out.println("SOAP>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+userBean.list(new User()));
        return userBean.list(new User());
    }

}

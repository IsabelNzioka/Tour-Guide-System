package com.systechafrica.action;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;

import com.systechafrica.app.model.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class BaseAction extends HttpServlet {
    public void serializeForm(Object bean, Map<String, ? extends Object> requestMap) {
        try{
            BeanUtilsBean beanUtilsBean = new BeanUtilsBean(new ConvertUtilsBean() {
                @Override
                public Object convert(String value, Class clazz) {
                    if (clazz.isEnum()) {
                        return Enum.valueOf(clazz, value);
                    } else {
                        return super.convert(value, clazz);
                    }
                }
            });

//            BeanUtils.populate(bean, requestMap); //provides a set of static methods for basic bean manipulation,
            beanUtilsBean.populate(bean, requestMap); // customizable instance-based utility that allows for more fine-grained control over the bean manipulation process.
        }catch(IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch(
                InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }


    // AppPage
     public void renderPage(HttpServletRequest req, HttpServletResponse res, int activeMenu, String content) throws ServletException, IOException {
        req.setAttribute("activeMenu", activeMenu);
        req.setAttribute("content", content);

        RequestDispatcher dispatcher = req.getRequestDispatcher("./appPage.jsp");
        dispatcher.forward(req, res);

     }



}

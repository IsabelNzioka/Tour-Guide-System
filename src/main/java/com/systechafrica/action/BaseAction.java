package com.systechafrica.action;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;

import javax.servlet.http.HttpServlet;
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


}

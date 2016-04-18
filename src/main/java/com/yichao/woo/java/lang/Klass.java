package com.yichao.woo.java.lang;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;

import javax.xml.ws.http.HTTPBinding;
import javax.xml.ws.spi.http.HttpContext;
import java.lang.annotation.Repeatable;

/**
 * Created by Yichao-Woo.
 */
public class Klass {

    public static void main(String[] args) {
        System.out.println(Class.class.toGenericString());
        System.out.println(Repeatable.class.toGenericString());
        System.out.println(HTTPBinding.class.toGenericString());
        System.out.println(HttpContext.class.toGenericString());
        System.out.println(Thread.State.class.toGenericString());
        System.out.println(boolean.class.toGenericString());
        System.out.println(Klass.class.toGenericString());


        System.out.println(boolean.class.isAssignableFrom(boolean.class));
        System.out.println(BeanFactory.class.isAssignableFrom(ApplicationContext.class));

        int[] a = new int[10];
        System.out.println(a.getClass().isArray());
    }
}

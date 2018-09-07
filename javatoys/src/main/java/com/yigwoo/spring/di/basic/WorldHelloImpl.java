package com.yigwoo.spring.di.basic;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class WorldHelloImpl implements HelloWorld{
    @Override
    public String helloWorld() {
        return "World Hello";
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath*:spring.xml");
        ctx.refresh();

        WorldHelloImpl worldHelloImpl = (WorldHelloImpl) ctx.getBean("worldHelloImpl");
        System.out.println(worldHelloImpl.helloWorld());
    }
}

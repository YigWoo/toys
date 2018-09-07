package com.yigwoo.spring.aop.pointcut;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class StaticPointCutExample {
    public static void main(String[] args) {
        BeanOne beanOne = new BeanOne();
        BeanTwo beanTwo = new BeanTwo();

        Pointcut pc = new SimpleStaticPointCut();
        Advice advice = new SimpleAdvice();
        Advisor advisor = new DefaultPointcutAdvisor(pc, advice);

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(beanOne);

        BeanOne beanOne1 = (BeanOne) pf.getProxy();

        pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(beanTwo);

        BeanTwo beanTwo1 = (BeanTwo) pf.getProxy();

        beanOne1.foo();
        beanOne1.bar();

        beanTwo1.foo();
        beanTwo1.bar();
    }
}

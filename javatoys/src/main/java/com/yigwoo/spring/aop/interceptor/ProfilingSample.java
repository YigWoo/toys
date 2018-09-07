package com.yigwoo.spring.aop.interceptor;

import org.springframework.aop.framework.ProxyFactory;

public class ProfilingSample {
    public static void main(String[] args) {
        WorkerBean workerBean = new WorkerBean();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(workerBean);
        proxyFactory.addAdvice(new ProfilingInterceptor());

        WorkerBean proxy = (WorkerBean) proxyFactory.getProxy();
        proxy.doSomeWork(100000);

    }


}

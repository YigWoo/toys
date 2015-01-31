package com.yichao.woo.spring.aop.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

public class ProfilingInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start(invocation.getMethod().getName());

        Object returnVal = invocation.proceed();

        stopWatch.stop();
        dumpInfo(invocation, stopWatch.getTotalTimeMillis());
        return returnVal;
    }

    private void dumpInfo(MethodInvocation invocation, long totalTimeMillis) {
        Method method = invocation.getMethod();
        Object[] arguments = invocation.getArguments();
        Object target = invocation.getThis();

        System.out.println(method.getName());
        System.out.println(target.getClass().getName());

        for (Object argument : arguments) {
            System.out.println(argument);
        }

        System.out.println();

        System.out.println(totalTimeMillis);
    }
}

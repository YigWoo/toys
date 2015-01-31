package com.yichao.woo.spring.aop.interceptor;

public class WorkerBean {

    public void doSomeWork(int numOfTime) {
        for (int i = 0; i < numOfTime; i++) {
            work();
        }
    }

    private void work() {
        System.out.print("");
    }


}

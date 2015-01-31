package com.yichao.woo.spring.di.method.lookup;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class LookupDemo {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:lookup.xml");
        context.refresh();

        DemoBean absBean = (DemoBean) context.getBean("absLookupDemoBean");
        DemoBean stdBean = (DemoBean) context.getBean("stdLookupDemoBean");

        displayInfo(absBean);
        displayInfo(stdBean);
    }

    public static void displayInfo(DemoBean bean) {
        MyHelper helper1 = bean.getHelper();
        MyHelper helper2 = bean.getHelper();

        // 在 Spring 中 helper1 不一定就和 helper2 是同一个 object
        System.out.println("Helper Instances the Same?: "
                + (helper1 == helper2));

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");

        for (int x = 0; x < 100000; x++) {
            MyHelper helper = bean.getHelper();
            helper.doSomethingHelpful();
        }

        stopWatch.stop();

        System.out.println("100000 gets took " + stopWatch.getTotalTimeMillis() + " ms");
    }
}

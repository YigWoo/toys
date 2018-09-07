package com.yigwoo.spring.di.method.lookup;

public abstract class AbsLookupDemoBean implements DemoBean {

    @Override
    public abstract MyHelper getHelper();


    @Override
    public void someOperation() {
        getHelper().doSomethingHelpful();
    }
}

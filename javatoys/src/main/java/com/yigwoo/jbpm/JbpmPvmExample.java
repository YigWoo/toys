package com.yigwoo.jbpm;

import org.jbpm.api.ProcessDefinition;
import org.jbpm.pvm.internal.builder.ProcessDefinitionBuilder;
import org.jbpm.pvm.internal.model.ProcessDefinitionImpl;

public class JbpmPvmExample {

    private String a;

    public static void main(String[] args) {
        JbpmPvmExample jbpmPvmExample = new JbpmPvmExample();

        jbpmPvmExample.run();
    }

    private void run() {
        a = "a";

    }

}

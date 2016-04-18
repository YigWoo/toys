package com.yichao.woo.java.annotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/**
 * Created by Yichao-Woo.
 */
public class RepeatingAnnotation {

    @Repeatable(Foos.class)
    public @interface Foo {
        String bar();
    }

    @Retention(RetentionPolicy.RUNTIME) /* if not present, the stdout will be different, try it if you forget that */
    public @interface Foos {
        Foo[] value();
    }

    @Foo(bar = "baz")
    @Foo(bar = "qux")
    public void duplicate() {
    }


    public static void main(String[] args) throws NoSuchMethodException {
        Class<RepeatingAnnotation> raClass = RepeatingAnnotation.class;

        Method duplicate = raClass.getMethod("duplicate");
        Foo[] annotations = duplicate.getAnnotationsByType(Foo.class);

        System.out.println(annotations.length);

        for (Foo annotation : annotations) {
            System.out.println(annotation.bar());
        }
    }
}

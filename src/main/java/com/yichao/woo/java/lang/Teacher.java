package com.yichao.woo.java.lang;

/**
 * Created by wuyichao on 2017/4/24.
 */
public class Teacher extends Person{
    private String name="tom";
    public Teacher(){
        System.out.println("this is a teacher");
        super();
    }

    public static void main(String[] args){
        Teacher teacher = new Teacher();
        System.out.println(this.name);
    }
}
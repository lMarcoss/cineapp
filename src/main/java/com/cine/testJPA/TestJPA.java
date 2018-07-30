package com.cine.testJPA;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJPA {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");

        context.close();
    }
}

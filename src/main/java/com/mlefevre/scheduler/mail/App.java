package com.mlefevre.scheduler.mail;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("job-config.xml");
    }

}

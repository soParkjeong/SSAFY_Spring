package com.ssafy.hw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopTest {

    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");

        System.out.println("******1.GeneralUser");
        User generalUser = context.getBean("generalUser", User.class);
        try {
            generalUser.useApp();
            System.out.println("정상 종료");
        } catch (ApplicationException e) {
            System.out.println("예외 발생");
        }

        System.out.println("******2.AdminUser");
        User adminUser = context.getBean("adminUser", User.class);
        try {
            adminUser.useApp();
            System.out.println("정상 종료");
        } catch (ApplicationException e) {
            System.out.println("예외 발생");
        }
    }
}

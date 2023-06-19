package ru.itsjava;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("ru.itsjava")
public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        KindFarmer kindFarmer1 = context.getBean(KindFarmer.class);
//        KindFarmer kindFarmer2 = context.getBean(KindFarmer.class);
//
//        System.out.println(kindFarmer1);
//        System.out.println(kindFarmer2);
//        System.out.println("kindFarmer1==kindFarmer2 = " + (kindFarmer1 == kindFarmer2));
        context.close();

    }
}

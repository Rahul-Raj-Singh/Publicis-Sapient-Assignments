package com.IOC.Learn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext factory = new ClassPathXmlApplicationContext(new String[] 
        		{"mobileContext.xml", "screenContext.xml", "speakerContext.xml", "cameraContext.xml"});
        Mobile mob = (Mobile) factory.getBean("mob");
        mob.displayConfig();
    }
}

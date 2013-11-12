package info.chenqin.service;

import info.chenqin.event.EmailEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: Nathanchen Date: 16/09/13 Time: 9:32 AM Description:
 */
public class SpringTest
{
    public static void main(String[] args)
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        System.out.println(applicationContext);

        PersonService personService = applicationContext.getBean("personService", PersonService.class);
        personService.info();

        EmailEvent emailEvent = new EmailEvent("hello", "natechen@me.com", "this is a test");
        applicationContext.publishEvent(emailEvent);
    }
}

package info.chenqin.listener;

import info.chenqin.event.EmailEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: Nathanchen Date: 11/11/13 Time: 9:24 AM Description:
 */
public class TestEmailNotifier
{
    public static void main(String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        EmailEvent event = new EmailEvent("hello", "natechen@me.com", "this is the body");
        ctx.publishEvent(event);
    }
}

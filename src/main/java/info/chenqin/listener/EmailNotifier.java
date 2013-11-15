package info.chenqin.listener;

import info.chenqin.event.EmailEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * User: Nathanchen Date: 16/09/13 Time: 11:15 AM Description:
 */
public class EmailNotifier implements ApplicationListener
{
    @Override
    public void onApplicationEvent (ApplicationEvent applicationEvent)
    {
        if (applicationEvent instanceof EmailEvent)
        {
            EmailEvent emailEvent = (EmailEvent) applicationEvent;
            System.out.println("email address: " + emailEvent.getAddress());
            System.out.println("email text: " + emailEvent.getText());
        }
        else
        {
            System.out.println("nothing");
        }
    }
}

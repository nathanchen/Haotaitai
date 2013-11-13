package info.chenqin.event;

import org.springframework.context.ApplicationEvent;

/**
 * User: Nathanchen Date: 16/09/13 Time: 11:12 AM Description:
 */
public class EmailEvent extends ApplicationEvent
{
    private String address;
    private String text;

    public EmailEvent (Object source)
    {
        super(source);
    }

    public EmailEvent (Object source, String address, String text)
    {
        super(source);
        this.address = address;
        this.text = text;
    }

    public String getAddress ()
    {
        return address;
    }

    public void setAddress (String address)
    {
        this.address = address;
    }

    public String getText ()
    {
        return text;
    }

    public void setText (String text)
    {
        this.text = text;
    }
}

package info.chenqin.service;

/**
 * User: Nathanchen Date: 16/09/13 Time: 9:32 AM Description:
 */
public class PersonService
{
    private String name;

    public void setName (String name)
    {
        this.name = name;
    }

    public void info()
    {
        System.out.println("this person's name is: " + name);
    }
}

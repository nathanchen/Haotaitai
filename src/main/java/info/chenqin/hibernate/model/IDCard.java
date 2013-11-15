package info.chenqin.hibernate.model;

/**
 * User: Nathanchen Date: 14/11/13 Time: 2:05 PM Description:
 */
public class IDCard
{
    private int id;
    private String number;
    private Person person;

    public IDCard (String number, Person person)
    {
        this.number = number;
        this.person = person;
    }

    public IDCard ()
    {

    }

    public int getId ()
    {
        return id;
    }

    public void setId (int id)
    {
        this.id = id;
    }

    public String getNumber ()
    {
        return number;
    }

    public void setNumber (String number)
    {
        this.number = number;
    }

    public Person getPerson ()
    {
        return person;
    }

    public void setPerson (Person person)
    {
        this.person = person;
    }
}

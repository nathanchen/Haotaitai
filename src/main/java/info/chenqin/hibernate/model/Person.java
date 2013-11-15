package info.chenqin.hibernate.model;

/**
 * User: Nathanchen Date: 14/11/13 Time: 2:06 PM Description:
 */
public class Person
{
    private int id;
    private String name;
    private IDCard idCard;

    public IDCard getIdCard ()
    {
        return idCard;
    }

    public void setIdCard (IDCard idCard)
    {
        this.idCard = idCard;
    }

    public Person ()
    {
    }

    public Person (String name)
    {
        this.name = name;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public int getId ()
    {
        return id;
    }

    public void setId (int id)
    {
        this.id = id;
    }
}

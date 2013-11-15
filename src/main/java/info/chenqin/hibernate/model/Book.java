package info.chenqin.hibernate.model;

/**
 * User: Nathanchen Date: 13/11/13 Time: 4:04 PM Description:
 */
public class Book
{
    private int id;
    private String name;
    private double price;

    public int getId ()
    {
        return id;
    }

    public void setId (int id)
    {
        this.id = id;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public double getPrice ()
    {
        return price;
    }

    public void setPrice (double price)
    {
        this.price = price;
    }
}

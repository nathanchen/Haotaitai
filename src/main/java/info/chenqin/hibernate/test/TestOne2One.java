package info.chenqin.hibernate.test;

import info.chenqin.hibernate.model.IDCard;
import info.chenqin.hibernate.model.Person;
import info.chenqin.hibernate.util.HibernateUtil;
import org.hibernate.Session;

/**
 * User: Nathanchen Date: 14/11/13 Time: 4:36 PM Description:
 */
public class TestOne2One
{
    public static void main(String[] args)
    {
        TestOne2One testOne2One = new TestOne2One();
        testOne2One.testAdd02();
    }


    public void testAdd01()
    {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            session.beginTransaction();

            Person person = new Person();
            person.setName("zhang");
            session.save(person);

            IDCard idCard = new IDCard();
            idCard.setNumber("111");
            idCard.setPerson(person);

            session.save(idCard);

            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            if (session != null)
                session.getTransaction().rollback();
        }
        finally {
            if (session != null)
                session.close();
        }
    }

    public void testAdd02()
    {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            session.beginTransaction();

            IDCard idCard = new IDCard();
            idCard.setNumber("2222");
            session.save(idCard);

            Person person = new Person();
            person.setName("wqqd");
            session.save(person);

            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            if (session != null)
                session.getTransaction().rollback();
        }
        finally {
            if (session != null)
                session.close();
        }
    }

    public void testLoad01()
    {
        Session session = null;
        try
        {
            session = HibernateUtil.openSession();
            IDCard idCard = (IDCard) session.load(IDCard.class, 1);
            System.out.println(idCard.getNumber() + ", " + idCard.getPerson().getName());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (session != null)
                session.close();
        }
    }

    public void testLoad02()
    {
        Session session = null;
        try
        {
            session = HibernateUtil.openSession();
            Person person = (Person) session.load(Person.class, 1);
            System.out.println(person.getName() + ", " + person.getIdCard().getNumber());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (session != null)
                session.close();
        }
    }
}

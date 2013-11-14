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
        testOne2One.testAdd();
    }


    public void testAdd()
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
}

package info.chenqin.hibernate.test;

import info.chenqin.hibernate.model.Book;
import info.chenqin.hibernate.util.HibernateUtil;
import org.hibernate.Session;

/**
 * User: Nathanchen Date: 13/11/13 Time: 4:29 PM Description:
 */
public class TestIDGen
{
    public static void main(String[] args)
    {
        TestIDGen testIDGen = new TestIDGen();
    }

    public void testAssigned()
    {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            session.beginTransaction();

            Book book = new Book();
            book.setId(2);
            book.setName("Thinking in Java");

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

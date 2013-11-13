package info.chenqin.hibernate.test;

import info.chenqin.hibernate.model.User;
import info.chenqin.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Nathanchen Date: 13/11/13 Time: 11:42 AM Description:
 */
public class TestCRUD
{
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static void main (String[] args)
    {
        TestCRUD test = new TestCRUD();
//        test01();
        test.testList();
    }

    public void testAdd ()
    {
        Session session = null;
        try
        {
            session = HibernateUtil.openSession();
            session.beginTransaction();

            User user = new User("username345", "345", "nickname2222", sdf.parse("1987-09-09"));
            session.save(user);

            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            if (session != null)
            {
                session.getTransaction().rollback();
            }
        }
        finally
        {
            if (session != null)
            {
                session.close();
            }
        }
    }

    public void testLoad ()
    {
        Session session = null;
        try
        {
            session = HibernateUtil.openSession();
            User user = (User) session.load(User.class, Integer.valueOf(1));
            System.out.println(user);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (session != null)
            {
                session.close();
            }
        }
    }

    public void testUpdate ()
    {
        Session session = null;
        try
        {
            session = HibernateUtil.openSession();
            session.beginTransaction();

            User user = (User) session.load(User.class, Integer.valueOf(1));

            user.setNickname("update123");
            session.update(user);

            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            if (session != null)
            {
                session.getTransaction().rollback();
            }
        }
        finally
        {
            if (session != null)
            {
                session.close();
            }
        }
    }

    public void testDelete ()
    {

    }

    public void testList ()
    {
        Session session = null;
        try
        {
            session = HibernateUtil.openSession();
            List<User> users = (ArrayList<User>) session.createQuery("from User").list();
            for (User u : users)
            {
                System.out.println(u);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (session != null)
            {
                session.close();
            }
        }
    }

    public void testPager ()
    {
        Session session = null;
        try
        {
            session = HibernateUtil.openSession();
            List<User> users = (ArrayList<User>) session.createQuery("from User")
                    .setFirstResult(0).setMaxResults(2).list();
            for (User u : users)
            {
                System.out.println(u);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (session != null)
            {
                session.close();
            }
        }
    }

}

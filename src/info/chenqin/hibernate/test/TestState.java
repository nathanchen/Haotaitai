package info.chenqin.hibernate.test;

import info.chenqin.hibernate.model.User;
import info.chenqin.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.text.SimpleDateFormat;

/**
 * User: Nathanchen Date: 13/11/13 Time: 11:43 AM Description:
 */
public class TestState
{
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args)
    {
        TestState testState = new TestState();
        testState.testPersistent03();
    }

    /**
     * 持久化状态：数据库中有的，从数据库中读取出来的 session.load
     *
     * 离线状态：数据库中有的，在外部调用的 user.setId(10)
     *
     * 瞬时状态：数据库中没有的
     *
     * */
    public void testTransient()
    {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            session.beginTransaction();

            User user = new User("stata", "password123", "statse", sdf.parse("1999-09-01"));

            session.save(user);

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

    public void testPersistent01()
    {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            session.beginTransaction();

            User user = new User("stata", "password123", "statse", sdf.parse("1999-09-01"));

            session.save(user);

            user.setNickname("persistent");

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

    public void testPersistent02()
    {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            session.beginTransaction();

            User user = new User("stata", "password123", "statse", sdf.parse("1999-09-01"));
            session.save(user);

            user.setNickname("persistent");
            session.save(user);

            user.setPassword("456");
            session.update(user);

            user.setUsername("sss");
            session.update(user);

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

    public void testPersistent03()
    {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            session.beginTransaction();

            User user = new User("staee", "passwowww23", "staewewtse", sdf.parse("1939-09-01"));
            session.save(user);

            session.save(user);

            session.update(user);

            session.update(user);

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

    public void testPersistent04()
    {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            session.beginTransaction();

            User user = (User) session.load(User.class, Integer.valueOf(5));

            user.setNickname("111wwd");

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

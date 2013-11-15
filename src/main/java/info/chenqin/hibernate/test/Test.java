package info.chenqin.hibernate.test;

import info.chenqin.hibernate.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: Nathanchen Date: 13/11/13 Time: 10:33 AM Description:
 */
public class Test
{
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static void main (String[] args)
    {
        test01();
    }

    public static void test01 ()
    {
        Configuration cfg = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);
        Session session = null;
        try
        {
            session = sessionFactory.openSession();
            session.beginTransaction();

            User user = new User();
            user.setNickname("hao123");
            user.setBorn(new Date());
            user.setPassword("123");
            user.setUsername("username123");

            session.save(user);

            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            if (session != null)
                session.getTransaction().rollback();
        }
        finally
        {
            if (session != null)
                session.close();
        }
    }


}

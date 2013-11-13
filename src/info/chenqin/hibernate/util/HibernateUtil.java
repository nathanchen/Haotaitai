package info.chenqin.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * User: Nathanchen Date: 13/11/13 Time: 10:59 AM Description:
 */
public class HibernateUtil
{
    private final static SessionFactory FACTORY = buildSessionFactory();

    private static SessionFactory buildSessionFactory()
    {
        Configuration cfg = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        return cfg.buildSessionFactory(serviceRegistry);
    }

    public static SessionFactory getSessionFactory()
    {
        return FACTORY;
    }

    public static Session openSession()
    {
        return FACTORY.openSession();
    }
}

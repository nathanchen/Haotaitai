package info.chenqin.hibernate.dao;

import info.chenqin.hibernate.model.User;
import info.chenqin.hibernate.util.HibernateUtil;
import org.hibernate.Session;

/**
 * User: Nathanchen Date: 13/11/13 Time: 3:09 PM Description:
 */
public class UserDao
{
    public User load(int id)
    {
        Session session = null;
        User user = null;
        try
        {
            session = HibernateUtil.openSession();
            user = (User) session.load(User.class, id);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return user;
    }
}

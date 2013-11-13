package info.chenqin.hibernate.test;

import info.chenqin.hibernate.dao.UserDao;
import info.chenqin.hibernate.model.User;
import info.chenqin.hibernate.util.HibernateUtil;
import org.hibernate.Session;

/**
 * User: Nathanchen Date: 13/11/13 Time: 2:39 PM Description:
 */
public class TestLazyLoad
{
    public static void main(String[] args)
    {
        TestLazyLoad testLazyLoad = new TestLazyLoad();
        testLazyLoad.test02();
    }

    public void test01()
    {
        Session session = null;
        try
        {
            session = HibernateUtil.openSession();
            User user = (User) session.get(User.class, Integer.valueOf(1));

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

    public void test02()
    {
        UserDao userDao = new UserDao();
        User user = userDao.load(1);
        System.out.println(user.getNickname());
    }
}

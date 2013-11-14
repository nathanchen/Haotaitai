package info.chenqin.action.login;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import info.chenqin.models.User;

import java.sql.SQLException;

/**
 * User: Nathanchen Date: 12/09/13 Time: 1:07 PM Description:
 */
public class LoginAction extends ActionSupport
{
    private User user;

    public User getUser ()
    {
        return user;
    }

    public void setUser (User user)
    {
        this.user = user;
    }

    public String execute() throws Exception
    {
        if (getUser().getName().equals("user"))
        {
            System.out.println("user");
        }

        if (getUser().getName().equals("sql"))
        {
            throw new SQLException("username cannot be sql");
        }

        if (getUser().getName().equals("nathan")
                && getUser().getPassword().equals("123"))
        {
            ActionContext.getContext().getSession()
                    .put("user", getUser().getName());
            return SUCCESS;
        }
        else
        {
            return ERROR;
        }
    }
}

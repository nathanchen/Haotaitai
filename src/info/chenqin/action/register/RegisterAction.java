package info.chenqin.action.register;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Date;

/**
 * User: Nathanchen Date: 12/09/13 Time: 3:44 PM Description:
 */
public class RegisterAction extends ActionSupport
{
    private String username;
    private String password;
    private int age;
    private Date birthday;

    public int getAge ()
    {
        return age;
    }

    public void setAge (int age)
    {
        this.age = age;
    }

    public Date getBirthday ()
    {
        return birthday;
    }

    public void setBirthday (Date birthday)
    {
        this.birthday = birthday;
    }

    public String getUsername ()
    {
        return username;
    }

    public void setUsername (String username)
    {
        this.username = username;
    }

    public String getPassword ()
    {
        return password;
    }

    public void setPassword (String password)
    {
        this.password = password;
    }

    public void validate ()
    {
        System.out.println("registerAction valide()");
        if (!username.contains("xx"))
        {
            addFieldError("username", "must contain xx");
        }
    }

    public String execute() throws Exception
    {
        if (getUsername().equals("nathan")
                && getPassword().equals("123"))
        {
            ActionContext.getContext().getSession()
                    .put("user", getUsername());
            return SUCCESS;
        }
        else
        {
            return ERROR;
        }
    }
}

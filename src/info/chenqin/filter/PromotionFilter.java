package info.chenqin.filter;

/**
 * User: Nathanchen Date: 17/09/13 Time: 9:22 AM Description:
 */

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class PromotionFilter implements Filter
{
    @Override
    public void init (FilterConfig filterConfig) throws ServletException
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void doFilter (ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String referer = httpServletRequest.getHeader("referer");

        if (referer!= null && referer.contains("huodong.jsp"))
        {
            Cookie[] cookies = httpServletRequest.getCookies();
            String name, value;
            for (Cookie temp : cookies)
            {
                name = temp.getName();
                value = temp.getValue();
                if (name.equals("promotion") & value.equals("tuiguang.jsp"))
                {
                    temp.setMaxAge(0);
                    System.out.println("cookie found!");
                    break;
                }
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy ()
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}

package info.chenqin.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: Nathanchen Date: 13/09/13 Time: 12:52 PM Description:
 */
public class SessionFilter implements Filter
{
    @Override
    public void init (FilterConfig filterConfig) throws ServletException
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void doFilter (ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        httpServletResponse.sendRedirect("http://www.hao24.cn");
    }

    @Override
    public void destroy ()
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}

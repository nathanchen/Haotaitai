package info.chenqin.exception;

import java.util.Iterator;

/**
 * User: Nathanchen Date: 13/09/13 Time: 10:23 AM Description:
 */
public class MyException extends java.lang.Exception
        implements Iterable<Throwable>
{
    public MyException(String exceptionMessage)
    {

    }

    @Override
    public Iterator<Throwable> iterator ()
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}

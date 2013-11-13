package info.chenqin.webservices;

/**
 * User: Nathanchen Date: 17/09/13 Time: 10:12 AM Description:
 */
import net.spy.memcached.AddrUtil;
import net.spy.memcached.BinaryConnectionFactory;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.internal.GetFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class XMemcachedClient
{
    private static final String NAMESPACE = "hao24mc";
    private static XMemcachedClient instance = null;
    private static MemcachedClient memcachedClient = null;

    private XMemcachedClient (List<String> paramList)
    {
        try
        {
            memcachedClient = new MemcachedClient(new BinaryConnectionFactory(), AddrUtil.getAddresses(paramList));
        }
        catch (Exception localException)
        {
        }
    }

    public static XMemcachedClient getInstance ()
    {
        if (instance == null)
        {
            ArrayList localArrayList = new ArrayList();
            localArrayList.add("172.168.3.7:11222");
            instance = new XMemcachedClient(localArrayList);
        }
        return instance;
    }

    public void put (String paramString1, int paramInt, Object paramObject, String paramString2)
    {
        memcachedClient.set("hao24mc" + paramString2 + paramString1, paramInt, paramObject);
        memcachedClient.incr("", 1);
    }

    public Object get (String paramString1, String paramString2)
    {
        Object localObject = null;
        MemcachedClient localMemcachedClient = memcachedClient;
        GetFuture localGetFuture = localMemcachedClient.asyncGet(NAMESPACE + paramString2 + paramString1);
        try
        {
            localObject = localGetFuture.get(2L, TimeUnit.SECONDS);
        }
        catch (TimeoutException localTimeoutException)
        {
            localMemcachedClient.shutdown();
            instance = null;
            localGetFuture.cancel(false);
            localTimeoutException.printStackTrace();
        }
        catch (Exception localException)
        {
            localMemcachedClient.shutdown();
            instance = null;
            localGetFuture.cancel(false);
        }
        return localObject;
    }
}

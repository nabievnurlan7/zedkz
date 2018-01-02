package info.qazaq.qazaqinfo.data.repositry.datasource;


import info.qazaq.qazaqinfo.data.cache.Cache;

/**
 * Created by Nurlan. Email: nabievnurlan7@gmail.com on 19.11.2017.
 */

public class DataStoreFactory
{
    private final Cache cache;

    public DataStoreFactory(Cache cache)
    {
        this.cache = cache;
    }

    public DataStore create()
    {
//        if(!cache.isExpired() && cache.isCached())
//        {
//            return new LocalDataStore(cache);
//        }
//        else
//        {
            return new CloudDataStore(cache);
//        }
    }
}
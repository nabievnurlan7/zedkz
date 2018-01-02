package info.qazaq.qazaqinfo.data.repositry.datasource;

import java.util.List;

import info.qazaq.qazaqinfo.data.cache.Cache;
import info.qazaq.qazaqinfo.data.entity.DataModel;
import io.reactivex.Observable;

/**
 * Created by Nurlan. Email: nabievnurlan7@gmail.com on 19.11.2017.
 */

public class LocalDataStore implements DataStore
{
    private final Cache cache;

    LocalDataStore(Cache cache)
    {
        this.cache = cache;
    }

    //Return a list of news from DB
    @Override
    public Observable<List<DataModel>> news()
    {
        return cache.get();
    }
}
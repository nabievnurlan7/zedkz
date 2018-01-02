package info.qazaq.qazaqinfo.data.repositry.datasource;

import java.util.List;

import info.qazaq.qazaqinfo.data.cache.Cache;
import info.qazaq.qazaqinfo.data.entity.DataModel;
import info.qazaq.qazaqinfo.data.net.ServiceGenerator;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;


/**
 * Created by Nurlan. Email: nabievnurlan7@gmail.com on 19.11.2017.
 */

public class CloudDataStore implements DataStore
{
    private final Cache cache;


    CloudDataStore(Cache cache)
    {
        this.cache = cache;
    }

    @Override
    public Observable<List<DataModel>> news()
    {
        return ServiceGenerator.getService().getNews().doOnNext(new Consumer<List<DataModel>>()
        {
            @Override
            public void accept(final List<DataModel> newsEntities) throws Exception
            {
                cache.put(newsEntities);
            }
        });
    }
}
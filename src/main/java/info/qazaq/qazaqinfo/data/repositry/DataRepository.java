package info.qazaq.qazaqinfo.data.repositry;

import java.util.List;

import info.qazaq.qazaqinfo.data.entity.DataModel;
import info.qazaq.qazaqinfo.data.entity.mapper.Mapper;
import info.qazaq.qazaqinfo.data.repositry.datasource.DataStoreFactory;
import info.qazaq.qazaqinfo.domain.model.DomainModel;
import info.qazaq.qazaqinfo.domain.repository.Repository;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by Nurlan. Email: nabievnurlan7@gmail.com on 19.11.2017.
 */

public class DataRepository implements Repository
{
    private final DataStoreFactory dataStoreFactory;
    private final Mapper mapper;

    public DataRepository(DataStoreFactory dataStoreFactory, Mapper mapper)
    {
        this.dataStoreFactory = dataStoreFactory;
        this.mapper = mapper;
    }

    @Override
    public Observable<List<DomainModel>> news(String sDate, String sSection, String sSubjects)
    {
        return dataStoreFactory.create().news().map(new Function<List<DataModel>, List<DomainModel>>()
        {
            @Override
            public List<DomainModel> apply(List<DataModel> newsEntities) throws Exception
            {
                return mapper.transformList(newsEntities);
            }
        });
    }
}
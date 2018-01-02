package info.qazaq.qazaqinfo.data.cache;

import java.util.List;

import info.qazaq.qazaqinfo.data.entity.DataModel;
import io.reactivex.Observable;


/**
 * Created by Nurlan. Email: nabievnurlan7@gmail.com on 19.11.2017.
 */

public interface Cache
{
    boolean isExpired();
    boolean isCached();
    Observable<List<DataModel>> get();
    void put(List<DataModel> townshipEntities);
}

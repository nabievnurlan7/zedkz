package info.qazaq.qazaqinfo.data.repositry.datasource;

import java.util.List;

import info.qazaq.qazaqinfo.data.entity.DataModel;
import io.reactivex.Observable;


/**
 * Created by Nurlan. Email: nabievnurlan7@gmail.com on 19.11.2017.
 */

public interface DataStore
{
//    Observable<List<DataModel>> news(String sDate, String sSection, String sSubjects);
        Observable<List<DataModel>> news();
}

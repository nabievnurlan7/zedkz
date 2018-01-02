package info.qazaq.qazaqinfo.data.net;

import java.util.List;

import info.qazaq.qazaqinfo.data.entity.DataModel;
import io.reactivex.Observable;

import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Nurlan. Email: nabievnurlan7@gmail.com on 19.11.2017.
 */

public interface Service
{
//    @GET("soc/news")
//    Observable<List<DataModel>> getNews(@Query("section") String sSection,
//                                        @Query("news_date_from") String sDate,
//                                        @Query("subjects") String sSubjects);

    @GET("v2/5a488f243000004c15c3c57e")
    Observable<List<DataModel>> getNews();
}

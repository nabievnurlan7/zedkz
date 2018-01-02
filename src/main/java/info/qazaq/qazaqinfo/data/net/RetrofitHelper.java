package info.qazaq.qazaqinfo.data.net;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Nurlan. Email: nabievnurlan7@gmail.com on 19.11.2017.
 */

public class RetrofitHelper
{
    private static Retrofit retrofit;

    public static Retrofit getRetrofit()
    {
        if (retrofit != null)
        {
            return retrofit;
        }

        retrofit = new Retrofit.Builder()
                .baseUrl("http://www.mocky.io/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
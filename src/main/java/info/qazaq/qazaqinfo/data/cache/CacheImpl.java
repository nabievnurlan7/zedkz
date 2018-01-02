package info.qazaq.qazaqinfo.data.cache;

import android.content.Context;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import info.qazaq.qazaqinfo.data.entity.DataModel;
import io.reactivex.Observable;
import io.realm.Realm;



/**
 * Created by Nurlan. Email: nabievnurlan7@gmail.com on 19.11.2017.
 */

public class CacheImpl implements Cache
{
    private static final long EXPIRATION_TIME = 60 * 10 * 1000;
    private Context mContext;

    public CacheImpl(Context context)
    {
        this.mContext = context;
    }

    @Override
    public boolean isExpired()
    {
        Realm realm = Realm.getDefaultInstance();

        if (realm.where(DataModel.class).count() != 0)
        {
            Date currentTime = new Date(System.currentTimeMillis());
            SimpleDateFormat ISO8601DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.ENGLISH);
            Date lastUpdated = null;

//            try {
//                lastUpdated = ISO8601DATEFORMAT.parse(realm.where(DataModel.class).findFirst().getLastUpdated());
                boolean isExpired = currentTime.getTime() - lastUpdated.getTime() > EXPIRATION_TIME;
                if(isExpired)
                {
                    realm.beginTransaction();
                    realm.delete(DataModel.class);
                    realm.commitTransaction();
                    realm.close();
                }
                return isExpired;
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }

        }
        return false;
    }

    @Override
    public boolean isCached()
    {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(DataModel.class).findAll() != null && realm.where(DataModel.class).findAll().size() > 0;
    }

    @Override
    public Observable<List<DataModel>> get()
    {
        List<DataModel> townshipEntities = Realm.getDefaultInstance().where(DataModel.class).findAll();
        return Observable.just(townshipEntities);
    }

    @Override
    public void put(List<DataModel> newsEntities)
    {
        Realm.init(mContext);
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(newsEntities);
        realm.commitTransaction();
        realm.close();
    }
}
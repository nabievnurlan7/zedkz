package info.qazaq.qazaqinfo.domain.repository;

import java.util.List;

import info.qazaq.qazaqinfo.domain.model.DomainModel;
import io.reactivex.Observable;


/**
 * Created by Nurlan. Email: nabievnurlan7@gmail.com on 19.11.2017.
 */

public interface Repository
{
    Observable<List<DomainModel>> news(String sDate, String sSection, String sSubjects);
}

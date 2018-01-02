package info.qazaq.qazaqinfo.domain.interactor;

import java.util.List;

import info.qazaq.qazaqinfo.domain.model.DomainModel;
import info.qazaq.qazaqinfo.domain.repository.Repository;
import io.reactivex.Observable;

/**
 * Created by Nurlan. Email: nabievnurlan7@gmail.com on 19.11.2017.
 */

public class GetNewsList extends UseCase<List<DomainModel>,Void>
{
    private final Repository repository;
    String sDate;
    String sSection;
    String sSubjects;

    public GetNewsList(Repository repository)
    {
        this.repository = repository;
    }

    public void setParams(String date, String section, String subjects)
    {
        this.sDate = date;
        this.sSection = section;
        this.sSubjects = subjects;
    }

    @Override
    Observable<List<DomainModel>> buildUseCaseObservable(Void unused)
    {
        return repository.news(sDate, sSection, sSubjects);
    }
}
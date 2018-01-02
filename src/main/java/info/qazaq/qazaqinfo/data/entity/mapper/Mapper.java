package info.qazaq.qazaqinfo.data.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import info.qazaq.qazaqinfo.data.entity.DataModel;
import info.qazaq.qazaqinfo.domain.model.DomainModel;


/**
 * Created by Nurlan. Email: nabievnurlan7@gmail.com on 19.11.2017.
 */

public class Mapper
{
    public Mapper() {}

    public DomainModel transform(DataModel dataModel)
    {
        DomainModel domainModel = null;
        if(dataModel != null)
        {
            domainModel = new DomainModel(
                    dataModel.getId(),
                    dataModel.getFirst_name(),
                    dataModel.getLast_name(),
                    dataModel.getEmail(),
                    dataModel.getPhoto(),
                    dataModel.getGender(),
                    dataModel.getIp_address());
        }
        return domainModel;
    }

    public List<DomainModel> transformList(List<DataModel> townshipEntities)
    {
        List<DomainModel> domainModels = new ArrayList<>();
        for(DataModel dataModel : townshipEntities)
        {
            if(dataModel !=null)
            {
                domainModels.add(transform(dataModel));
            }
        }
        return domainModels;
    }
}
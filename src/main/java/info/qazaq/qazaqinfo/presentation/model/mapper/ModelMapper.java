package info.qazaq.qazaqinfo.presentation.model.mapper;

import java.util.ArrayList;
import java.util.List;

import info.qazaq.qazaqinfo.domain.model.DomainModel;
import info.qazaq.qazaqinfo.presentation.model.PresentationModel;


/**
 * Created by Nurlan. Email: nabievnurlan7@gmail.com on 19.11.2017.
 */

public class ModelMapper
{
    public ModelMapper() {}

    public PresentationModel transform(DomainModel domainModel)
    {
        PresentationModel presentationModel = null;
        if (domainModel !=null)
        {
           presentationModel = new PresentationModel(
                   domainModel.getId(),
                   domainModel.getFirst_name(),
                   domainModel.getLast_name(),
                   domainModel.getEmail(),
                   domainModel.getPhoto(),
                   domainModel.getGender(),
                   domainModel.getIp_address()
           );
        }

        return presentationModel;
    }

    public List<PresentationModel> transformList(List<DomainModel> domainModels)
    {
        List<PresentationModel> presentationModels = new ArrayList<>();

        for(DomainModel domainModel : domainModels)
        {
            if(domainModel !=null)
            {
                presentationModels.add(transform(domainModel));
            }
        }

        return presentationModels;
    }
}
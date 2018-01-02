package info.qazaq.qazaqinfo.presentation.view;

import java.util.List;

import info.qazaq.qazaqinfo.presentation.model.PresentationModel;


/**
 * Created by Nurlan. Email: nabievnurlan7@gmail.com on 19.11.2017.
 */

public interface NewsView extends LoadDataView
{
    void renderNewsList(List<PresentationModel> presentationModels);
}

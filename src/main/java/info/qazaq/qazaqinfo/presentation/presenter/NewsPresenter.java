package info.qazaq.qazaqinfo.presentation.presenter;


import java.util.List;

import info.qazaq.qazaqinfo.domain.interactor.DefaultObserver;
import info.qazaq.qazaqinfo.domain.interactor.GetNewsList;
import info.qazaq.qazaqinfo.domain.model.DomainModel;
import info.qazaq.qazaqinfo.presentation.model.PresentationModel;
import info.qazaq.qazaqinfo.presentation.model.mapper.ModelMapper;
import info.qazaq.qazaqinfo.presentation.view.NewsView;

/**
 * Created by Nurlan. Email: nabievnurlan7@gmail.com on 19.11.2017.
 */

public class NewsPresenter implements Presenter
{
    private NewsView newsView;
    private final GetNewsList getNewsList;
    private final ModelMapper modelMapper;

    public NewsPresenter(GetNewsList getNewsList, ModelMapper modelMapper)
    {
        this.getNewsList = getNewsList;
        this.modelMapper = modelMapper;
    }

    public void setNewsView(NewsView newsView)
    {
        this.newsView = newsView;
    }

    @Override
    public void resume() {}

    @Override
    public void pause() {}

    @Override
    public void destroy()
    {
        this.getNewsList.dispose();
        this.newsView = null;
    }

    public void initialize()
    {
        this.loadNewsList();
        this.getNewsList.setParams("05.06.2017","10","1");
    }

    private void loadNewsList()
    {
        this.showViewLoading();
        this.getNewsList();
    }

    private void showViewLoading()
    {
        this.newsView.showLoading();
    }

    private void hideViewLoading()
    {
        this.newsView.hideLoading();
    }

    private void showErrorMessage(String errorMessage)
    {
        this.newsView.showError(errorMessage);
    }

    private void showNewsListInView(List<DomainModel> domainModels)
    {
        final List<PresentationModel> newsList =
                this.modelMapper.transformList(domainModels);
        this.newsView.renderNewsList(newsList);
    }

    private void getNewsList()
    {
        this.getNewsList.execute(new NewsListObserver(), null);
    }

    private final class NewsListObserver extends DefaultObserver<List<DomainModel>>
    {
        @Override
        public void onComplete()
        {
            NewsPresenter.this.hideViewLoading();
        }

        @Override
        public void onError(Throwable e)
        {
            e.printStackTrace();
            NewsPresenter.this.hideViewLoading();
            NewsPresenter.this.showErrorMessage(e.getLocalizedMessage());
        }

        @Override
        public void onNext(List<DomainModel> domainModels)
        {
            NewsPresenter.this.showNewsListInView(domainModels);
        }
    }
}
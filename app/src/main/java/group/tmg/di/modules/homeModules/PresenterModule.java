package group.tmg.di.modules.homeModules;

import dagger.Module;
import dagger.Provides;
import group.tmg.di.scopes.PresenterScope;
import group.tmg.interactor.ArtistsInteractor;
import group.tmg.interactor.ContractorInteractor;
import group.tmg.interactor.TagInteractor;
import group.tmg.interactor.TransactionInteractor;
import group.tmg.presenter.HomePresenter;

@Module
public class PresenterModule {

    @Provides
    @PresenterScope
    public HomePresenter provideHomePresenter(TransactionInteractor transactionInteractor, TagInteractor tagInteractor
            , ArtistsInteractor artistsInteractor, ContractorInteractor contractorInteractor) {
        return new HomePresenter(transactionInteractor, tagInteractor, artistsInteractor, contractorInteractor);
    }
}

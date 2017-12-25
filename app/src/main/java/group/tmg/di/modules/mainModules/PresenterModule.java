package group.tmg.di.modules.mainModules;

import dagger.Module;
import dagger.Provides;
import group.tmg.di.scopes.PresenterScope;
import group.tmg.interactor.ArtistsInteractor;
import group.tmg.presenter.MainPresenter;

@Module
public class PresenterModule {

    @Provides
    @PresenterScope
    public MainPresenter provideMainPresenter(ArtistsInteractor artistsInteractor) {
        return new MainPresenter(artistsInteractor);
    }
}

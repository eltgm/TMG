package group.tmg.presenter;

import java.util.List;

import group.tmg.R;
import group.tmg.data.model.Tag;
import group.tmg.data.repository.tags.TagsDataSource;
import group.tmg.interactor.ArtistsInteractor;
import group.tmg.view.MainView;

public class MainPresenter extends BasePresenter<MainView> {

    private final ArtistsInteractor artistsInteractor;

    public MainPresenter(ArtistsInteractor artistsInteractor) {
        this.artistsInteractor = artistsInteractor;
    }

    @Override
    void onViewAttach() {
        super.onViewAttach();

        artistsInteractor.getArtists(new TagsDataSource.MainCallback() {
            @Override
            public void onLoadCompleted(List<Tag> artists) {
                getView().initMenu(artists);
            }

            @Override
            public void onLoadError(String error) {
                getView().showError(error);
            }
        });
    }

    @Override
    void onDestroy() {
        super.onDestroy();
    }

    public void onNavigationItemSelected(int id) {
        switch (id) {
            case R.id.general:
                getView().showHome();
                break;
        }
    }
}

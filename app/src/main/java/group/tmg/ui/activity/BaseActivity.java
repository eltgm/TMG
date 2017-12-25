package group.tmg.ui.activity;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import group.tmg.presenter.BasePresenter;
import group.tmg.ui.fragment.PresenterHolderFragment;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    private static final String TAG_PRESENTER_HOLDER = "tag_presenter_holder";

    @SuppressWarnings("unchecked")
    P instantiatePresenter() {
        final FragmentManager fm = getSupportFragmentManager();
        PresenterHolderFragment<P> holderFragment =
                (PresenterHolderFragment<P>)
                        fm.findFragmentByTag(TAG_PRESENTER_HOLDER);
        if (holderFragment == null) {
            holderFragment = PresenterHolderFragment.<P>newInstance();
            holderFragment.setPresenter(providePresenter());
            fm.beginTransaction().add(holderFragment, TAG_PRESENTER_HOLDER).commit();
        }
        return holderFragment.getPresenter();
    }

    protected abstract P providePresenter();
}

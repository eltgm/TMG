package group.tmg.ui.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import group.tmg.presenter.BasePresenter;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment {
    private static final String TAG_PRESENTER_HOLDER = "tag_frag_presenter_holder";

    @SuppressWarnings("unchecked")
    P instantiatePresenter() {
        final FragmentManager fm = getFragmentManager();
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
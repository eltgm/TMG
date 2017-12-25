package group.tmg.ui.fragment;


import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;

import group.tmg.presenter.BasePresenter;

public abstract class BaseDialogFragment<P extends BasePresenter> extends DialogFragment {
    private static final String TAG_PRESENTER_HOLDER = "tag_dial_presenter_holder";

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
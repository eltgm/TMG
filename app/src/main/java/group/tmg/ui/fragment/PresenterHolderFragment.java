package group.tmg.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

public class PresenterHolderFragment<P> extends android.support.v4.app.Fragment {
    private P presenter;

    public static <P> PresenterHolderFragment newInstance() {
        PresenterHolderFragment<P> fragment = new PresenterHolderFragment<>();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public P getPresenter() {
        return presenter;
    }

    public void setPresenter(P presenter) {
        this.presenter = presenter;
    }
}

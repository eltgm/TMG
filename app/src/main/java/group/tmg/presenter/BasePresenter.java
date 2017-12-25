package group.tmg.presenter;


public class BasePresenter<V> {
    private V view;

    public void attachView(V view) {
        this.view = view;
        onViewAttach();
    }

    public void detachView() {
        this.view = null;
    }

    V getView() {
        return view;
    }

    void onViewAttach() {
    }

    void onDestroy() {
    }
}

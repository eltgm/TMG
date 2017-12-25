package group.tmg.di.modules.transactionModules;

import dagger.Module;
import dagger.Provides;
import group.tmg.di.scopes.PresenterScope;
import group.tmg.interactor.TransactionInteractor;
import group.tmg.presenter.TransactionDialogPresenter;

@Module
public class PresenterModule {

    @Provides
    @PresenterScope
    public TransactionDialogPresenter provideTransactionDialogPresenter(TransactionInteractor interactor) {
        return new TransactionDialogPresenter(interactor);
    }
}

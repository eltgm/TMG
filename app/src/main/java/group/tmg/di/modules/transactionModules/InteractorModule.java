package group.tmg.di.modules.transactionModules;


import dagger.Module;
import dagger.Provides;
import group.tmg.data.repository.transactions.TransactionRepository;
import group.tmg.di.scopes.InteractorScope;
import group.tmg.interactor.TransactionInteractor;

@Module
public class InteractorModule {
    @Provides
    @InteractorScope
    public TransactionInteractor provideTransactionInteractor(TransactionRepository repository) {
        return new TransactionInteractor(repository);
    }
}

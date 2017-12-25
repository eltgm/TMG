package group.tmg.di.modules.transactionModules;

import dagger.Module;
import dagger.Provides;
import group.tmg.data.repository.transactions.TransactionLocalDataSource;
import group.tmg.data.repository.transactions.TransactionRemoteDataSource;
import group.tmg.data.repository.transactions.TransactionRepository;
import group.tmg.di.scopes.RepositoryScope;

@Module
public class RepositoryModule {

    @Provides
    @RepositoryScope
    public TransactionRepository provideTransactionRepository(TransactionRemoteDataSource transactionRemoteDataSource, TransactionLocalDataSource transactionLocalDataSource) {
        return new TransactionRepository(transactionLocalDataSource, transactionRemoteDataSource);
    }
}

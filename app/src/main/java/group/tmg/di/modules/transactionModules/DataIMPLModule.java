package group.tmg.di.modules.transactionModules;

import com.octo.android.robospice.SpiceManager;

import dagger.Module;
import dagger.Provides;
import group.tmg.data.repository.transactions.TransactionLocalDataSource;
import group.tmg.data.repository.transactions.TransactionRemoteDataSource;
import group.tmg.di.scopes.DataIMPLScope;

@Module
public class DataIMPLModule {
    @Provides
    @DataIMPLScope
    public TransactionRemoteDataSource provideTransactionRemoteDataSource(SpiceManager spiceManager) {
        return new TransactionRemoteDataSource(spiceManager);
    }


    @Provides
    @DataIMPLScope
    public TransactionLocalDataSource provideTransactionLocalDataSource() {
        return new TransactionLocalDataSource();
        //TODO суда передать для бд
    }
}

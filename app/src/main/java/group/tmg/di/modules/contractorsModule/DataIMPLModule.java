package group.tmg.di.modules.contractorsModule;

import com.octo.android.robospice.SpiceManager;

import dagger.Module;
import dagger.Provides;
import group.tmg.data.repository.contractors.ContractorLocalDataSource;
import group.tmg.data.repository.contractors.ContractorRemoteDataSource;
import group.tmg.di.scopes.DataIMPLScope;

@Module
public class DataIMPLModule {
    @Provides
    @DataIMPLScope
    public ContractorRemoteDataSource provideContractorRemoteDataSource(SpiceManager spiceManager) {
        return new ContractorRemoteDataSource(spiceManager);
    }


    @Provides
    @DataIMPLScope
    public ContractorLocalDataSource provideContractorLocalDataSource() {
        return new ContractorLocalDataSource();
        //TODO суда передать для бд
    }
}

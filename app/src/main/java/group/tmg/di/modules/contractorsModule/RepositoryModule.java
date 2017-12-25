package group.tmg.di.modules.contractorsModule;

import dagger.Module;
import dagger.Provides;
import group.tmg.data.repository.contractors.ContractorLocalDataSource;
import group.tmg.data.repository.contractors.ContractorRemoteDataSource;
import group.tmg.data.repository.contractors.ContractorRepository;
import group.tmg.di.scopes.RepositoryScope;

@Module
public class RepositoryModule {

    @Provides
    @RepositoryScope
    public ContractorRepository provideContractorRepository(ContractorRemoteDataSource contractorRemoteDataSource, ContractorLocalDataSource contractorLocalDataSource) {
        return new ContractorRepository(contractorRemoteDataSource, contractorLocalDataSource);
    }
}

package group.tmg.di.modules.contractorsModule;

import dagger.Module;
import dagger.Provides;
import group.tmg.data.repository.contractors.ContractorRepository;
import group.tmg.di.scopes.InteractorScope;
import group.tmg.interactor.ContractorInteractor;

@Module
public class InteractorModule {

    @Provides
    @InteractorScope
    public ContractorInteractor provideContractorInteractor(ContractorRepository contractorRepository) {
        return new ContractorInteractor(contractorRepository);
    }
}

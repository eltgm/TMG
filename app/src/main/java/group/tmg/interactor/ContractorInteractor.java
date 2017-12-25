package group.tmg.interactor;

import group.tmg.data.repository.contractors.ContractorDataSource;
import group.tmg.data.repository.contractors.ContractorRepository;

public class ContractorInteractor {
    private final ContractorRepository contractorRepository;

    public ContractorInteractor(ContractorRepository contractorRepository) {
        this.contractorRepository = contractorRepository;
    }

    public void getContractors(final ContractorDataSource.ContractorsCallback callback) {
        contractorRepository.getContractors(callback);
    }

    public void unsubscribe() {
        contractorRepository.unsubscribe();
    }
}

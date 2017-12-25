package group.tmg.data.repository.contractors;


import java.util.List;

import group.tmg.data.model.Contractor;

public class ContractorLocalDataSource implements ContractorDataSource {
    @Override
    public void saveContractors(List<Contractor> contractors) {

    }

    @Override
    public void getContractors(ContractorsCallback callback) {

    }

    @Override
    public void unsubscribe() {
        throw new UnsupportedOperationException("Может быть вызвано только из удаленного хранилища");
    }
}

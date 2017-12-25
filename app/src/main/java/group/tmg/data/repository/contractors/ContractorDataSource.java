package group.tmg.data.repository.contractors;

import java.util.List;

import group.tmg.data.model.Contractor;

public interface ContractorDataSource {
    void saveContractors(List<Contractor> contractors);

    void getContractors(ContractorsCallback callback);

    void unsubscribe();

    interface ContractorsCallback {
        void onLoadCompleted(List<Contractor> contractors);

        void onLoadError(String error);
    }
}

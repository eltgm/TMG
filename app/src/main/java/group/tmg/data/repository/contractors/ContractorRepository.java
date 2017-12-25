package group.tmg.data.repository.contractors;

import java.util.ArrayList;
import java.util.List;

import group.tmg.data.model.Contractor;

import static group.tmg.tools.ConnectivityReceiver.NETWORK_STATE;

public class ContractorRepository {
    private final ContractorDataSource contractorRemoteDataSource;
    private final ContractorDataSource contractorLocalDataSource;

    public ContractorRepository(ContractorDataSource contractorRemoteDataSource, ContractorDataSource contractorLocalDataSource) {
        this.contractorRemoteDataSource = contractorRemoteDataSource;
        this.contractorLocalDataSource = contractorLocalDataSource;
    }

    public void getContractors(final ContractorDataSource.ContractorsCallback callback) {
        Contractor contractor = new Contractor();
        Contractor contractor1 = new Contractor();
        Contractor contractor2 = new Contractor();
        List<Contractor> contractors = new ArrayList<>();

        contractor.setName("Махов А.С.");
        contractor1.setName("Пупкин Г.Э.");
        contractor2.setName("Залупа Е.Б.");
        contractors.add(contractor);
        contractors.add(contractor1);
        contractors.add(contractor2);

        callback.onLoadCompleted(contractors);
        if (NETWORK_STATE)
            contractorRemoteDataSource.getContractors(new ContractorDataSource.ContractorsCallback() {
                @Override
                public void onLoadCompleted(List<Contractor> contractors) {
                    callback.onLoadCompleted(contractors);
                }

                @Override
                public void onLoadError(String error) {
                    callback.onLoadError(error);
                }
            });
        else
            contractorLocalDataSource.getContractors(new ContractorDataSource.ContractorsCallback() {
                @Override
                public void onLoadCompleted(List<Contractor> contractors) {
                    callback.onLoadCompleted(contractors);
                }

                @Override
                public void onLoadError(String error) {
                    callback.onLoadError(error);
                }
            });
    }

    public void unsubscribe() {
        contractorRemoteDataSource.unsubscribe();
    }
}

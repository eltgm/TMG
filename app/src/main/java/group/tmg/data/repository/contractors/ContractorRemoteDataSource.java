package group.tmg.data.repository.contractors;

import com.octo.android.robospice.SpiceManager;

import java.util.List;

import group.tmg.data.model.Contractor;

public class ContractorRemoteDataSource implements ContractorDataSource {
    private final SpiceManager spiceManager;

    public ContractorRemoteDataSource(SpiceManager spiceManager) {
        this.spiceManager = spiceManager;
    }

    @Override
    public void saveContractors(List<Contractor> contractors) {
        throw new UnsupportedOperationException("Может быть вызвано только из локального хранилища");
    }

    @Override
    public void getContractors(ContractorsCallback callback) {

    }

    @Override
    public void unsubscribe() {
        spiceManager.shouldStop();
    }
}

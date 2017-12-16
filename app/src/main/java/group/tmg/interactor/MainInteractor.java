package group.tmg.interactor;

import group.tmg.data.repository.main.MainDataSource;
import group.tmg.data.repository.main.MainRepository;

public class MainInteractor {

    private MainRepository mainRepository;

    public MainInteractor(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    public void getUser(MainDataSource.MainCallback callback){
        mainRepository.getUser(callback);
    }
}

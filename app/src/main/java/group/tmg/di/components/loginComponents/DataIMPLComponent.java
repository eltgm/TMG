package group.tmg.di.components.loginComponents;

import dagger.Component;
import group.tmg.data.repository.contractors.ContractorLocalDataSource;
import group.tmg.data.repository.contractors.ContractorRemoteDataSource;
import group.tmg.data.repository.login.LoginRemoteDataSource;
import group.tmg.data.repository.tags.TagsLocalDataSource;
import group.tmg.data.repository.tags.TagsRemoteDataSource;
import group.tmg.data.repository.transactions.TransactionLocalDataSource;
import group.tmg.data.repository.transactions.TransactionRemoteDataSource;
import group.tmg.data.storage.StorageImpl;
import group.tmg.di.modules.loginModules.DataIMPLModule;
import group.tmg.di.scopes.DataIMPLScope;

@Component(dependencies = DataComponent.class, modules = {DataIMPLModule.class, group.tmg.di.modules.tagModules.DataIMPLModule.class,
        group.tmg.di.modules.transactionModules.DataIMPLModule.class,
        group.tmg.di.modules.contractorsModule.DataIMPLModule.class})
@DataIMPLScope
public interface DataIMPLComponent {

    LoginRemoteDataSource loginDataSource();

    StorageImpl loginStorage();

    TagsRemoteDataSource tagsRemoteDataSource();

    TagsLocalDataSource tagsLocalDataSource();

    TransactionRemoteDataSource transactionsRemoteDataSource();

    TransactionLocalDataSource transactionLocalDataSource();

    ContractorRemoteDataSource contractorRemoteDataSoure();

    ContractorLocalDataSource contractorLocalDataSource();
}

package group.tmg.di.components.loginComponents;

import dagger.Component;
import group.tmg.data.repository.contractors.ContractorRepository;
import group.tmg.data.repository.login.LoginRepository;
import group.tmg.data.repository.tags.TagsRepository;
import group.tmg.data.repository.transactions.TransactionRepository;
import group.tmg.di.modules.loginModules.RepositoryModule;
import group.tmg.di.scopes.RepositoryScope;

@Component(dependencies = DataIMPLComponent.class, modules = {RepositoryModule.class,
        group.tmg.di.modules.tagModules.RepositoryModule.class, group.tmg.di.modules.transactionModules.RepositoryModule.class,
        group.tmg.di.modules.contractorsModule.RepositoryModule.class})
@RepositoryScope
public interface RepositoryComponent {
    LoginRepository loginRepository();

    TagsRepository tagsRepository();

    TransactionRepository transactionsRepository();

    ContractorRepository contractorsRepository();
}

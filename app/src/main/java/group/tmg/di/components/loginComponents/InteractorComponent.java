package group.tmg.di.components.loginComponents;

import dagger.Component;
import group.tmg.di.modules.loginModules.InteractorModule;
import group.tmg.di.scopes.InteractorScope;
import group.tmg.interactor.ArtistsInteractor;
import group.tmg.interactor.ContractorInteractor;
import group.tmg.interactor.LoginInteractor;
import group.tmg.interactor.TagInteractor;
import group.tmg.interactor.TransactionInteractor;

@Component(dependencies = RepositoryComponent.class, modules = {InteractorModule.class,
        group.tmg.di.modules.artistsModules.InteractorModule.class, group.tmg.di.modules.tagModules.InteractorModule.class,
        group.tmg.di.modules.transactionModules.InteractorModule.class, group.tmg.di.modules.contractorsModule.InteractorModule.class})
@InteractorScope
public interface InteractorComponent {
    LoginInteractor loginInteractor();

    ArtistsInteractor artistsInteractor();

    TagInteractor tagInteractor();

    TransactionInteractor transactionInteractor();

    ContractorInteractor contractorInteractor();
}

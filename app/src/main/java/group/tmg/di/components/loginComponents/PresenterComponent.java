package group.tmg.di.components.loginComponents;

import dagger.Component;
import group.tmg.di.modules.loginModules.PresenterModule;
import group.tmg.di.scopes.PresenterScope;
import group.tmg.ui.activity.LoginActivity;
import group.tmg.ui.activity.MainActivity;
import group.tmg.ui.fragment.HomeFragment;
import group.tmg.ui.fragment.TransactionDialog;

@Component(dependencies = InteractorComponent.class, modules = {PresenterModule.class,
        group.tmg.di.modules.mainModules.PresenterModule.class, group.tmg.di.modules.homeModules.PresenterModule.class,
        group.tmg.di.modules.transactionModules.PresenterModule.class})
@PresenterScope
public interface PresenterComponent {

    void inject(LoginActivity loginActivity);

    void inject(MainActivity mainActivity);

    void inject(HomeFragment homeFragment);

    void inject(TransactionDialog transactionDialog);
}

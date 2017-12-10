package group.tmg.di.components.loginComponents;

import dagger.Component;
import group.tmg.di.modules.loginModules.PresenterModule;
import group.tmg.di.scopes.PresenterScope;
import group.tmg.ui.activity.LoginActivity;

@Component(dependencies = InteractorComponent.class, modules = {PresenterModule.class})
@PresenterScope
public interface PresenterComponent {

    void inject(LoginActivity loginActivity);
}

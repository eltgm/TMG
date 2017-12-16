package group.tmg;

import android.app.Application;

import group.tmg.di.components.loginComponents.DaggerDataComponent;
import group.tmg.di.components.loginComponents.DaggerDataIMPLComponent;
import group.tmg.di.components.loginComponents.DaggerInteractorComponent;
import group.tmg.di.components.loginComponents.DaggerPresenterComponent;
import group.tmg.di.components.loginComponents.DaggerRepositoryComponent;
import group.tmg.di.components.loginComponents.DataComponent;
import group.tmg.di.components.loginComponents.DataIMPLComponent;
import group.tmg.di.components.loginComponents.InteractorComponent;
import group.tmg.di.components.loginComponents.PresenterComponent;
import group.tmg.di.components.loginComponents.RepositoryComponent;


public class App extends Application{

    public final static String USER_REQUEST_TAG = "user";

    private static ContextComponent appComponent;
    public static ContextComponent getAppComponent() {
        return appComponent;
    }

    private static DataComponent dataComponent;
    public static DataComponent getDataComponent(){ return dataComponent;}

    private static DataIMPLComponent dataIMPLComponent;
    public static DataIMPLComponent getDataIMPLComponent(){ return dataIMPLComponent;}

    private static RepositoryComponent repositoryComponent;
    public static RepositoryComponent getRepositoryComponent(){ return repositoryComponent;}

    private static InteractorComponent interactorComponent;
    public static InteractorComponent getInteractorComponent(){ return interactorComponent;}

    private static PresenterComponent presenterComponent;
    public static PresenterComponent getPresenterComponent(){ return presenterComponent;}

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerContextComponent.builder()
                .contextModule(new ContextModule(this))
                .build();

        dataComponent = DaggerDataComponent.builder()
                .contextComponent(appComponent)
                .build();

        dataIMPLComponent = DaggerDataIMPLComponent.builder()
                .dataComponent(dataComponent)
                .build();

        repositoryComponent = DaggerRepositoryComponent.builder()
                .dataIMPLComponent(dataIMPLComponent)
                .build();

        interactorComponent = DaggerInteractorComponent.builder()
                .repositoryComponent(repositoryComponent)
                .build();

        presenterComponent = DaggerPresenterComponent.builder()
                .interactorComponent(interactorComponent)
                .build();
    }

}

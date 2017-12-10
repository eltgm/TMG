package group.tmg;


import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ContextModule.class})
public interface ContextComponent {
    Context provideContext();
}

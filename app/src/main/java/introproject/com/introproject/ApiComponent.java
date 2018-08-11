package introproject.com.introproject;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by HP on 8/11/2018.
 */

@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface ApiComponent {
    void inject(MainActivity activity);
}
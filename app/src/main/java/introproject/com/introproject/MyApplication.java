package introproject.com.introproject;

import android.app.Application;

/**
 * Created by HP on 8/11/2018.
 */

public class MyApplication extends Application {

    public ApiComponent mApiComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApiComponent = DaggerApiComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule("https://simplifiedcoding.net/demos/"))
                .build();
    }

    public ApiComponent getNetComponent() {
        return mApiComponent;
    }
}

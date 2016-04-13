package ssu.gamertaggo;

import android.app.Application;
import com.parse.*;


/** THIS ACTIVITY FILE CONTAINS CODE THAT GETS THE PARSE SERVER ID, PARSE APP ID, AND
    CLIENT KEY
 */

public class InitializeActivity extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("wrYHgB3u7Lp0iTyhKFz3y9duaYISRhx64HeP7keb")
                .clientKey("JLcpeLrkbW01nXUfmC8Hx6ESqNVmpryKHDKlipym")
                .server("https://parseapi.back4app.com").build());

    }
}

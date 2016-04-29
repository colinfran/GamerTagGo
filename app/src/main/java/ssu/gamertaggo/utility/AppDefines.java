package ssu.gamertaggo.utility;

import android.app.Application;
import com.parse.*;


/** THIS ACTIVITY FILE CONTAINS CODE THAT GETS THE PARSE SERVER ID, PARSE APP ID, AND
    CLIENT KEY
 */

public class AppDefines extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(getString(ssu.gamertaggo.R.string.appID))
                .clientKey(getString(ssu.gamertaggo.R.string.clientID))
                .server(getString(ssu.gamertaggo.R.string.serverID)).build());

    }
}

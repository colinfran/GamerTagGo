package ssu.gamertaggo.service;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

import ssu.gamertaggo.adapter.Message;


/** THIS ACTIVITY FILE CONTAINS CODE THAT GETS THE PARSE SERVER ID, PARSE APP ID, AND
    CLIENT KEY
 */

public class ParseService extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ParseObject.registerSubclass(Message.class);
        Parse.enableLocalDatastore(this);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(getString(ssu.gamertaggo.R.string.appID))
                .clientKey(getString(ssu.gamertaggo.R.string.clientID))
                .server(getString(ssu.gamertaggo.R.string.serverID)).build());

    }

}

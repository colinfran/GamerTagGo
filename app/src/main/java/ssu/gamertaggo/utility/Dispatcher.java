package ssu.gamertaggo.utility;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.parse.*;

import ssu.gamertaggo.viewcontroller.activity.*;



/**
 * Activity which starts an intent for either the logged in (MainActivity) or logged out
 * (SignUpOrLoginActivity) activity.
 */

public class Dispatcher extends Activity {
    Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        // Check if there is current user info
        if (ParseUser.getCurrentUser() != null) {
            // Start an intent for the logged in activity
            intent = (new Intent(this, MainActivity.class));
        } else {
            // Start and intent for the logged out activity
            intent = (new Intent(this, SignUpOrLoginActivity.class));
        }
        startActivity(intent);
        this.finish();
    }
}


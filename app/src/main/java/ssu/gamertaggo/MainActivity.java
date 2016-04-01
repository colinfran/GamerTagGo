package ssu.gamertaggo;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import com.parse.*;


/**
 * Created by colinfranceschini on 3/24/16.
 */

// THIS MAIN ACTIVITY FILE CONTAINS CODE THAT ...

public class MainActivity extends Activity {

    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logout=(Button)findViewById(R.id.logoutbutton);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logOut();
                back_to_sign_up_or_login();
            }
        });
        ParseUser cuser=ParseUser.getCurrentUser();
        if (cuser==null)
        {
            back_to_sign_up_or_login();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            ParseUser.getCurrentUser().logOut();
            startActivity(new Intent(MainActivity.this, DispatchActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    void back_to_sign_up_or_login(){
        Intent intent=new Intent(MainActivity.this,SignUpOrLoginActivity.class);
        startActivity(intent);
    }
}

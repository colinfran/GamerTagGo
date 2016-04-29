package ssu.gamertaggo.viewcontroller.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ssu.gamertaggo.R;


public class AboutCreatorsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_creators);

        ((Button) findViewById(R.id.back_button1)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Starts an intent of the log in activity
                startActivity(new Intent(AboutCreatorsActivity.this, SignUpOrLoginActivity.class));
            }
        });
    }
}

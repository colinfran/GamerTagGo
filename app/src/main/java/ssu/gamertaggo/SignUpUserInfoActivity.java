package ssu.gamertaggo;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SignUpCallback;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.parse.*;
public class SignUpUserInfoActivity extends Activity {

        private EditText favgameView;
        private EditText favgenreView;
        private EditText consoleView;

        @Override
        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_signup);

            // Set up the signup form.

            favgameView = (EditText) findViewById(R.id.firstname);
            favgenreView = (EditText) findViewById(R.id.lastname);
            consoleView = (EditText) findViewById(R.id.email);


            // Set up the submit button click handler
            findViewById(R.id.sign_up_action_button).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {

                    // Validate the sign up data
                    boolean validationError = false;
                    StringBuilder validationErrorMessage =
                            new StringBuilder(getResources().getString(R.string.error_intro));

                    if (isEmpty(favgameView)) {
                        validationError = true;
                        validationErrorMessage.append(getResources().getString(R.string.error_blank_game));
                    }

                    if (isEmpty(favgenreView)) {
                        validationError = true;
                        validationErrorMessage.append(getResources().getString(R.string.error_blank_genre));
                    }

                    if (isEmpty(consoleView)) {
                        validationError = true;
                        validationErrorMessage.append(getResources().getString(R.string.error_blank_console));
                    }

                    validationErrorMessage.append(getResources().getString(R.string.error_end));

                    // If there is a validation error, display the error
                    if (validationError) {
                        Toast.makeText(SignUpUserInfoActivity.this, validationErrorMessage.toString(), Toast.LENGTH_LONG)
                                .show();
                        return;
                    }

                    // Set up a progress dialog
                    final ProgressDialog dlg = new ProgressDialog(SignUpUserInfoActivity.this);
                    dlg.setTitle("Please wait.");
                    dlg.setMessage("Signing up.  Please wait.");
                    dlg.show();

                    // Set up a new Parse user
                    ParseObject.registerSubclass(GamerProParseUser.class);
                    GamerProParseUser user = ParseObject.create(GamerProParseUser.class);
                    user.setfavgame(favgameView.getText().toString());
                    user.setfavgenre(favgenreView.getText().toString());
                    user.setconsole(consoleView.getText().toString());
                }
            });
        }

        private boolean isEmpty(EditText etText) {
            if (etText.getText().toString().trim().length() > 0) {
                return false;
            } else {
                return true;
            }
        }

        private boolean isMatching(EditText etText1, EditText etText2) {
            if (etText1.getText().toString().equals(etText2.getText().toString())) {
                return true;
            } else {
                return false;
            }
        }
}

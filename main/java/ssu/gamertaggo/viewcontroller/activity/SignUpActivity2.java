package ssu.gamertaggo.viewcontroller.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.*;

import ssu.gamertaggo.adapter.AppParseUser;
import ssu.gamertaggo.utility.Dispatcher;
import ssu.gamertaggo.R;


/**
 * Created by student on 5/2/16.
 */

// THIS CONTAINS CODE TO SAVE VALUES FOR FAVORITE GAME AND FAVORITE GENRE

public class SignUpActivity2 extends Activity {

    private EditText favGameView;
    private EditText favGenreView;
    private EditText consoleView;

    private CheckBox chkg1, chkg2, chkg3, chkg4, chkg5, chkg6, chkg7,
            chkc1, chkc2, chkc3, chkc4, chkc5;
    Button buttonAdd;
    LinearLayout mLayout;
    LinearLayout injectionLayout;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);

        // Set up the signup form.

        favGameView = (EditText) findViewById(R.id.favGame);
        mLayout = (LinearLayout) findViewById(R.id.linearLayout);
        injectionLayout = (LinearLayout) findViewById(R.id.injectionLayout);
        buttonAdd = (Button) findViewById(R.id.add);
        buttonAdd.setOnClickListener(onClick());
        TextView textView = new TextView(this);
        textView.setText("test");



        chkg1 = (CheckBox) findViewById(R.id.action);
        chkg2 = (CheckBox) findViewById(R.id.shoot);
        chkg3 = (CheckBox) findViewById(R.id.strat);
        chkg4 = (CheckBox) findViewById(R.id.rpg);
        chkg5 = (CheckBox) findViewById(R.id.fight);
        chkg6 = (CheckBox) findViewById(R.id.sport);
        chkg7 = (CheckBox) findViewById(R.id.mmo);

        chkc1 = (CheckBox) findViewById(R.id.pc);
        chkc2 = (CheckBox) findViewById(R.id.ps4);
        chkc3 = (CheckBox) findViewById(R.id.xbone);
        chkc4 = (CheckBox) findViewById(R.id.wii);
        chkc5 = (CheckBox) findViewById(R.id.other);



        findViewById(R.id.sign_up_action_button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                // Validate the sign up data
                boolean validationError = false;
                StringBuilder validationErrorMessage =
                        new StringBuilder(getResources().getString(R.string.error_intro));

                if (isEmpty(favGameView)) {
                    validationError = true;
                    validationErrorMessage.append(getResources().getString(R.string.error_blank_favgame));
                }

                if (!chkg1.isChecked() && !chkg2.isChecked() && !chkg3.isChecked() && !chkg4.isChecked()
                        && !chkg5.isChecked() && !chkg6.isChecked() && !chkg7.isChecked()) {
                    validationError = true;
                    validationErrorMessage.append(getResources().getString(R.string.error_blank_favgenre));
                }

                if (!chkc1.isChecked() && !chkc2.isChecked() && !chkc3.isChecked() && !chkc4.isChecked()
                        && !chkc5.isChecked()) {
                    validationError = true;
                    validationErrorMessage.append(getResources().getString(R.string.error_blank_console));
                }


                if (validationError == true)

                {
                    Toast.makeText(SignUpActivity2.this, validationErrorMessage.toString(), Toast.LENGTH_LONG)
                            .show();
                    return;
                }

                // Set up a progress dialog
                final ProgressDialog dlg = new ProgressDialog(SignUpActivity2.this);
                dlg.setTitle("Please wait.");
                dlg.setMessage("Signing up.  Please wait.");
                dlg.show();

                // Set up a new Parse user
                // Parse every element in the array to the games list

                ParseUser user = ParseUser.getCurrentUser();



                if(chkg1.isChecked()) {
                    ParseObject genre = new ParseObject("Genre");
                    genre.put("fav_genres", "Action Adventure");
                    genre.put("userID", ParseUser.getCurrentUser());
                    genre.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            setResult(RESULT_OK);
                            finish();
                        }
                    });
                }
                if(chkg2.isChecked()) {
                    ParseObject genre = new ParseObject("Genre");
                    genre.put("fav_genres", "Shooter");
                    genre.put("userID", ParseUser.getCurrentUser());
                    genre.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            setResult(RESULT_OK);
                            finish();
                        }
                    });
                }
                if(chkg3.isChecked()) {
                    ParseObject genre = new ParseObject("Genre");
                    genre.put("fav_genres", "Strategy");
                    genre.put("userID", ParseUser.getCurrentUser());
                    genre.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            setResult(RESULT_OK);
                            finish();
                        }
                    });
                }
                if(chkg4.isChecked()) {
                    ParseObject genre = new ParseObject("Genre");
                    genre.put("fav_genres", "RPG");
                    genre.put("userID", ParseUser.getCurrentUser());
                    genre.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            setResult(RESULT_OK);
                            finish();
                        }
                    });
                }
                if(chkg5.isChecked()) {
                    ParseObject genre = new ParseObject("Genre");
                    genre.put("fav_genres", "Fighting");
                    genre.put("userID", ParseUser.getCurrentUser());
                    genre.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            setResult(RESULT_OK);
                            finish();
                        }
                    });
                }
                if(chkg6.isChecked()) {
                    ParseObject genre = new ParseObject("Genre");
                    genre.put("fav_genres", "Sports");
                    genre.put("userID", ParseUser.getCurrentUser());
                    genre.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            setResult(RESULT_OK);
                            finish();
                        }
                    });
                }
                if(chkg7.isChecked()) {
                    ParseObject genre = new ParseObject("Genre");
                    genre.put("fav_genres", "MMO");
                    genre.put("userID", ParseUser.getCurrentUser());
                    genre.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            setResult(RESULT_OK);
                            finish();
                        }
                    });
                }


                if(chkc1.isChecked()) {
                    ParseObject console = new ParseObject("Console");
                    console.put("fav_consoles", "PC");
                    console.put("userID", ParseUser.getCurrentUser());
                    console.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            setResult(RESULT_OK);
                            finish();
                        }
                    });
                }
                if(chkc2.isChecked()) {
                    ParseObject console = new ParseObject("Console");
                    console.put("fav_consoles", "Playstation 4");
                    console.put("userID", ParseUser.getCurrentUser());
                    console.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            setResult(RESULT_OK);
                            finish();
                        }
                    });
                }
                if(chkc3.isChecked()) {
                    ParseObject console = new ParseObject("Console");
                    console.put("fav_consoles", "XBox One");
                    console.put("userID", ParseUser.getCurrentUser());
                    console.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            setResult(RESULT_OK);
                            finish();
                        }
                    });
                }
                if(chkc4.isChecked()) {
                    ParseObject console = new ParseObject("Console");
                    console.put("fav_consoles", "Wii U");
                    console.put("userID", ParseUser.getCurrentUser());
                    console.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            setResult(RESULT_OK);
                            finish();
                        }
                    });
                }
                if(chkc5.isChecked()) {
                    ParseObject console = new ParseObject("Console");
                    console.put("fav_consoles", "Other");
                    console.put("userID", ParseUser.getCurrentUser());
                    console.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            setResult(RESULT_OK);
                            finish();
                        }
                    });
                }

                ParseUser.getCurrentUser().signUpInBackground(new SignUpCallback() {

                    @Override
                    public void done(ParseException e) {
                        dlg.dismiss();
                        //if (e != null) {
                        // Show the error message
                        //    Toast.makeText(SignUpActivity2.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        //} else {
                        // Start an intent for the dispatch activit
                        Intent intent = new Intent(SignUpActivity2.this, Dispatcher.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        //}
                    }
                });
            }

        });


        findViewById(R.id.skip_button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                final ProgressDialog dlg = new ProgressDialog(SignUpActivity2.this);
                dlg.setTitle("Please wait.");
                dlg.setMessage("Signing up.  Please wait.");
                dlg.show();
                AppParseUser user = ParseObject.create(AppParseUser.class);

                user.signUpInBackground(new SignUpCallback() {

                    @Override
                    public void done(ParseException e) {
                        dlg.dismiss();
                        //if (e != null) {
                        // Show the error message
                        //    Toast.makeText(SignUpActivity2.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        //} else {
                        // Start an intent for the dispatch activity
                        Intent intent = new Intent(SignUpActivity2.this, Dispatcher.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        //}
                    }
                });
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

    private View.OnClickListener onClick() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                ParseObject game = new ParseObject("Game");
                game.put("fav_games", favGameView.getText().toString());
                game.put("userID", ParseUser.getCurrentUser());
                game.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        setResult(RESULT_OK);
                    }
                });
                injectionLayout.addView(createNewTextView(favGameView.getText().toString()));
            }
        };
    }

    //PUT THE EDITTEXTS INTO AN ARRAY LIST

    private TextView createNewTextView(String text) {
        final LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        final TextView textView = new TextView(this);
        textView.setText(text);
        textView.setLayoutParams(lparams);
        return textView;
    }

}

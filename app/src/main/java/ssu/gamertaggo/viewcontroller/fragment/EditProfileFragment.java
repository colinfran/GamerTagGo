package ssu.gamertaggo.viewcontroller.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.parse.ParseClassName;
import android.widget.Toast;
import android.widget.Button;
import ssu.gamertaggo.service.AppParseUser;

import android.content.DialogInterface;
import com.parse.*;
import android.content.Context;

import ssu.gamertaggo.*;

public class EditProfileFragment extends Fragment {

    private EditText usernameEditText;
    private EditText firstnameEditText;
    private EditText lastnameEditText;
    private EditText emailEditText;
    private Button saveButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View v=inflater.inflate(R.layout.fragment_edit_profile, container, false);

        //EDIT TEXTS
        usernameEditText = (EditText) v.findViewById (R.id.editusername);
        firstnameEditText = (EditText) v.findViewById (R.id.editfirstname);
        lastnameEditText = (EditText) v.findViewById (R.id.editlastname);
        emailEditText = (EditText) v.findViewById (R.id.editemail);

        //SAVE BUTTON
        saveButton = (Button) v.findViewById(R.id.save_user_info_button);


        ///set OnClickListener to check if the user clicked the SAVE BUTTON
        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View view) {
                final Context context = getActivity();
                ParseUser user = ParseUser.getCurrentUser();
                user.put("username", usernameEditText.getText().toString());
                user.put("first_name", firstnameEditText.getText().toString());
                user.put("last_name", lastnameEditText.getText().toString());
                user.put("username", usernameEditText.getText().toString());
                user.put("Email",emailEditText.getText().toString());

                user.saveInBackground(new SaveCallback() {
                    public void done(ParseException e) {
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                                context);

                        // set title
                        alertDialogBuilder.setTitle("User information has been updated");

                        // set dialog message
                        alertDialogBuilder
                                .setMessage("Click OK to exit!")
                                .setCancelable(false)
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        // if this button is clicked, close
                                        // current activity
                                        dialog.cancel();
                                    }
                                });


                        // create alert dialog
                        AlertDialog alertDialog = alertDialogBuilder.create();

                        // show it
                        alertDialog.show();
                    }
                });

            }
        });

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        // Set up the profile page based on the current user.
        ParseUser user = ParseUser.getCurrentUser();
        showProfile(user);
    }

    /**
     * Shows the edit-profile of the user.
     *
     * @param user
     */
    public void showProfile(ParseUser user) {
        if (user != null) {
            String userName = user.getString("username");
            if (userName != null) {
                usernameEditText.setText(userName);
            }
            String firstName = user.getString("first_name");
            if (firstName != null) {
                firstnameEditText.setText(firstName);
            }
            String lastName = user.getString("last_name");
            if (lastName != null) {
                lastnameEditText.setText(lastName);
            }
            String userEmail = user.getString("email");
            if (userEmail != null) {
                emailEditText.setText(userEmail);
            }
        }




    }





}



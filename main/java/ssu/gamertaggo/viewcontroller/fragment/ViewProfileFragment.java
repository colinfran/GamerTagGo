package ssu.gamertaggo.viewcontroller.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.parse.ParseUser;


import ssu.gamertaggo.R;

public class ViewProfileFragment extends Fragment {

    private TextView usernameTextView;
    private TextView firstnameTextView;
    private TextView lastnameTextView;
    private TextView emailTextView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_view_profile, container, false);

        usernameTextView = (TextView) v.findViewById (R.id.textViewUsername);
        firstnameTextView = (TextView) v.findViewById (R.id.textViewFirst);
        lastnameTextView = (TextView) v.findViewById (R.id.textViewLast);
        emailTextView = (TextView) v.findViewById (R.id.textViewEmail);


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
     * Shows the profile of the given user.
     *
     * @param user
     */
    public void showProfile(ParseUser user) {
        if (user != null) {
            String userName = user.getString("username");
            if (userName != null) {
                usernameTextView.setText(userName);}
            String firstName = user.getString("first_name");
            if (firstName != null) {
                firstnameTextView.setText(firstName);}
            String lastName = user.getString("last_name");
            if (lastName != null) {
                lastnameTextView.setText(lastName);}
            String userEmail = user.getString("email");
            if (userEmail != null) {
                emailTextView.setText(userEmail);}
        }
    }
}




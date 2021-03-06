package ssu.gamertaggo.viewcontroller.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

import ssu.gamertaggo.R;

public class ViewProfileFragment extends Fragment {

    private TextView usernameTextView;
    private TextView firstnameTextView;
    private TextView lastnameTextView;
    private TextView emailTextView;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_view_profile, container, false);

        usernameTextView = (TextView) v.findViewById(R.id.textViewUsername);
        firstnameTextView = (TextView) v.findViewById(R.id.textViewFirst);
        lastnameTextView = (TextView) v.findViewById(R.id.textViewLast);
        emailTextView = (TextView) v.findViewById(R.id.textViewEmail);
        final Spinner games = (Spinner) v.findViewById(R.id.spinner);
        final Spinner genres = (Spinner) v.findViewById(R.id.spinner3);
        final Spinner consoles = (Spinner) v.findViewById(R.id.spinner4);



        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Game");
        query.whereEqualTo("userID", ParseUser.getCurrentUser());
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if (e == null) {
                    ArrayList<String> gameList = new ArrayList<>();
                    for (ParseObject object : list) {
                        gameList.add(object.getString("fav_games"));
                    }
                    ArrayAdapter adapter1 = new ArrayAdapter(
                            getActivity().getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, gameList);
                    games.setAdapter(adapter1);
                } else {

                }
            }
        });

        ParseQuery<ParseObject> query2 = new ParseQuery<ParseObject>("Genre");
        query2.whereEqualTo("userID", ParseUser.getCurrentUser());
        query2.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if (e == null) {
                    ArrayList<String> genreList = new ArrayList<>();
                    for (ParseObject object : list) {
                        genreList.add(object.getString("fav_genres"));
                    }
                    ArrayAdapter adapter2 = new ArrayAdapter(
                            getActivity().getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, genreList);
                    genres.setAdapter(adapter2);
                } else {

                }
            }
        });

        ParseQuery<ParseObject> query3 = new ParseQuery<ParseObject>("Console");
        query3.whereEqualTo("userID", ParseUser.getCurrentUser());
        query3.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if (e == null) {
                    ArrayList<String> consoleList = new ArrayList<>();
                    for (ParseObject object : list) {
                        consoleList.add(object.getString("fav_consoles"));
                    }
                    ArrayAdapter adapter3 = new ArrayAdapter(
                            getActivity().getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, consoleList);
                    consoles.setAdapter(adapter3);
                } else {

                }
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




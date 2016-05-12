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
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

import ssu.gamertaggo.R;

/**
 * Created by colinfranceschini on 5/11/16.
 */
public class SearchUserProfileFragment extends Fragment {

    private TextView usernameTextView;
    private TextView firstnameTextView;
    private TextView lastnameTextView;
    private TextView emailTextView;




    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_view_user_profile, container, false);

        usernameTextView = (TextView) v.findViewById(R.id.textViewUsername);
        firstnameTextView = (TextView) v.findViewById(R.id.textViewFirst);
        lastnameTextView = (TextView) v.findViewById(R.id.textViewLast);
        emailTextView = (TextView) v.findViewById(R.id.textViewEmail);


        return v;


    }

    @Override
    public void onStart() {
        super.onStart();
        // Set up the profile page based on the current user.
        List<ParseUser> users = null;
        final Spinner games = (Spinner) getView().findViewById(R.id.spinnerUser1);
        final Spinner genres = (Spinner)getView().findViewById(R.id.spinnerUser2);
        final Spinner consoles = (Spinner) getView().findViewById(R.id.spinnerUser3);


        Bundle bundle = getArguments();
        String user_id = bundle.getString("UserProfile");


        ParseQuery<ParseObject> query4 = ParseQuery.getQuery("_User");
        query4.getInBackground(user_id, new GetCallback<ParseObject>() {
            public void done(ParseObject object, ParseException e) {
                if (e == null) {
                    String userName = object.getString("username");
                    usernameTextView.setText(userName);
                    String first_name = object.getString("first_name");
                    firstnameTextView.setText(first_name);
                    String email = object.getString("email");
                    emailTextView.setText(email);

                } else {
                    // something went wrong
                }
            }
        });

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Game");
        query.whereEqualTo("userID", user_id);
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

        ParseQuery<ParseObject> query2 = ParseQuery.getQuery("Genre");
        query2.whereEqualTo("userID", user_id);
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

        ParseQuery<ParseObject> query3 = ParseQuery.getQuery("Console");
        query3.whereEqualTo("userID", user_id);
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

    }
}
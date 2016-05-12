package ssu.gamertaggo.viewcontroller.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

import ssu.gamertaggo.R;

public class UsersFragment extends Fragment {

    ArrayAdapter namesArrayAdapter;
    ArrayList names;
    String currentUserId;
    ListView usersListView;
    Intent serviceIntent;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View v=inflater.inflate(R.layout.fragment_users, container, false);

        currentUserId = ParseUser.getCurrentUser().getObjectId();
        names = new ArrayList<String>();
        ParseQuery<ParseUser> query = ParseUser.getQuery();
        //don't include yourself
        query.whereNotEqualTo("objectId", currentUserId);
        query.findInBackground(new FindCallback<ParseUser>() {
            public void done(List<ParseUser> userList, com.parse.ParseException e) {
                if (e == null) {
                    for (int i = 0; i < userList.size(); i++) {
                        names.add(userList.get(i).getUsername().toString());
                    }
                    usersListView = (ListView) v.findViewById(R.id.usersListView);
                    namesArrayAdapter =
                            new ArrayAdapter<String>(getActivity().getApplicationContext(),
                                    R.layout.user_list_item, names);
                    usersListView.setAdapter(namesArrayAdapter);
                    usersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> a, View v, int i, long l) {
                            openConversation(names, i);


                        }

                    });
                } else {
                    Toast.makeText(getActivity().getApplicationContext(),
                            "Error loading user list",
                            Toast.LENGTH_LONG).show();
                }

            }

        });
        return v;
    }


    public void openConversation(ArrayList<String> names, int pos) {
        ParseQuery<ParseUser> query = ParseUser.getQuery();
        query.whereEqualTo("username", names.get(pos));

        query.findInBackground(new FindCallback<ParseUser>() {
            public void done(List<ParseUser> user, ParseException e) {
                if (e == null) {
                    //Put the value
                    MessagingFragment ldf = new MessagingFragment ();
                    Bundle args = new Bundle();
                    args.putSerializable("RECIPIENT_ID", user.get(0).getObjectId());
                    ldf.setArguments(args);

                    //Inflate the fragment
                    getFragmentManager().beginTransaction().add(R.id.content_frame, ldf).commit();

                } else {
                    Toast.makeText(getActivity().getApplicationContext(),
                            "Error finding that user",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}

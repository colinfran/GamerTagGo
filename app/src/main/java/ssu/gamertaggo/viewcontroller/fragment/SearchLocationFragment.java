package ssu.gamertaggo.viewcontroller.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

import ssu.gamertaggo.R;


public class SearchLocationFragment extends Fragment {

    ArrayAdapter namesArrayAdapter;
    ArrayList names;
    String name_view;
    String currentUserId;
    ListView usersListView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_location_search, container, false);

        currentUserId = ParseUser.getCurrentUser().getObjectId();
        names = new ArrayList<String>();
        ParseQuery<ParseUser> query = ParseUser.getQuery();
        query.whereWithinMiles("Location", ParseUser.getCurrentUser().getParseGeoPoint("Location"), 20);
        query.whereNotEqualTo("objectId", currentUserId);

        query.findInBackground(new FindCallback<ParseUser>() {
            public void done(final List<ParseUser> userList, com.parse.ParseException e) {
                if (e == null) {
                    for (int i = 0; i < userList.size(); i++) {
                        names.add(userList.get(i).getUsername().toString());
                    }
                    usersListView = (ListView) v.findViewById(R.id.listViewLocation);
                    namesArrayAdapter =
                            new ArrayAdapter<String>(getActivity().getApplicationContext(),
                                    R.layout.user_list_item, names);
                    usersListView.setAdapter(namesArrayAdapter);

                    usersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            name_view = (userList.get((int) id).getObjectId());
                            SearchUserProfileFragment send = new SearchUserProfileFragment();
                            Bundle bundle = new Bundle();
                            bundle.putString("UserProfile", name_view);
                            send.setArguments(bundle);
                            FragmentManager location = getFragmentManager();
                            location.beginTransaction().replace(R.id.content_frame, send).commit();

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
}
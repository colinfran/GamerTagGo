package ssu.gamertaggo.viewcontroller.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.*;
import android.view.MenuInflater;
import android.view.ViewGroup;
import android.app.Fragment;
import android.widget.Adapter;
import android.widget.ListView;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView.AdapterContextMenuInfo;



import ssu.gamertaggo.R;

/**
 * Created by colinfranceschini on 4/20/16.
 */
public class SearchFragment extends Fragment {
    ListView lv;
    Adapter AdapterContextMenuInfo;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search, container, false);

        lv = (ListView) v.findViewById(R.id.listView);
        registerForContextMenu(lv);

        return v;
    }
        @Override
        public void onCreateContextMenu (ContextMenu menu, View v, ContextMenuInfo menuInfo){
            super.onCreateContextMenu(menu, v, menuInfo);
            if (v.getId() == R.id.listView) {
                MenuInflater inflater = getActivity().getMenuInflater();
                inflater.inflate(R.menu.menu_message_user, menu);
            }

        }



        @Override
        public boolean onContextItemSelected(MenuItem item) {
            AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
            switch(item.getItemId()) {
                case R.id.message:
                    // add stuff here
                    return true;
                default:
                    return super.onContextItemSelected(item);
            }
        }

    }





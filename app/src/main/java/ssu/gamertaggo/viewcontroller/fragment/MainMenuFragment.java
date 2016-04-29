package ssu.gamertaggo.viewcontroller.fragment;

import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.Adapter;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.parse.ParseUser;

import ssu.gamertaggo.R;
import ssu.gamertaggo.listener.CustomOnItemSelectedListener;
import ssu.gamertaggo.viewcontroller.activity.LoginActivity;

public class MainMenuFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main_menu, container, false);

        String  [] genres =
                {        "Genres", "Action", "Adventure", "Arcade", "Combat", "Defense", "Fist Person Shooter", "Puzzle", "Sports", "Strategy", "Third Person Shooter"
                };
        String  [] console =
                {        "Consoles", "PS3", "PS4", "XBOX 360", "XBOX ONE", "Steam"
                };

        ArrayAdapter<String> Gadapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, genres);
        ArrayAdapter<String> Cadapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, console);


        Spinner spinner1 = (Spinner) v.findViewById(R.id.spinner1);
        Spinner spinner2 = (Spinner) v.findViewById(R.id.spinner2);

        Gadapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        Cadapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner1.setAdapter(Gadapter);
        spinner2.setAdapter(Cadapter);

        Button locationbutton = (Button) v.findViewById(R.id.locationbutton);

        locationbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager location = getFragmentManager();
                location.beginTransaction().replace(R.id.content_frame, new SearchFragment()).commit();
            }
        });

        Button gamesearchbutton = (Button) v.findViewById(R.id.search_game_button);
        gamesearchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager location = getFragmentManager();
                location.beginTransaction().replace(R.id.content_frame, new SearchFragment()).commit();
            }
        });

        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view,
                                       int position, long row_id) {
                switch (position) {
                    case 1:
                        FragmentManager fm1 = getFragmentManager();
                        fm1.beginTransaction().replace(R.id.content_frame, new SearchFragment()).commit();
                        break;
                    case 2:
                        FragmentManager fm2 = getFragmentManager();
                        fm2.beginTransaction().replace(R.id.content_frame, new SearchFragment()).commit();
                        break;
                    case 3:
                        FragmentManager fm3 = getFragmentManager();
                        fm3.beginTransaction().replace(R.id.content_frame, new SearchFragment()).commit();
                        break;
                    case 4:
                        FragmentManager fm4 = getFragmentManager();
                        fm4.beginTransaction().replace(R.id.content_frame, new SearchFragment()).commit();
                        break;
                    case 5:
                        FragmentManager fm5 = getFragmentManager();
                        fm5.beginTransaction().replace(R.id.content_frame, new SearchFragment()).commit();
                        break;
                    case 6:
                        FragmentManager fm6 = getFragmentManager();
                        fm6.beginTransaction().replace(R.id.content_frame, new SearchFragment()).commit();
                        break;
                    case 7:
                        FragmentManager fm7 = getFragmentManager();
                        fm7.beginTransaction().replace(R.id.content_frame, new SearchFragment()).commit();
                        break;
                    case 8:
                        FragmentManager fm8 = getFragmentManager();
                        fm8.beginTransaction().replace(R.id.content_frame, new SearchFragment()).commit();
                        break;
                    case 9:
                        FragmentManager fm9 = getFragmentManager();
                        fm9.beginTransaction().replace(R.id.content_frame, new SearchFragment()).commit();
                        break;
                    case 10:
                        FragmentManager fm10 = getFragmentManager();
                        fm10.beginTransaction().replace(R.id.content_frame, new SearchFragment()).commit();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinner2.setOnItemSelectedListener(new CustomOnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view,
                                       int position, long row_id) {
                switch (position) {
                    case 1:
                        FragmentManager fm1 = getFragmentManager();
                        fm1.beginTransaction().replace(R.id.content_frame, new SearchFragment()).commit();
                        break;
                    case 2:
                        FragmentManager fm2 = getFragmentManager();
                        fm2.beginTransaction().replace(R.id.content_frame, new SearchFragment()).commit();
                        break;
                    case 3:
                        FragmentManager fm3 = getFragmentManager();
                        fm3.beginTransaction().replace(R.id.content_frame, new SearchFragment()).commit();
                        break;
                    case 4:
                        FragmentManager fm4 = getFragmentManager();
                        fm4.beginTransaction().replace(R.id.content_frame, new SearchFragment()).commit();
                        break;
                    case 5:
                        FragmentManager fm5 = getFragmentManager();
                        fm5.beginTransaction().replace(R.id.content_frame, new SearchFragment()).commit();
                        break;
                    case 6:
                        FragmentManager fm6 = getFragmentManager();
                        fm6.beginTransaction().replace(R.id.content_frame, new SearchFragment()).commit();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        return v;

    }
}

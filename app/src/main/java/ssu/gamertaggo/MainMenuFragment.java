package ssu.gamertaggo;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

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

        Spinner spinner1 = (Spinner) v.findViewById(R.id.spinner1);
        Spinner spinner2 = (Spinner) v.findViewById(R.id.spinner2);

        ArrayAdapter<String> Gadapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, genres);
        ArrayAdapter<String> Cadapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, console);

        Gadapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        Cadapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner1.setAdapter(Gadapter);
        spinner2.setAdapter(Cadapter);
        return v;
    }
}

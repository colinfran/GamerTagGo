package ssu.gamertaggo;

import com.parse.ParseClassName;
import com.parse.ParseUser;

@ParseClassName("_User")
public class GamerProParseUser extends ParseUser {
    private static final String KEY_FIRST_NAME = "first_name";
    private static final String KEY_LAST_NAME = "last_name";
    private static final String KEY_FAV_GAME = "fav_game";
    private static final String KEY_FAV_GENRE = "fav_genre";
    private static final String KEY_CONSOLE = "console";


    public void setfirstName(String firstName) {
        put(KEY_FIRST_NAME, firstName);
    }
    public void setlastName(String lastName) {
        put(KEY_LAST_NAME, lastName);
    }
    public void setfavgenre(String favgenre) {
        put(KEY_FAV_GENRE, favgenre);
    }
    public void setfavgame(String favgame) {
        put(KEY_FAV_GAME, favgame);
    }
    public void setconsole(String console) {
        put(KEY_CONSOLE, console);
    }
}

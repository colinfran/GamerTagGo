package ssu.gamertaggo;

import com.parse.ParseClassName;
import com.parse.ParseUser;

/**
 * Created by colinfranceschini on 3/31/16.
 */
@ParseClassName("_User")
public class GamerProParseUser extends ParseUser {
    private static final String KEY_FIRST_NAME = "first_name";
    private static final String KEY_LAST_NAME = "last_name";

    public void setfirstName(String firstName) {
        put(KEY_FIRST_NAME, firstName);
    }
    public void setlastName(String lastName) {
        put(KEY_LAST_NAME, lastName);
    }
}

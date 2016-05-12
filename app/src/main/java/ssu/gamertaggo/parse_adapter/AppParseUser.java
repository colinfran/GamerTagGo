package ssu.gamertaggo.parse_adapter;

import com.parse.ParseClassName;
import com.parse.ParseUser;

@ParseClassName("_User")
public class AppParseUser extends ParseUser {
    private static final String KEY_FIRST_NAME = "first_name";
    private static final String KEY_LAST_NAME = "last_name";
    private static final String KEY_USERNAME = "username";



    public void setfirstName(String firstName){
        put(KEY_FIRST_NAME, firstName);
    }
    public void setlastName(String lastName){
        put(KEY_LAST_NAME, lastName);
    }
    public void setUsername(String username){ put (KEY_USERNAME, username);}
}

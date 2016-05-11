package ssu.gamertaggo.adapter;

import com.parse.ParseObject;
import com.parse.ParseClassName;

@ParseClassName("_System")
public class AppParseSystem extends ParseObject
{
    private static final String KEY_CONSOLE_NAME = "console_name";

    public void setConsoleName(String console_name) {
        put(KEY_CONSOLE_NAME, console_name);
    }
}

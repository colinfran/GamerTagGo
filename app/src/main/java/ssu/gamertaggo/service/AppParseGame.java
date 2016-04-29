package ssu.gamertaggo.service;

import com.parse.ParseObject;
import com.parse.ParseClassName;

@ParseClassName("_Game")
public class AppParseGame extends ParseObject
{
    private static final String KEY_GAME_TITLE = "game_title";

    public void setGameTitle(String game_title) {
        put(KEY_GAME_TITLE, game_title);
    }
}

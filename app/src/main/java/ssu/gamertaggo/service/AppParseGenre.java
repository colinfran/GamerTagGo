package ssu.gamertaggo.service;

import com.parse.ParseObject;
import com.parse.ParseClassName;

@ParseClassName("_Genre")
public class AppParseGenre extends ParseObject
{
    private static final String KEY_GENRE_TITLE = "genre_title";

    public void setGenreTitle(String genre_title) {
        put(KEY_GENRE_TITLE, genre_title);
    }
}

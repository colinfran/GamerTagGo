package ssu.gamertaggo.adapter;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by colinfranceschini on 5/4/16.
 */


@ParseClassName("Message")
public class Message extends ParseObject {
    public static final String USER_ID_KEY = "userId";
    public static final String BODY_KEY = "body";
    public static final String USER_TO_KEY = "userTo";

    public String getUserId() {
        return getString(USER_ID_KEY);
    }

    public String getBody() {
        return getString(BODY_KEY);
    }

    public String getUserTo() {
        return getString(USER_TO_KEY);
    }

    public void setUserTo(String userTo) {
        put(USER_TO_KEY, userTo);
       }

    public void setUserId(String userId) {
        put(USER_ID_KEY, userId);
    }

    public void setBody(String body) {
        put(BODY_KEY, body);
    }

}

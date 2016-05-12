package ssu.gamertaggo.viewcontroller.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.List;

import ssu.gamertaggo.R;
import ssu.gamertaggo.adapter.ChatListAdapter;
import ssu.gamertaggo.parse_adapter.AppParseMessage;

public class MessagingFragment extends Fragment {

    static final String USER_ID_KEY = "userId";
    static final String BODY_KEY = "body";
    static final String USER_TO_KEY = "userTo";
    static final int MAX_CHAT_MESSAGES_TO_SHOW = 50;


    EditText etMessage;
    Button btSend;
    ListView lvChat;
    ArrayList<AppParseMessage> mMessages;
    ChatListAdapter mAdapter;
    // Keep track of initial load to scroll to the bottom of the ListView
    boolean mFirstLoad;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mHandler.postDelayed(mRefreshMessagesRunnable, POLL_INTERVAL);

        final View v = inflater.inflate(R.layout.chat, container, false);

        //get recipientId from the intent
        etMessage = (EditText) v.findViewById(R.id.etMessage);
        btSend = (Button) v.findViewById(R.id.btSend);
        lvChat = (ListView) v.findViewById(R.id.lvChat);
        mMessages = new ArrayList<>();
        lvChat.setTranscriptMode(1);
        mFirstLoad = true;
        final String userId = ParseUser.getCurrentUser().getObjectId();
        final String userTo = getArguments().getString("RECIPIENT_ID");
        mAdapter = new ChatListAdapter(getActivity().getApplicationContext(), userId, mMessages);
        lvChat.setAdapter(mAdapter);

        //listen for a click on the send v.findViewById(btnSend);
        btSend.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String data = etMessage.getText().toString();
                if (data.isEmpty()) {
                    Toast.makeText(getActivity().getApplicationContext(), "Please enter a message", Toast.LENGTH_LONG).show();
                    return;
                }

                ParseACL acl = new ParseACL();
                acl.setWriteAccess(ParseUser.getCurrentUser(), true);
                acl.setWriteAccess(userTo, true);
                acl.setReadAccess(ParseUser.getCurrentUser(), true);
                acl.setReadAccess(userTo, true);


                ParseObject message = ParseObject.create("Message");
                message.setACL(acl);

                message.put(BODY_KEY, data);

                message.put(USER_ID_KEY, userId);

                message.put(USER_TO_KEY, userTo);


                message.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        Toast.makeText(getActivity().getApplicationContext(), "Message Sent!", Toast.LENGTH_LONG).show();
                        refreshMessages();
                    }
                });
                etMessage.setText(null);

            }
        });
        return v;
    }
    void refreshMessages() {
        // Construct query to execute
        ParseQuery<AppParseMessage> query = ParseQuery.getQuery(AppParseMessage.class);
        // Configure limit and sort order
        query.setLimit(MAX_CHAT_MESSAGES_TO_SHOW);
        query.orderByAscending("createdAt");

        query.findInBackground(new FindCallback<AppParseMessage>() {
            public void done(List<AppParseMessage> messages, ParseException e) {
                if (e == null) {
                    mMessages.clear();
                    mMessages.addAll(messages);
                    mAdapter.notifyDataSetChanged(); // update adapter
                    if (mFirstLoad) {
                        lvChat.setSelection(mAdapter.getCount() - 1);
                        mFirstLoad = false;
                    }
                } else {
                    Log.e("message", "Error Loading Messages" + e);
                }
            }
        });

    }
    static final int POLL_INTERVAL = 100; // milliseconds
    Handler mHandler = new Handler();  // android.os.Handler
    Runnable mRefreshMessagesRunnable = new Runnable() {
        @Override
        public void run() {
            refreshMessages();
            mHandler.postDelayed(this, POLL_INTERVAL);
        }
    };


}


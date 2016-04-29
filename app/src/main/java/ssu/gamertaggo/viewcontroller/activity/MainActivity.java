package ssu.gamertaggo.viewcontroller.activity;

import android.view.*;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.app.ProgressDialog;
import android.content.Intent;
import android.widget.TextView;

import com.parse.*;

import ssu.gamertaggo.viewcontroller.fragment.*;

import ssu.gamertaggo.R;



public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView usernameTextView;
    TextView emailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //TOOL BAR
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //DRAWER
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        //NAVIGATION VIEW
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View header = navigationView.getHeaderView(0);
        usernameTextView = (TextView) header.findViewById (R.id.textViewNavUsername);
        emailTextView = (TextView) header.findViewById (R.id.textViewNavEmail);


        // Here we  upload the main Fragment
        FragmentManager fm=getFragmentManager();
        fm.beginTransaction().replace(R.id.content_frame,new MainMenuFragment()).commit();

    }

    public void onStart() {
        super.onStart();
        // Set up the profile page based on the current user.
        ParseUser user = ParseUser.getCurrentUser();
        showProfile(user);
    }

    /**
     * Shows the profile of the given user.
     * @param user
     */
    public void showProfile(ParseUser user) {
        if (user != null) {
            String userName = user.getString("username");
            if (userName != null) {
                usernameTextView.setText(userName);}
            String userEmail = user.getString("email");
            if (userEmail != null) {
                emailTextView.setText(userEmail);}
        }
    }


    // Reaction to back button pressed
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    // Reaction to Navigation Bar item being selection
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_mainmenu) {
            FragmentManager fm=getFragmentManager();
            fm.beginTransaction().replace(R.id.content_frame,new MainMenuFragment()).commit();

        } else if (id == R.id.nav_view_profile) {
            FragmentManager fm=getFragmentManager();
            fm.beginTransaction().replace(R.id.content_frame,new ViewProfileFragment()).commit();
        } else if (id == R.id.nav_edit_profile) {
            FragmentManager fm=getFragmentManager();
            fm.beginTransaction().replace(R.id.content_frame,new EditProfileFragment()).commit();
        } else if (id == R.id.nav_message) {
            FragmentManager fm=getFragmentManager();
            fm.beginTransaction().replace(R.id.content_frame,new MessagesFragment()).commit();
        } else if (id == R.id.nav_settings) {
            FragmentManager fm=getFragmentManager();
            fm.beginTransaction().replace(R.id.content_frame,new SettingsFragment()).commit();
        } else if (id == R.id.nav_logout) {
            ParseUser.logOut();
            back_to_sign_up_or_login();

            // Set up a progress dialog
            final ProgressDialog dlg = new ProgressDialog(MainActivity.this);
            dlg.setTitle("Please wait.");
            dlg.setMessage("Logging out.  Please wait.");
            dlg.show();


            // Parse Current User check --> log out if CurrentUser=null
            ParseUser currentUser=ParseUser.getCurrentUser();
            if (currentUser==null)
            {
                back_to_sign_up_or_login();
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    void back_to_sign_up_or_login(){
        Intent intent=new Intent(MainActivity.this,SignUpOrLoginActivity.class);
        startActivity(intent);
    }

}


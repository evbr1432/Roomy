package com.example.hunter.roomy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity implements OnLoginSuccessListener {

    private static final int LOGIN_REQUEST = 0;

    private Fragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        if (ParseUser.getCurrentUser() != null) {
            profileFragment = ProfileFragment.newInstance(ParseUser.getCurrentUser().getUsername());
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, profileFragment, "ProfileFragment")
                    .show(profileFragment)
                    .commit();
        } else {
            profileFragment = ProfileFragment.newInstance("user");
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, profileFragment, "ProfileFragment")
                    .show(profileFragment)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_log_in_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.logout) {
            ParseUser.logOut();
            tryLogin();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ensureLogin();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == LOGIN_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                ensureLogin();
            } else {
                tryLogin();
            }
        }
    }

    private void ensureLogin() {
        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser == null) {
            tryLogin();
        }
    }

    private void tryLogin() {
        Fragment loginFragment = LoginFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, loginFragment, "LoginFragment")
                .hide(profileFragment)
                .show(loginFragment)
                .commit();
    }

    @Override
    public void onLoginSuccess() {
        profileFragment = ProfileFragment.newInstance(ParseUser.getCurrentUser().getUsername());
        getSupportFragmentManager().beginTransaction()
                .remove(getSupportFragmentManager().findFragmentByTag("LoginFragment"))
                .add(R.id.fragment_container, profileFragment, "ProfileFragment")
                .show(profileFragment)
                .commit();
    }
}

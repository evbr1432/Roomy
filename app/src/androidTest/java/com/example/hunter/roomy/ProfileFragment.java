package com.example.hunter.roomy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.parse.ParseUser;

/**
 * Created by elijahstaple on 11/12/15.
 * Main profile view
 */
public class ProfileFragment extends Fragment {

    private String username = "";

    public static ProfileFragment newInstance(String name) {
        ProfileFragment f = new ProfileFragment();
        f.username = name;
        return f;
    }
    /**
     * On creation of profile fragment, checks any saved instance states
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    /**
     * On profile view uses layout from xml, sets background color, and shows welcom message
     * with a succesful login.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.profile_fragment,
                parent, false);
        v.setBackgroundColor(getResources().getColor(android.R.color.background_light));

        TextView message = (TextView) v.findViewById(R.id.welcome_message);
        message.setText("Welcome " + username);

        return v;
    }

}

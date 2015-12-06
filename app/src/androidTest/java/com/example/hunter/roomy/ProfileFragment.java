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
 */
public class ProfileFragment extends Fragment {

    private String username = "";

    public static ProfileFragment newInstance(String name) {
        ProfileFragment f = new ProfileFragment();
        f.username = name;
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

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

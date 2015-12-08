package com.example.hunter.roomy;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

/**
 * Fragment for the user login screen. Creates new instance of login screen.
 */
public class LoginFragment extends Fragment {

  private OnLoginSuccessListener onLoginSuccessListener;

  private EditText username;
  private EditText password;
  private ParseUser user;
  /**
   * Creates new instance
   *
   */
  public static LoginFragment newInstance() {
    return new LoginFragment();
  }
  /**
   * Accesses last instance state so if user already logged in
   *
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }
  /**
   * Starts login activity and asks user to try again if failed. Also access sign up activity
   *
   */
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                           Bundle savedInstanceState) {

    View v = inflater.inflate(R.layout.activity_login,
        parent, false);
    v.setBackgroundColor(getResources().getColor(android.R.color.background_light));

    username = (EditText) v.findViewById(R.id.username);
    password = (EditText) v.findViewById(R.id.password);

    Button login = (Button) v.findViewById(R.id.login_button);
    login.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        try {
          ParseUser.logIn(username.getText().toString(), password.getText().toString());
          loginSuccess();
        } catch (ParseException e) {
          e.printStackTrace();
          new Toast(getActivity()).makeText(getActivity(), "Please try again", Toast.LENGTH_LONG);
        }
      }
    });

    Button signup = (Button) v.findViewById(R.id.signup_button);
    signup.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        user = new ParseUser();
        user.setPassword(password.getText().toString());
        user.setUsername(username.getText().toString());
        user.signUpInBackground(new SignUpCallback() {
          @Override
          public void done(ParseException e) {
            if (ParseUser.getCurrentUser() != null) {
              loginSuccess();
            } else {
              try {
                ParseUser.logIn(username.getText().toString(), password.getText().toString());
                loginSuccess();
              } catch (ParseException f) {
                f.printStackTrace();
                new Toast(getActivity()).makeText(getActivity(), "Please try again", Toast.LENGTH_LONG);
              }
            }
          }
        });
      }
    });

    return v;
  }

  @Override
  public void onAttach(Activity activity) {
    super.onAttach(activity);

    if (activity instanceof OnLoginSuccessListener) {
      onLoginSuccessListener = (OnLoginSuccessListener) activity;
    } else {
      throw new IllegalArgumentException(
          "Activity must implemement OnLoginSuccessListener");
    }
  }

  private void loginSuccess() {
    onLoginSuccessListener.onLoginSuccess();
  }

}

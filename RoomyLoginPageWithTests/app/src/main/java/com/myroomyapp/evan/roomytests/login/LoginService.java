package com.myroomyapp.evan.roomytests.login;

/**
 * Created by evan on 11/11/15.
 */
public class LoginService {
    public boolean login(String username, String password) {
        return "james".equals(username) && "bond".equals(password);
    }
}

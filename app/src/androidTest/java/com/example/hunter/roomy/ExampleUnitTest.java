package com.example.hunter.roomy;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.hunter.roomy.R;
import com.facebook.login.LoginManager;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 * THESE ARE MY TESTS THAT I USED FOR UNIT TESTING. I CAN'T GET THEM TO WORK
 * NOW BECAUSE I'M NOT SURE HOW PARSE WORKS. PLUS I WAS USING A MUCH MORE BASIC FRAMEWORK
 * WITH HARDCODED USERS.
 * Tests if the user enter a username and throws exception if there is nothing
 *
 * @param  presenter  old loginfragment
 * @param  service the hardcoded database before parse

@RunWith(MockitoJUnitRunner.class)
public class LoginFragmentTest {
    @Mock
    private com.example.hunter.roomy.LoginFragment view;
    @Mock

    private com.example.hunter.roomy.LoginFragment service;
    private LoginManager presenter;
    /**
     * Set up a new instance
     *

    @Before
    public void setUp() throws Exception {
        presenter = new LoginFragment(view, service);
    }
    /**
     * Tests if the user enter a username and password throws exception otherwise
     *

    @Test
    public void ShowMessage_UsernameIsEmpty() throws Exception {
        when(view.getUsername()).thenReturn("");
        presenter.onLoginClicked();

        verify(view).showUsernameError(R.string.username_error);
    }
    /**
     * Tests if the user enter a password throws exception otherwise
     *
    @Test
    public void ShowMessage_PasswordIsEmpty() throws Exception {
        when(view.getUsername()).thenReturn("");
        when(view.getPassword()).thenReturn("");
        presenter.onLoginClicked();

        verify(view).showPasswordError(R.string.password_error);
    }
    /**
     * Tests if the main activity is run after users enters a correct password
     * James bond was a hard coded user before parse
    @Test
    public void StartMainActivity_UsernameAndPasswordWorked() throws Exception {
        when(view.getUsername()).thenReturn("james");
        when(view.getPassword()).thenReturn("bond");
        when(service.login("james", "bond")).thenReturn(true);
        presenter.onLoginClicked();

        verify(view).startMainActivity();
    }
}
 */
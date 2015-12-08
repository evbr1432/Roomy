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
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
}

/** THESE ARE MY TESTS THAT I USED FOR UNIT TESTING. I CAN'T GET THEM TO WORK
 * NOW BECAUSE I'M NOT SURE HOW PARSE WORKS. PLUS I WAS USING A MUCH MORE BASIC FRAMEWORK
 * WITH HARDCODED USERS.

@RunWith(MockitoJUnitRunner.class)
public class LoginFragmentTest {
    @Mock
    private com.example.hunter.roomy.LoginFragment view;
    @Mock

    private com.example.hunter.roomy.LoginFragment service;
    private LoginManager presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new LoginFragment(view, service);
    }

    @Test
    public void ShowMessage_UsernameIsEmpty() throws Exception {
        when(view.getUsername()).thenReturn("");
        presenter.onLoginClicked();

        verify(view).showUsernameError(R.string.username_error);
    }

    @Test
    public void ShowMessage_PasswordIsEmpty() throws Exception {
        when(view.getUsername()).thenReturn("");
        when(view.getPassword()).thenReturn("");
        presenter.onLoginClicked();

        verify(view).showPasswordError(R.string.password_error);
    }

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
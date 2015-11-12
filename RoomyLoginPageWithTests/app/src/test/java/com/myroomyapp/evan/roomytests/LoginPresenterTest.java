package com.myroomyapp.evan.roomytests.login;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.myroomyapp.evan.roomytests.R;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by evan on 11/11/15.
 */

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {
    @Mock
    private LoginView view;
    @Mock
    private LoginService service;
    private LoginPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new LoginPresenter(view, service);
    }

    @Test
    public void ShowMessage_UsernameIsEmpty() throws Exception {
        when(view.getUsername()).thenReturn("");
        presenter.onLoginClicked();

        verify(view).showUsernameError(R.string.username_error);
    }

    @Test
    public void ShowMessage_PasswordIsEmpty() throws Exception {
        when(view.getUsername()).thenReturn("james");
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
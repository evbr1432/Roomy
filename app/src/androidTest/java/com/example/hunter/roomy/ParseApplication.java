package com.example.hunter.roomy;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;
/**
 * Initializes parse. Uses free key. uses facebook login.
 */
public class ParseApplication extends Application {

  public ParseUser user;
  /**
   * On create use api key, enables local data store and uses facebook login.
   */
  @Override
  public void onCreate() {
    super.onCreate();

    Parse.enableLocalDatastore(this);

    Parse.initialize(this, "CUPMscJteJMEONwzHQ8aNRNrMS66KN1oGH9L21nI",
            "bc18UrCvJ3vP9iPxFBrDrKH5F8QzsWvnINMydNHq");

    Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);

    ParseFacebookUtils.initialize(this);

    user = ParseUser.getCurrentUser();
  }
}

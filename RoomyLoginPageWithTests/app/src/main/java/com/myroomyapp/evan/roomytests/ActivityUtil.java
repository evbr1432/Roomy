package com.myroomyapp.evan.roomytests;

/**
 * Created by evan on 11/11/15.
 */
import android.content.Context;
import android.content.Intent;

import com.myroomyapp.evan.roomytests.main.MainActivity;

public class ActivityUtil {
    private Context context;

    public ActivityUtil(Context context) {
        this.context = context;
    }

    public void startMainActivity() {
        context.startActivity(new Intent(context, MainActivity.class));
    }
}


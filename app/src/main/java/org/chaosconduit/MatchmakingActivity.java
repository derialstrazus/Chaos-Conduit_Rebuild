package org.chaosconduit;

import android.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import com.firebase.client.Firebase;

/**
 * Created by Derial on 3/7/2015.
 */
public class MatchmakingActivity extends ActionBarActivity {

    Firebase firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_opponents);
        firebase = new Firebase(getResources().getString(R.string.firebase));
    }
}

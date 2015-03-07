package org.chaosconduit;

import android.support.v4.app.Fragment;
//import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class MainFragment extends Fragment implements View.OnClickListener{


    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_old);
        Button A = (Button) findViewById(R.id.button);
        Button B = (Button) findViewById(R.id.button2);
        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context c = getBaseContext();
                Intent intent = new Intent(c, MatchmakingActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }
    */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_main_old, container, false);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Toast.makeText(getActivity(), "BUTTON PRESSED",Toast.LENGTH_SHORT).show();
                // switchFragment(HelpFragment.TAG);
                break;
            case R.id.button2:

                break;
        }
    }
}

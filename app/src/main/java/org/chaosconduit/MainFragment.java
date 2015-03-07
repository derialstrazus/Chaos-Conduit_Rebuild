package org.chaosconduit;

import android.content.Context;
import android.content.Intent;
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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View InputView = inflater.inflate(R.layout.activity_main_old, container, false);
        Button A = (Button) InputView.findViewById(R.id.button);
        A.setOnClickListener(this);
        Button B = (Button) InputView.findViewById(R.id.button2);
        B.setOnClickListener(this);
        return InputView;
    }


    @Override
    public void onClick(View v) {
        Context c;
        Intent intent;
        switch (v.getId()) {
            case R.id.button2:
                c = getActivity();
                intent = new Intent(c, FightActivity.class);
                startActivity(intent);
                break;
            case R.id.button:
                c = getActivity();
                intent = new Intent(c, MatchmakingActivity.class);
                startActivity(intent);
                break;
        }
    }
}

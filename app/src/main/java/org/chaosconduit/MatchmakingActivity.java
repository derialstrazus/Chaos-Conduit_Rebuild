package org.chaosconduit;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

/**
 * Created by Derial on 3/7/2015.
 */
public class MatchmakingActivity extends ActionBarActivity implements View.OnClickListener {


    boolean found;
    Firebase firebase;
    String UID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_opponents);
        firebase = new Firebase(getResources().getString(R.string.firebase));
        AuthData auth = firebase.getAuth();
        UID = auth.getUid();

        Button findMatch = (Button) findViewById(R.id.find_match);
        Button createMatch = (Button) findViewById(R.id.create_match);
        createMatch.setOnClickListener(this);
        findMatch.setOnClickListener(this);

    }

    public void matchFound(){
        Toast.makeText(getBaseContext(),"Match Found!", Toast.LENGTH_SHORT).show();
    }

    public void matchNotFound(){
        Toast.makeText(getBaseContext(),"Match Not Found!", Toast.LENGTH_SHORT).show();
    }

    public void createNewMatch(){
        Firebase gamesRef = firebase.child("games");
        GameInfo gi = new GameInfo(UID);
        final String ID = gamesRef.push().getKey();//.setValue(gi.toMap());
        gamesRef.child(ID).setValue(gi.toMap());
        Intent intent = new Intent(getBaseContext(), WaitMatchActivity.class);
        intent.putExtra("ID", ID);
        startActivity(intent);
        finish();
        /*gamesRef.child(ID).child("status").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                    Toast.makeText(getBaseContext(), dataSnapshot.getValue().toString(), Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getBaseContext(), WaitMatchActivity.class);
                    intent.putExtra("ID", ID);
                    startActivity(intent);
                    finish();
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });*/
    }


    public void findMatch(){

        final Firebase gamesRef = firebase.child("games");
        gamesRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Iterable<DataSnapshot> iterator = snapshot.getChildren();
                found = false;
                for (DataSnapshot ds : iterator) {
                    String p2 = ds.child("status").getValue().toString();
                    if (p2.equals("open")) {
                        gamesRef.child(ds.getKey()).child("player2").setValue(UID);
                        gamesRef.child(ds.getKey()).child("status").setValue("closed");
                        matchFound();
                        return;
                    }
                }
                matchNotFound();
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.find_match:
                findMatch();;
                break;
            case R.id.create_match:
                createNewMatch();
                break;
        }
    }
}

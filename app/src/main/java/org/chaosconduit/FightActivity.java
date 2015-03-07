package org.chaosconduit;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Random;


public class FightActivity extends ActionBarActivity {

    int permission = 1;     // 1 is permission allowed, 0 is not allowed, ie enemy turn.
    TextView enemyHealth;
    TextView selfMana1, selfMana2, selfMana3;
    Firebase firebase, gamesRef;
    int player, enemy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);
        Button selfAttack = (Button) findViewById(R.id.buttonAttack);
        Button enemyPass = (Button) findViewById(R.id.enemyButtonPass);
        enemyHealth = (TextView) findViewById(R.id.enemyHP);
        enemyHealth.setText(Integer.toString(60));
        selfMana1 = (TextView) findViewById(R.id.selfMana1);
        selfMana2 = (TextView) findViewById(R.id.selfMana2);
        selfMana3 = (TextView) findViewById(R.id.selfMana3);
        selfMana1.setText(Integer.toString(0));
        selfMana2.setText(Integer.toString(0));
        selfMana3.setText(Integer.toString(0));

        gamesRef = firebase.child("games");
        final String ID = getIntent().getStringExtra("ID");
        player = getIntent().getIntExtra("Player", 0);
        if (player == 1) {
            enemy = 2;
        }
        else {
            enemy = 1;
        }

        gamesRef.child(ID).child("turn").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue().toString().equals(player)) {
                    permission = 1;
                    int mana1 = Integer.parseInt(selfMana1.getText().toString());
                    int mana2 = Integer.parseInt(selfMana2.getText().toString());
                    int mana3 = Integer.parseInt(selfMana3.getText().toString());
                    //start Roll mana
                    Random randMana = new Random();
                    for (int i = 0; i < 3; i++) {
                        int rolledMana = randMana.nextInt(3) + 1;
                        switch (rolledMana) {
                            case 1:
                                mana1++;
                                break;
                            case 2:
                                mana2++;
                                break;
                            case 3:
                                mana3++;
                                break;
                        }
                    }
                    selfMana1.setText(Integer.toString(mana1));
                    selfMana2.setText(Integer.toString(mana2));
                    selfMana3.setText(Integer.toString(mana3));
                    if (mana1 + mana2 + mana3 > 5) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getBaseContext());
                        builder.setMessage("You have too much mana!");
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        selfAttack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (permission == 1) {
                    int damage = 3;
                    int currentHP = Integer.parseInt(enemyHealth.getText().toString());
                    int finalHP = currentHP - damage;
                    //String send = Integer.toString(finalHP);
                    enemyHealth.setText(Integer.toString(finalHP));
                    permission = 0;
                    gamesRef.child(ID).child("turn").setValue(enemy);
                }
            }
        });

        enemyPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                permission = 1;
                int mana1 = Integer.parseInt(selfMana1.getText().toString());
                int mana2 = Integer.parseInt(selfMana2.getText().toString());
                int mana3 = Integer.parseInt(selfMana3.getText().toString());
                //start Roll mana
                Random randMana = new Random();
                for (int i = 0; i < 3; i++) {
                    int rolledMana = randMana.nextInt(3) + 1;
                    switch (rolledMana) {
                        case 1:
                            mana1++;
                            break;
                        case 2:
                            mana2++;
                            break;
                        case 3:
                            mana3++;
                            break;
                    }
                }
                selfMana1.setText(Integer.toString(mana1));
                selfMana2.setText(Integer.toString(mana2));
                selfMana3.setText(Integer.toString(mana3));
                if (mana1 + mana2 + mana3 > 5) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getBaseContext());
                    builder.setMessage("You have too much mana!");
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fight, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

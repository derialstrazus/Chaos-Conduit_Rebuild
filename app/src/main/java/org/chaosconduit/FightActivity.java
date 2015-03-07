package org.chaosconduit;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class FightActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);
        Button selfAttack = (Button) findViewById(R.id.buttonSelfAtk);
        Button enemyAttack = (Button) findViewById(R.id.buttonEnemyAtk);
        selfAttack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context c = getBaseContext();
                TextView enemyHealth = (TextView) findViewById(R.id.textView6);
                int damage = 3;
                int currentHP = Integer.parseInt(enemyHealth.getText().toString());
                int finalHP = currentHP - damage;
                //String send = Integer.toString(finalHP);
                enemyHealth.setText(Integer.toString(finalHP));
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

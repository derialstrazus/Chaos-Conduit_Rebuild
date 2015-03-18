package org.chaosconduit;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class SingleActivity extends ActionBarActivity {

    int permission;
    TextView selfHealth, enemyHealth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight_solo);

        Button selfAttack = (Button) findViewById(R.id.buttonAttack);

        final ImageButton spell_111 = (ImageButton) findViewById(R.id.spellFlareButton);   //Flare
        final ImageButton spell_112 = (ImageButton) findViewById(R.id.spellExploButton);     //Explo
        final ImageButton spell_122 = (ImageButton) findViewById(R.id.spellSunburstButton);   //Sunburst
        final ImageButton spell_222 = (ImageButton) findViewById(R.id.spellBoltButton);   //Bolt
        final ImageButton spell_223 = (ImageButton) findViewById(R.id.spellTransformerButton);     //Transformer
        final ImageButton spell_233 = (ImageButton) findViewById(R.id.spellPulseButton);   //Pulse
        final ImageButton spell_333 = (ImageButton) findViewById(R.id.spellEnlightenButton);   //Enlighten
        final ImageButton spell_133 = (ImageButton) findViewById(R.id.spellExtractButton);   //Extract
        final ImageButton spell_113 = (ImageButton) findViewById(R.id.spellManacombustButton);   //Manacombust
        final ImageButton spell_123 = (ImageButton) findViewById(R.id.spellOvertapButton);   //Overtap
        final ImageButton mainSpellReady = (ImageButton) findViewById(R.id.highlightSpellButton);
        final TextView mainSpellName = (TextView) findViewById(R.id.highlightSpellName);
        final TextView mainSpellDesc = (TextView) findViewById(R.id.highlightSpellDesc);

        TextView enemyActivity = (TextView) findViewById(R.id.enemyActivity);

        final ImageView manaCost1 = (ImageView) findViewById(R.id.manaCost1);
        final ImageView manaCost2 = (ImageView) findViewById(R.id.manaCost2);
        final ImageView manaCost3 = (ImageView) findViewById(R.id.manaCost3);
        final ImageView manaAmp1 = (ImageView) findViewById(R.id.manaAmp1);
        final ImageView manaAmp2 = (ImageView) findViewById(R.id.manaAmp2);
        final ImageView manaAmp3 = (ImageView) findViewById(R.id.manaAmp3);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_single, menu);
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

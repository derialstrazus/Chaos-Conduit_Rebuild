package org.chaosconduit;

import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by Cameron on 3/7/2015.
 */
public class Spells {

    public static List Flare(Map<String, Object> mapSelf, Map<String, Object> mapEnemy, int redAmp) {
        List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();

        int enemyHealth = Integer.parseInt(mapEnemy.get("health").toString());
        int damage = 6, chance = 3;
        int flareCount = 0;

        if (redAmp == 0) {
            damage = 6;
        }
        else if (redAmp == 1) {
            damage = 8;
        }
        else if (redAmp == 2) {
            damage = 10;
        }

        Random flareChance = new Random();
        while (chance == 3){
            enemyHealth = enemyHealth - damage;
            chance = flareChance.nextInt(3) + 1;
            flareCount++;
//            Toast.makeText(getBaseContext(), ("Flare Triggered %d times", flareCount), Toast.LENGTH_SHORT.show());
        }

        mapEnemy.put("health", enemyHealth);

        maps.add(mapSelf);
        maps.add(mapEnemy);
        return maps;
    }

}

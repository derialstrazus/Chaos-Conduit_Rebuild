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

//    public static List BaseSpell(Map<String, Object> mapSelf,
//                                 Map<String, Object> mapEnemy,
//                                 int redAmp) {
//        List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
//        int enemyHealth = Integer.parseInt(mapEnemy.get("health").toString());
//        int damage = 6;
//
//        if (redAmp == 1) {
//            damage = 6;
//        }
//        else if (redAmp == 2) {
//            damage = 8;
//        }
//
//        enemyHealth = enemyHealth - damage;
//        mapEnemy.put("health", enemyHealth);
//        maps.add(mapSelf);
//        maps.add(mapEnemy);
//        return maps;
//    }

    public static List Flare(Map<String, Object> mapSelf, Map<String, Object> mapEnemy, int redAmp) {
        List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
        int enemyHealth = Integer.parseInt(mapEnemy.get("health").toString());
        // need to parse mana amounts then decrement it.
        //int selfManaRed = Integer.parseInt(mapSelf.get("manaAmt").toString());
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

//    public static List Bolt(Map<String, Object> mapSelf, Map<String, Object> mapEnemy, int yellowAmp) {
//        List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
//        int enemyHealth = Integer.parseInt(mapEnemy.get("health").toString());
//        int damage = 10;
//
//        if (yellowAmp == 1) {
//            damage = 15;
//        }
//        else if (yellowAmp == 2) {
//            damage = 20;
//        }
//
//        enemyHealth = enemyHealth - damage;
//        mapEnemy.put("health", enemyHealth);
//        //add no heal buff for 1 turn.
//        maps.add(mapSelf);
//        maps.add(mapEnemy);
//        return maps;
//    }

//    public static List Enlighten(Map<String, Object> mapSelf,
//                                 Map<String, Object> mapEnemy,
//                                 int blueAmp) {
//        List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
//        int selfMaxMana = Integer.parseInt(mapSelf.get("MaxMana").toString());
//        int manaCap = 1;
//
//        if (blueAmp == 1) {
//            manaCap = 2;
//        }
//
//        selfMaxMana = selfMaxMana + manaCap;
//        mapSelf.put("MaxMana", selfMaxMana);
//        maps.add(mapSelf);
//        maps.add(mapEnemy);
//        return maps;
//    }

    public static List Explosion(Map<String, Object> mapSelf,
                                 Map<String, Object> mapEnemy,
                                 int redAmp,
                                 int yellowAmp) {
        List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
        int enemyHealth = Integer.parseInt(mapEnemy.get("health").toString());
        int selfHealth = Integer.parseInt(mapSelf.get("health").toString());
        int damage = 15, damageSelf = 10;

        if (redAmp == 1) {
            damage = 20;
        }
        else if (redAmp == 2) {
            damage = 25;
        }

        if (yellowAmp == 1) {
            damageSelf = 7;
        }
        else if (yellowAmp == 2) {
            damageSelf = 3;
        }

        enemyHealth = enemyHealth - damage;
        selfHealth = selfHealth - damageSelf;
        mapEnemy.put("health", enemyHealth);
        mapSelf.put("health", selfHealth);
        maps.add(mapSelf);
        maps.add(mapEnemy);
        return maps;
    }

//    public static List Sunburst(Map<String, Object> mapSelf,
//                                Map<String, Object> mapEnemy,
//                                int redAmp,
//                                int yellowAmp) {
//        List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
//        int enemyHealth = Integer.parseInt(mapEnemy.get("health").toString());
//        int selfSunburstHist = Integer.parseInt(mapSelf.get("sunburstHist").toString());
//        int damage = 20;
//
//        enemyHealth = enemyHealth - damage;
//        mapEnemy.put("health", enemyHealth);
//        mapSelf.put("sunburstHist", "1");
//        maps.add(mapSelf);
//        maps.add(mapEnemy);
//        return maps;
//    }

//    public static List ManaCombustion(Map<String, Object> mapSelf,
//                                 Map<String, Object> mapEnemy,
//                                 int redAmp,
//                                 int blueAmp) {
//        List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
//        int enemyHealth = Integer.parseInt(mapEnemy.get("health").toString());
//        int damage = 6;
//
//        if (redAmp == 1) {
//            damage = 6;
//        }
//        else if (redAmp == 2) {
//            damage = 8;
//        }
//
//        enemyHealth = enemyHealth - damage;
//        mapEnemy.put("health", enemyHealth);
//        maps.add(mapSelf);
//        maps.add(mapEnemy);
//        return maps;
//    }

//    public static List ForcedExtraction(Map<String, Object> mapSelf,
//                                 Map<String, Object> mapEnemy,
//                                 int redAmp,
//                                 int blueAmp) {
//        List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
//        int enemyHealth = Integer.parseInt(mapEnemy.get("health").toString());
//        int damage = 5;
//
//        if (redAmp == 1) {
//            damage = 7;
//        }
//        else if (redAmp == 2) {
//            damage = 10;
//        }
//
//        enemyHealth = enemyHealth - damage;
//        mapEnemy.put("health", enemyHealth);
//        maps.add(mapSelf);
//        maps.add(mapEnemy);
//        return maps;
//    }

//    public static List TransformerBolt(Map<String, Object> mapSelf,
//                                 Map<String, Object> mapEnemy,
//                                 int anyAmp) {
//        List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
//        int enemyHealth = Integer.parseInt(mapEnemy.get("health").toString());
//        int damage = 8;
//
//        if (anyAmp == 1) {
//            damage = 10;
//        }
//        else if (anyAmp == 2) {
//            damage = 16;
//        }
//
//        enemyHealth = enemyHealth - damage;
//        mapEnemy.put("health", enemyHealth);
//        maps.add(mapSelf);
//        maps.add(mapEnemy);
//        return maps;
//    }

//    public static List ElectricPulse(Map<String, Object> mapSelf,
//                                 Map<String, Object> mapEnemy,
//                                 int yellowAmp,
//                                 int blueAmp) {
//        List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
//        int enemyHealth = Integer.parseInt(mapEnemy.get("health").toString());
//        //get enemyMana and remove it
//        int damage = 5;
//        int removeMana = 2;
//
//        if (yellowAmp == 1) {
//            damage = 7;
//        }
//        else if (yellowAmp == 2) {
//            damage = 10;
//        }
//        if (blueAmp == 1) {
//            removeMana = 3;
//        }
//        else if (blueAmp == 2) {
//            removeMana = 4;
//        }
//
//        enemyHealth = enemyHealth - damage;
//        //enemyMana = enemyMana - removeMana;
//        mapEnemy.put("health", enemyHealth);
//        maps.add(mapSelf);
//        maps.add(mapEnemy);
//        return maps;
//    }

//    public static List Overtap(Map<String, Object> mapSelf,
//                                     Map<String, Object> mapEnemy,
//                                     int redAmp,
//                                     int yellowAmp,
//                                     int blueAmp) {
//        List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
//        int enemyHealth = Integer.parseInt(mapEnemy.get("health").toString());
//        //get enemyMana and remove it
//        int redDamage = 7, yellowDamage = 7;
//        int damage = 10;
//        int overtapFatigue = 2;
//
//        if (redAmp == 1) {
//            redDamage = 9;
//        }
//        else if (redAmp == 2) {
//            redDamage = 12;
//        }
//        if (yellowAmp == 1) {
//            yellowDamage = 9;
//        }
//        else if (yellowAmp == 2) {
//            yellowDamage = 12;
//        }
//        if (blueAmp == 1) {
//            overtapFatigue = 1;
//        }
//        else if (blueAmp == 2) {
//            overtapFatigue = 0;
//        }
//
//        damage = redDamage + yellowDamage;
//
//        enemyHealth = enemyHealth - damage;
//        mapEnemy.put("health", enemyHealth);
//        mapSelf.put("overtapFatigue", overtapFatigue);
//        maps.add(mapSelf);
//        maps.add(mapEnemy);
//        return maps;
//    }

}

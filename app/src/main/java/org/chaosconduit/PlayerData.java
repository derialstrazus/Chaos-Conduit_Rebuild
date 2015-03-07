package org.chaosconduit;

import com.firebase.client.Firebase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cameron on 3/7/2015.
 */


public class PlayerData {
    String playerID;
    int health;
    String manaTypes[];
    int manaAmt[];
    Firebase firebase;

    public PlayerData(){
        firebase = new Firebase("https://chaos-conduit.firebaseio.com/");
        playerID = firebase.getAuth().getUid();
        health = 60;
        manaTypes = new String[3];
        manaAmt = new int[3];
        manaTypes[0] = "RED";
        manaTypes[1] = "BLUE";
        manaTypes[2] = "YELLOW";
        for (int i = 0; i< manaAmt.length;i++){
            manaAmt[i] = 0;
        }
    }

    public Map<String,Object> toMap(){
        Map<String,Object> r = new HashMap<>();
        r.put("playerID", playerID);
        r.put("health",health);
        r.put("manaTypes",manaTypes);
        r.put("manaAmt",manaAmt);
        return r;
    }


}

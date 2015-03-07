package org.chaosconduit;

/**
 * Created by Cameron on 3/7/2015.
 */
public class PlayerData {
    int health;
    String manaTypes[];
    int manaAmt[];

    public PlayerData(){
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



}

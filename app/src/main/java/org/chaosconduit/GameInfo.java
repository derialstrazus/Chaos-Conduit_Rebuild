package org.chaosconduit;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cameron on 3/7/2015.
 */
public class GameInfo {
    String player1;
    String player2;
    String status;
    String turn;

    public GameInfo(String player1){
        status = "open";
        this.player1 = player1;
        player2 = "";
        turn = "1";
    }

    public Map<String, String> toMap()
    {
        Map<String, String> r = new HashMap<String, String>();

        r.put("status", status);
        r.put("player1", player1);
        r.put("player2", player2);
        r.put("turn", turn);

        return r;
    }

}

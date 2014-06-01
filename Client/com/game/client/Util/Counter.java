package com.game.client.Util;

import java.util.ArrayList;

/**
 * Created by E. Mozharovsky on 01.06.14.
 */
public class Counter {
    public static int checkIterationOfSameChars(ArrayList array, String character) {
        int count = 0;

        for(Object a : array) {
            if(a.toString().equals(character)) {
                count += 1;
            }
        }

        return count;
    }
}

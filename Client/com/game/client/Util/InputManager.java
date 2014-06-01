package com.game.client.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by E. Mozharovsky on 01.06.14.
 */
public class InputManager {
    public String getUserInput(String promt){
        String inputLine = null;
        System.out.print(promt + " ");
        try {
            BufferedReader is = new BufferedReader(
                    new InputStreamReader(System.in));
            inputLine = is.readLine();
            if(inputLine.length() == 0) return null;
        } catch(IOException e) {
            System.out.println("IOExeption e: " + e);
        }

        return inputLine;
    }
}

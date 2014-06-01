package com.game.client.WordView;

import java.util.ArrayList;

/**
 * Created by E. Mozharovsky on 01.06.14.
 */
public interface Parser {
    void parse();

     <T extends ArrayList> T getParsedData();
}

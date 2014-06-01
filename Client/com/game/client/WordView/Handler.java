package com.game.client.WordView;

/**
 * Created by E. Mozharovsky on 01.06.14.
 */
public interface Handler {
    void prepare();

    void takeUserInput();

    void start();

    boolean isActive();
}

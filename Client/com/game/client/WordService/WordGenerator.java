package com.game.client.WordService;

import com.game.client.Util.FileParser;
import com.game.client.WordView.Generator;

/**
 * Created by E. Mozharovsky on 01.06.14.
 */
public class WordGenerator implements Generator {
    private FileParser parser = new FileParser("/resources/Input.txt");

    private String word;
    private String hint;

    /**
     * More global method.
     */
    @Override
    public void generate() {
        int result = (int)(Math.random() * parser.getParsedData().size());
        word = parser.getParsedData().get(result).getWord();
        hint = parser.getParsedData().get(result).getHint();
    }

    /**
     * @return
     *        The generated word for the game.
     */
    @Override
    public String getGeneratedServices() {
        return word;
    }

    /**
     * Returns a word hint for a player.
     * @return
     *        The hint for the particular word.
     */
    @Override
    public String getGenerateDependencies() {
        return hint;
    }


    /**
     * Prints an info giving to a player a view of what to do.
     */
    public void printInfo() {
        System.out.println("The word: " + word + ".");
        System.out.println("The hint: " + hint + ".");
    }
}

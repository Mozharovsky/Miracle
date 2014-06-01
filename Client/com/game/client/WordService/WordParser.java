package com.game.client.WordService;

import com.game.client.WordView.Parser;

import java.util.ArrayList;

/**
 * Created by E. Mozharovsky on 01.06.14.
 */
public class WordParser implements Parser {
    private ArrayList<Character> listOfCharacters = new ArrayList<Character>();
    private WordGenerator generator;

    public WordParser(WordGenerator generator) {
        this.generator = generator;
    }

    @Override
    public void parse() {
        if(!generator.getGeneratedServices().equals(null)) {
            for(int i = 0; i < generator.getGeneratedServices().length(); i++) {
                listOfCharacters.add(generator.getGeneratedServices().charAt(i));
            }
        }
    }

    @Override
    public final ArrayList<Character> getParsedData() {
        return listOfCharacters;
    }
}

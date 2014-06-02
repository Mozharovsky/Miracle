package com.game.client.WordService;

import com.game.client.Util.Counter;
import com.game.client.WordView.Printer;

import java.util.ArrayList;

/**
 * Created by E. Mozharovsky on 01.06.14.
 */
public class WordPrinter implements Printer {
    private final ArrayList<Character> list;
    private ArrayList<Character> wordList = new ArrayList<Character>();

    private Counter helper = new Counter();
    private ArrayList<Integer> indexes = new ArrayList<Integer>();

    public WordPrinter(WordParser parser) {
        list = parser.getParsedData();
    }

    private ArrayList<Character> getWordStatus() {
        if(!list.isEmpty()) {
            for(char elem : list) {
                wordList.add("_".toCharArray()[0]);
            }
        }

        return wordList;
    }

    private ArrayList<Character> getWordStatus(String userGuess) {
        if(wordList.isEmpty()) {
            getWordStatus();
        }

        if(list.contains(userGuess.charAt(0))) {
            wordList.set(list.indexOf(userGuess.charAt(0)), list.get(list.indexOf(userGuess.charAt(0))));
        }

        if(helper.checkIterationOfSameChars(list, userGuess) > 1) {
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i).toString().equals(userGuess)) {
                    indexes.add(i);
                }
            }

            for(int a = 0; a < indexes.size(); a++) {
                wordList.set(Integer.parseInt(indexes.get(a).toString()), list.get(Integer.parseInt(indexes.get(a).toString())));
            }
        }

        return wordList;
    }

    @Override
    public void print() {
        String result = "";

        for(char elem : getWordStatus()) {
            result += elem + " ";
        }

        System.out.println(result);
    }

    @Override
    public void print(String userGuess) {
        String result = "";

        for(char elem : getWordStatus(userGuess)) {
            result += elem + " ";
        }

        System.out.println(result);
    }

    @Override
    public void printGameInfo() {
        // TODO: Add an info
        System.out.printf("Welcome to MIRACLE game ... \n");
    }
}

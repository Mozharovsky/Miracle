package com.game.client.WordService;

import com.game.client.Util.InputManager;
import com.game.client.WordView.Generator;
import com.game.client.WordView.Handler;
import com.game.client.WordView.Parser;
import com.game.client.WordView.Printer;

import java.util.ArrayList;

/**
 * Created by E. Mozharovsky on 01.06.14.
 */
public class WordHandler implements Handler {
    private WordGenerator generator;
    private WordParser parser;
    private WordPrinter printer;

    InputManager manager = new InputManager();
    private String userInput;

    private boolean isActive = true;

    public WordHandler() {
        generator = new WordGenerator();
        parser = new WordParser(generator);
        printer = new WordPrinter(parser);

        prepare();
    }

    @Override
    public void start() {
        ArrayList<Character> chars = new ArrayList<Character>();
        chars.addAll(parser.getParsedData());

        ArrayList<Character> charsToRemove = new ArrayList<Character>();
        int attemptsLeft = 4;

        while(isActive) {
            boolean strike = false;
            takeUserInput();

            for(Character _char : chars) {
                if(_char == userInput.charAt(0)) {
                    charsToRemove.add(_char);
                    strike = true;
                }
            }

            if(strike) {
                System.out.println("You have guessed the character!");
                printer.print(Character.toString(userInput.charAt(0)));
                chars.removeAll(charsToRemove);
            } else {
                attemptsLeft--;
                System.out.println("There is no such a character! You've got " + attemptsLeft + "attempts left!");
            }

            if(attemptsLeft == 0 || chars.isEmpty()) {
                System.out.println("Game over!");
                isActive = false;
            }
        }
    }

    @Override
    public void prepare() {
        prepareGenerator(generator);
        prepareParser(parser);
        preparePrinter(printer);
    }

    public void prepareGenerator(Generator generator) {
        generator.generate();
    }

    public void prepareParser(Parser parser) {
        parser.parse();
    }

    public void preparePrinter(Printer printer) {
        printer.printGameInfo();
        generator.printInfo();
        printer.print();
    }

    @Override
    public void takeUserInput() {
        userInput = manager.getUserInput("Type the character: ");
    }

    @Override
    public boolean isActive() {
        return isActive;
    }
}

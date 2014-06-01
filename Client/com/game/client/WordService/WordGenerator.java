package com.game.client.WordService;

import com.game.client.WordView.Generator;

/**
 * Created by E. Mozharovsky on 01.06.14.
 */
public class WordGenerator implements Generator {
    private String sourceWord;
    private String wordHint;

    /**
     * More global method.
     */
    @Override
    public void generate() {
        generateServices();
        generateDependencies();
    }

    /**
     * @return
     *        The generated word for the game.
     */
    @Override
    public String getGeneratedServices() {
        return sourceWord;
    }

    /**
     * Makes a word which is gonna be guessed by a player.
     */
    public void generateServices() {
        // TODO: Read from the text file
        String[] wordsBase = {"СОЛЬ",  "ВОДА", "ПЕНА", "РЕФОРМА", "АВТОМОБИЛЬ", "ПАРАЛЛЕЛОГРАММ"};
        int randomNumber = (int)(Math.random() * 6);

        // And set the meaning of the variable
        this.sourceWord = wordsBase[randomNumber];
        generateDependencies();
    }

    /**
     * Returns a word hint for a player.
     * @return
     *        The hint for the particular word.
     */
    @Override
    public String getGenerateDependencies() {
        return wordHint;
    }

    /**
     * Sets a hint for each word.
     */
    public void generateDependencies() {
        // TODO: Read from the text file and later from the online database
        if(sourceWord.equals("АВТОМОБИЛЬ"))
            this.wordHint = "Это изобретение создал в 1768 году Никола Жозеф Куньо.";
        if(sourceWord.equals("СОЛЬ"))
            this.wordHint = "Пищевой продукт. Хлорид натрия.";
        if(sourceWord.equals("РЕФОРМА"))
            this.wordHint = "Это механизм, направленный на развитие той или иной сферы государства.";
        if(sourceWord.equals("ВОДА"))
            this.wordHint = "Жизнь без этого вещества была бы невозможна.";
        if(sourceWord.equals("ПЕНА"))
            this.wordHint = "Это дисперсная система с газовой дисперсной фазой и жидкой или твёрдой дисперсионной средой.";
        if(sourceWord.equals("ПАРАЛЛЕЛОГРАММ"))
            this.wordHint = "Геометрическая фигура - выпуклый четырехугольник, у которого все противоположные стороны параллельны и равны.";
    }

    /**
     * Prints an info giving to a player a view of what to do.
     */
    public void printInfo() {
        System.out.println("The word: " + sourceWord + ".");
        System.out.println("The hint: " + wordHint + ".");
    }
}

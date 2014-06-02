package com.game.client.Util;

import com.game.client.WordView.Parser;
import sun.util.locale.StringTokenIterator;

import java.util.ArrayList;
import java.io.*;

/**
 * Created by E. Mozharovsky on 02.06.14.
 */
public class FileParser implements Parser {
    private ArrayList<DataStruct> data = new ArrayList<DataStruct>();

    private FileInputStream f_in;
    private BufferedReader reader;

    public FileParser(String path) {
        try {
            f_in = new FileInputStream(path);
            reader = new BufferedReader(new InputStreamReader(f_in));
        } catch(FileNotFoundException e) {
            System.out.println(e);
        }

        parse();
    }

    @Override
    public void parse() {
        try {
            int strikeCount = 0;
            String word = "";
            String hint = "";

            while(reader.ready()) {
                String line = reader.readLine();

                if(line.startsWith("Word:")) {
                    StringTokenIterator helper = new StringTokenIterator(line.substring(line.indexOf(":") + 1), " ");
                    strikeCount++;
                    word = helper.next();

                    for(Character _char : word.toCharArray()) {
                        if(Character.isLowerCase(_char)) {
                            strikeCount--;
                        }
                    }
                }

                if(line.startsWith("Hint:")) {
                    StringTokenIterator helper = new StringTokenIterator(line.substring(line.indexOf(":") + 1), " ");
                    strikeCount++;
                    hint = line.substring(line.indexOf(helper.next()));
                }

                if(strikeCount == 2) {
                    data.add(new DataStruct(word, hint));
                    strikeCount = 0;
                }

                if(strikeCount == 0) {
                    word = new String();
                    hint = new String();
                }
            }
        } catch(IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public ArrayList<DataStruct> getParsedData() {
        return data;
    }

    public class DataStruct {
        private String word;
        private String hint;

        public DataStruct(String word, String hint) {
            if(!word.equals(null) && !hint.equals(null)) {
                this.word = word;
                this.hint = hint;
            }
        }

        public String getWord() {
            return word;
        }

        public String getHint() {
            return hint;
        }
    }
}

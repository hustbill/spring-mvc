package spring;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordChecker {
	// a local solution for validate a word
    public static boolean validWord(String word) {
        // System.out.println(word);
        try {
            BufferedReader in = new BufferedReader(new FileReader(
                    "/usr/share/dict/web2"));
            String str;
            while ((str = in.readLine()) != null) {
                if (str.indexOf(word) != -1) {
                    return true;
                }
            }
            in.close();
        } catch (IOException e) {
        }

        return false;
    }
}

/*
 * There are many possible solutions to this some are the following

Use a web Dictionary API

http://developer.dictionary.com/

http://googlesystem.blogspot.com/2009/12/on-googles-unofficial-dictionary-api.html

http://www.dictionaryapi.com/


 * 
 * 
 */

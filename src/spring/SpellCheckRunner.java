package spring;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class SpellCheckRunner {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		if (args.length < 1) {
			System.err.println("Usage java spellCheckRunner <file_to_check>");
			System.exit(-1);
		}
		
		final String dictionary = "/usr/share/dict/web2";
		
		final List<String> wordsFromFile  = getWordsFromFile(args[0]);
		
		final SpellCheckApplication checker = 
				new SpellCheckApplication(dictionary, wordsFromFile) ;
		
		final List<Integer> indices = checker.checkDocument(wordsFromFile);
		System.out.print(indices);
	}
	
	static List<String> getWordsFromFile(final String filename) {
		List<String> result = new ArrayList<>();
		
		//Path path = Paths.get("words.txt");
		Path path = Paths.get(filename);
        byte[] readBytes = null;
		try {
			readBytes = Files.readAllBytes(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String wordListContents = null;
		try {
			wordListContents = new String(readBytes, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String[] words = wordListContents.split("\n");
      
        Collections.addAll(result, words);
        return result;
	}

}

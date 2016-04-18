package spring;
import java.util.*;

public class SpellCheckApplication {

	//private final Dictionary dictionary;
	 static private  String dictionary;
	private List<String> document;
	
	// dictionary =    "/usr/share/dict/web2";
	
//	public SpellCheckApplication (final Dictionary dictionary) {
//		this.dictionary = dictionary;
//	}
	
	public SpellCheckApplication (final String dictionary, List<String> document) {
		SpellCheckApplication.dictionary = dictionary;
		this.document = document;
	}
	
	public static List<Integer> checkDocument (List<String> document) {
		final List<Integer> misspelledWords = new ArrayList<>();
		WordChecker wordChecker = new WordChecker();
		
		for (int i = 0; i < document.size(); i++) {
			final String word = document.get(i);
			if (!WordChecker.validWord(dictionary, word)) {
				System.out.println(word);
				misspelledWords.add(i);
			}
		}
		
		return misspelledWords;
	}
}

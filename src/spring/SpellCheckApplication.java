package spring;
import java.util.*;

public class SpellCheckApplication {

	private final Dictionary dictionary;
	
	public SpellCheckApplication (final Dictionary dictionary) {
		this.dictionary = dictionary;
	}
	
	public List<Integer> checkDocument (List<String> document) {
		final List<Integer> misspelledWords = new ArrayList<>();
		WordChecker wordChecker = new WordChecker();
		
		for (int i = 0; i < misspelledWords.size(); i++) {
			final String word = document.get(i);
			if (!wordChecker.validWord(word)) {
				misspelledWords.add(i);
			}
		}
		
		return misspelledWords;
	}
}

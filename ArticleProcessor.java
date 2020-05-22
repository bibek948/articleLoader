package ProgrammingWorkshopLab.MileStone3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ArticleProcessor implements IArticleProcessor {

	private static final String SPACE = " ";

	//create string of stop words
	private static String[] stopWords = { "i", "me", "my", "myself", "we", "our", "ours", "ourselves", "you", "your",
			"yours", "yourself", "yourselves", "he", "him", "his", "himself", "she", "her", "hers", "herself", "it",
			"its", "itself", "they", "them", "their", "theirs", "themselves", "what", "which", "who", "whom", "this",
			"that", "these", "those", "am", "is", "are", "was", "were", "be", "been", "being", "have", "has", "had",
			"having", "do", "does", "did", "doing", "a", "an", "the", "and", "but", "if", "or", "because", "as",
			"until", "while", "of", "at", "by", "for", "with", "about", "against", "between", "into", "through",
			"during", "before", "after", "above", "below", "to", "from", "up", "down", "in", "out", "on", "off", "over",
			"under", "again", "futher", "then", "once", "here", "there", "when", "where", "why", "how", "all", "any",
			"both", "each", "few", "more", "most", "other", "some", "such", "no", "nor", "not", "only", "own", "same",
			"so", "than", "too", "very", "s", "t", "can", "will", "just", "don", "should", "now" };

	private List<String> stopWordList = Arrays.asList(stopWords);
	
	/**
	 * create a list of every word in the article from the list of line
	 * @param linesList
	 * @return
	 */
	public List<String> getWordList(List<String> linesList) {
		List<String> wordList = new ArrayList<>();
		String currentLine = null;
		String[] words = null;
		for (int i = 0; i < linesList.size(); i++) {
			currentLine = linesList.get(i);
			words = currentLine.split(SPACE);
			for (String temp : words)
				wordList.add(temp);
		}
		return wordList;
	}
	
	/**
	 * create a word map from the list of word, with the word as key and its frequency as value
	 * @param wordList
	 * @return
	 */
	public HashMap<String, Integer> getWordMap(List<String> wordList) {
		HashMap<String, Integer> wordMap = new HashMap<>();
		for (int i = 0; i < wordList.size(); i++) {
			String temp = wordList.get(i);
			if (wordMap.containsKey(temp)) {
				int newFrequency = wordMap.get(temp) + 1;
				wordMap.put(temp, newFrequency);
			} else {
				wordMap.put(temp, 1);
			}
		}
		return wordMap;
	}
	
	/**
	 * remove all the stop words from the word map
	 * @param wordMap
	 * @return
	 */
	public HashMap<String, Integer> removeStopWords(HashMap<String, Integer> wordMap) {
		for (String current : wordMap.keySet()) {
			if (stopWordList.contains(current)) {
				wordMap.remove(current);
				return wordMap;
			}
		}
		return wordMap;
	}
	
	/**
	 * get the total number of words
	 * @param wordMap
	 * @return
	 */
	public int getWordCount(HashMap<String, Integer> wordMap) {
		int count = 0;
		for (int curFrequency : wordMap.values())
			count += curFrequency;
		return count;
	}
	
	/**
	 * get the total number of unique words
	 * @param wordMap
	 * @return
	 */
	public int getUniqueWordCount(HashMap<String, Integer> wordMap) {
		int count = wordMap.size();
		return count;
	}
	
	/**
	 * get the word with the most frequency in the article
	 * @param wordMap
	 */
	public void getMostFrequency(HashMap<String, Integer> wordMap) {
		String mostFrequentWord = "";
		int freq = 0;
		Iterator<Map.Entry<String, Integer>> iterator = wordMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Integer> entry = iterator.next();
			if (entry.getValue() > freq) {
				mostFrequentWord = entry.getKey();
				freq = entry.getValue();
			}
		}
		System.out.println("The most frequent word is " + mostFrequentWord + " with " + freq + " apperances.");
	}

}

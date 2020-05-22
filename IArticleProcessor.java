package ProgrammingWorkshopLab.MileStone3;

import java.util.HashMap;
import java.util.List;

public interface IArticleProcessor {
	
	/**
	 * create a list of every word in the article from the list of line
	 * @param linesList
	 * @return
	 */
	public List<String> getWordList(List<String> linesList);
	
	/**
	 * create a word map from the list of word, with the word as key and its frequency as value
	 * @param wordList
	 * @return
	 */
	public HashMap<String, Integer> getWordMap(List<String> wordList);
	
	/**
	 * remove all the stop words from the word map
	 * @param wordMap
	 * @return
	 */
	public HashMap<String, Integer> removeStopWords(HashMap<String, Integer> wordMap);
	
	/**
	 * get the total number of words
	 * @param wordMap
	 * @return
	 */
	public int getWordCount(HashMap<String, Integer> wordMap);
	
	/**
	 * get the total number of unique words
	 * @param wordMap
	 * @return
	 */
	public int getUniqueWordCount(HashMap<String, Integer> wordMap);
	
	/**
	 * get the word with the most frequency in the article
	 * @param wordMap
	 */
	public void getMostFrequency(HashMap<String, Integer> wordMap);
}

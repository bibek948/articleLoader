package ProgrammingWorkshopLab.MileStone3;

import java.util.HashMap;

public interface IHeuristicsProcessor {
	
	/**
	 * from three word maps of three articles, compare and output the article with the richest vocabulary
	 * @param wordMap1
	 * @param wordMap2
	 * @param wordMap3
	 */
	public void compareVocab(HashMap<String, Integer> wordMap1, HashMap<String, Integer> wordMap2, HashMap<String, Integer> wordMap3);
	
	/**
	 * get the number of positive words in the article
	 * @param wordMap
	 * @return
	 */
	public int getPositive(HashMap<String, Integer> wordMap);
	
	/**
	 * get the number of negative words in the article
	 * @param wordMap
	 * @return
	 */
	public int getNegative(HashMap<String, Integer> wordMap);
	
}

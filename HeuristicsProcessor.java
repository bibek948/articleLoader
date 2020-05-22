package ProgrammingWorkshopLab.MileStone3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HeuristicsProcessor extends ArticleProcessor implements IHeuristicsProcessor {

	ArticleReader articleReader = new ArticleReader();
	
	List<String> negativeWordList = articleReader.readFile("NegativeWords.txt");
	List<String> positiveWordList = articleReader.readFile("PositiveWords.txt");

	/**
	 * from three word maps of three articles, compare and output the article with the richest vocabulary
	 * @param wordMap1
	 * @param wordMap2
	 * @param wordMap3
	 */
	public void compareVocab(HashMap<String, Integer> wordMap1, HashMap<String, Integer> wordMap2, HashMap<String, Integer> wordMap3) {
		double vocabRichness1 = getWordCount(wordMap1) / getUniqueWordCount(wordMap1);
		double vocabRichness2 = getWordCount(wordMap2) / getUniqueWordCount(wordMap2);
		double vocabRichness3 = getWordCount(wordMap3) / getUniqueWordCount(wordMap3);
		String richestVocab;
		if (vocabRichness1 > vocabRichness2)
			if (vocabRichness1 > vocabRichness3)
				richestVocab = "Article 1";
			else richestVocab = "Article 3";
		else if (vocabRichness2 > vocabRichness3)
			richestVocab = "Article 2";
		else richestVocab = "Article 3";
		System.out.println("The article with the richest vocabulary is: " + richestVocab);
	}
	
	/**
	 * get the number of positive words in the article
	 * @param wordMap
	 * @return
	 */
	public int getPositive(HashMap<String, Integer> wordMap) {
		int count = 0;
		Iterator<Map.Entry<String, Integer>> iterator = wordMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Integer> entry = iterator.next();
			if (positiveWordList.contains(entry.getKey())) {
				count += entry.getValue();
			}
		}
		return count;
	}
	
	/**
	 * get the number of negative words in the article
	 * @param wordMap
	 * @return
	 */
	public int getNegative(HashMap<String, Integer> wordMap) {
		int count2 = 0;
		Iterator<Map.Entry<String, Integer>> iterator = wordMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Integer> entry = iterator.next();
			if (negativeWordList.contains(entry.getKey())) {
				count2 += entry.getValue();
			}
		}
		return count2;
	}
	
}

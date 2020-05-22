package ProgrammingWorkshopLab.MileStone3;

import java.util.List;
import java.util.Scanner;
import java.util.HashMap;

public class TestHarness2 {
	
	@SuppressWarnings("unchecked")
	public static HashMap<String, Integer>[] Articles = new HashMap[3];
	public static int articleCount = 0;

	public static void main(String[] args) {

//		IArticleReader reader = new ArticleReader();
//		IArticleProcessor processor = new ArticleProcessor();
//		IHeuristicsProcessor hProcessor = new HeuristicsProcessor();
//		ISearchProcessor sProcessor = new SearchProcessor();
		
		IArticleReader reader = new ArticleReader();
		IArticleProcessor processor = new ArticleProcessor();
		
//		Polymorphically Initialized
		ArticleProcessor hProcessor = new HeuristicsProcessor();
		ArticleProcessor sProcessor = new SearchProcessor();
		
		System.out.println("Enter Word to Search Lil Homie (Case Sensitive):");
		Scanner sc = new Scanner(System.in);
	    // String input
	    String name = sc.nextLine();
	    sc.close();
	    System.out.println("Word You are Searching For: " + name); 
		
		process("LabArticle1.txt", reader, processor, (HeuristicsProcessor) hProcessor, (SearchProcessor) sProcessor, name);
		process("LabArticle2.txt", reader, processor, (HeuristicsProcessor) hProcessor, (SearchProcessor) sProcessor, name);
		process("LabArticle3.txt", reader, processor, (HeuristicsProcessor) hProcessor, (SearchProcessor) sProcessor, name);
		
		((HeuristicsProcessor) hProcessor).compareVocab(Articles[0], Articles[1], Articles[2]);
	}
	

	/**
	 * method to use every methods at once (hover over the method to get information)
	 * @param filename
	 * @param reader
	 * @param processor
	 * @param hProcessor
	 * @param sProcessor
	 */
	public static void process(String filename, IArticleReader reader, IArticleProcessor processor, HeuristicsProcessor hProcessor, SearchProcessor sProcessor, String name) {
		
		List<String> article = reader.readFile(filename);
		
		List<String> wordList = processor.getWordList(article);
		
		HashMap<String, Integer> wordMap = processor.getWordMap(wordList);
		
		Articles[articleCount++] = wordMap;
//		add the newly created word map to the array of word map to compare vocabulary later
		
		wordMap = processor.removeStopWords(wordMap);
		
		System.out.println("There are " + processor.getWordCount(wordMap) + " words in the article.");
		
		System.out.println("There are " + processor.getUniqueWordCount(wordMap) + " unique words in the article.");
		
		processor.getMostFrequency(wordMap);
		
		System.out.println("There are " + hProcessor.getPositive(wordMap) + " positive words in this article.");
		
		System.out.println("There are " + hProcessor.getNegative(wordMap) + " negative words in this article.");
		
//		This word is in there you little baby
//		sProcessor.simpleSearch(article, "camera");
		
		sProcessor.simpleSearch(article, name);
		
		System.out.println();
	}
	
//
//	/**
//	 * method to use every methods at once (hover over the method to get information)
//	 * @param filename
//	 * @param reader
//	 * @param processor
//	 * @param hProcessor
//	 * @param sProcessor
//	 */
//	public static void process(String filename, IArticleReader reader, IArticleProcessor processor, IHeuristicsProcessor hProcessor, ISearchProcessor sProcessor, String name) {
//		
//		List<String> article = reader.readFile(filename);
//		
//		List<String> wordList = processor.getWordList(article);
//		
//		HashMap<String, Integer> wordMap = processor.getWordMap(wordList);
//		
//		Articles[articleCount++] = wordMap;
////		add the newly created word map to the array of word map to compare vocabulary later
//		
//		wordMap = processor.removeStopWords(wordMap);
//		
//		System.out.println("There are " + processor.getWordCount(wordMap) + " words in the article.");
//		
//		System.out.println("There are " + processor.getUniqueWordCount(wordMap) + " unique words in the article.");
//		
//		processor.getMostFrequency(wordMap);
//		
//		System.out.println("There are " + hProcessor.getPositive(wordMap) + " positive words in this article.");
//		
//		System.out.println("There are " + hProcessor.getNegative(wordMap) + " negative words in this article.");
//		
////		This word is in there you little baby
////		sProcessor.simpleSearch(article, "camera");
//		
//		sProcessor.simpleSearch(article, name);
//		
//		System.out.println();
//	}
}

package ProgrammingWorkshopLab.MileStone3;

import java.util.ArrayList;
import java.util.List;

public class SearchProcessor extends ArticleProcessor implements ISearchProcessor {
	
	/**
	 * search the article for a specific word (searchWord) and output the lines that contain the word with the times the word appears on the line
	 * @param lineList
	 * @param searchWord
	 */
	public void simpleSearch(List<String> lineList, String searchWord) {
		List<Integer> linesAppeared = new ArrayList<>();
		List<Integer> timesAppeared = new ArrayList<>(); 
		int countTotal = 0;
		for (int i = 0; i < lineList.size(); i++) {
			int count = 0;
			String[] wordArray = lineList.get(i).split(" ");
			for (String word : wordArray) {
				if (searchWord.equals(word)) {
					count++;
					countTotal++;
				}
			}
			if (count > 0) {
				linesAppeared.add(i + 1);
				timesAppeared.add(count);
			}
		}
		System.out.println("The word " + searchWord + " appeared " + countTotal + " times in the article.");
		for (int i = 0; i < linesAppeared.size(); i++) {
			System.out.println("Lines: " + linesAppeared.get(i) + "    Appearance: " + timesAppeared.get(i) + " time(s)");
		}
	}
	
}

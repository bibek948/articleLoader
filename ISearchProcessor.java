package ProgrammingWorkshopLab.MileStone3;

import java.util.List;

public interface ISearchProcessor {
	
	/**
	 * search the article for a specific word (searchWord) and output the lines that contain the word with the times the word appears on the line
	 * @param lineList
	 * @param input
	 */
	public void simpleSearch(List<String> lineList, String input);

}

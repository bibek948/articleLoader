package ProgrammingWorkshopLab.MileStone3;

import java.util.List;

public interface IArticleReader {

	/**
	 * read the file and create a list of lines in the file as Strings
	 * @param filename
	 * @return
	 */
	public List<String> readFile(String filename);
	
}

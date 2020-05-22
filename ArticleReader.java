package ProgrammingWorkshopLab.MileStone3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArticleReader implements IArticleReader {
 
	/**
	 * read the file and create a list of lines in the file as Strings
	 * @param filename
	 * @return
	 */
	public List<String> readFile(String filename) {
		
		List<String> lines = new  ArrayList<String>();
		File file = new File("C:\\Users\\RianL\\OneDrive\\Desktop\\Eclipse Workspace\\ProgrammingWorkshop\\src\\ProgrammingWorkshopLab\\MileStone3\\" + filename);
		
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String st;
			while ((st = br.readLine()) != null) {
				lines.add(st);
			}
		} catch (FileNotFoundException e) { 
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		}
		return lines;
	}
	
}
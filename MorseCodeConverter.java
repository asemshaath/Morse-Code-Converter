import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is a utility class for converting. All the methods and the fields in this class are
 *  supporting the purpose of convention
 *  
 * @author Asem Shaath
 *
 */
public class MorseCodeConverter {

	// a static object of the morse code tree
	private static MorseCodeTree tree = new MorseCodeTree();
	
	/**
	 * Empty contsructor
	 */
	public MorseCodeConverter() {}
	
	/**
	 * This method prints the elements of the tree in an inorder way
	 * 
	 * @return elements of the tree 
	 */
	public static String printTree() 
	{
		//MorseCodeTree object = new MorseCodeTree();
		ArrayList<String> treeElements = tree.toArrayList();
		String whatShouldBeReturned = ""; 
		
		for(int i = 0 ; i < treeElements.size(); i++)
		{
			whatShouldBeReturned += treeElements.get(i) + " ";
		}
		
		return whatShouldBeReturned;
	}
	
	/**
	 * This method converts the morse code to English string
	 *  
	 * @param code
	 * @return english word
	 */
	public static String convertToEnglish(String code)
	{
		
		String[] codes = code.split(" ");
		String englishText = "";  
		
		for(int i = 0; i < codes.length; i++)
		{
			if(codes[i].equals("/"))
				englishText += " ";
			else
				englishText += tree.fetch(codes[i]);
		}
		
		return englishText;
	}
	
	/**
	 * 
	 * This method converts the morse code to English string that is scanned from any .txt file
	 * 
	 * @param codeFile, the file object
	 * @return the english text
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException
	{
		
		Scanner scanFile = new Scanner(codeFile);
		String theWholeCode = null; 
		
		while(scanFile.hasNextLine())
		{
			theWholeCode = scanFile.nextLine();;
		}
		
		return convertToEnglish(theWholeCode);
	}
	
}


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Morse code converter class that converts an english string into
 * 
 * @author krono
 *
 */
public class MorseCodeConverter {

	static MorseCodeTree tree = new MorseCodeTree();

	/**
	 * returns a string with all the data in the tree in LNR order with an space in
	 * between them
	 * 
	 * @return the data in the tree in LNR order separated by a space.
	 */
	public static String printTree() {
		ArrayList<String> list = tree.toArrayList();
		String print = "";

		for (int i = 0; i < list.size(); i++) {
			print += list.get(i);
			if (i < list.size() - 1) {
				print += " ";
			}
		}
		return print;
	}

	/**
	 * Converts a file of Morse code into English Each letter is delimited by a
	 * space
	 * 
	 * @param code the morse code
	 * @return the English translation
	 */
	public static String convertToEnglish(String code) {
		String result = "";
		MorseCodeTree morseCode = new MorseCodeTree();
		String[] codeArray = code.split(" ");
		for (String s : codeArray) {
			if (s.equals("/")) {
				result += " ";
			} else {
				result += morseCode.fetch(s);
			}
		}
		return result;

	}

	/**
	 * Converts a file of Morse code into English Each letter is delimited by a
	 * space
	 * 
	 * @param codeFile
	 * @return
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		String line, output = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(codeFile));
			int lineCounter = 0;
			while ((line = reader.readLine()) != null) {
				lineCounter++;
				if (lineCounter > 1) {
					output += "\n" + convertToEnglish(line);
				} else {
					output = convertToEnglish(line);
				}
			}
			reader.close();
		} catch (Exception e) {

		}
		return output;

	}
}

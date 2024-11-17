
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

public class MorseCodeConverterTestPublic {

	@Test
	public void testConvertToEnglishString() {
		String converter1 = MorseCodeConverter.convertToEnglish(".... . .-.. .-.. --- / .-- --- .-. .-.. -.. ");
		assertEquals("hello world", converter1);
	}

	/**
	 * Testing for correct implementation of tree and traversal
	 */

	@Test
	public void testPrintTree() {

		assertEquals("h s v i f u e l r a p w j  b d x n c k y t z g q m o", MorseCodeConverter.printTree());
	}

	/**
	 * Testing for correct conversion of all characters using key phrase to hit all
	 * letters
	 */

	@Test
	public void testConvertMorseStringToEnglishString() {

		String converter1 = MorseCodeConverter.convertToEnglish(
				"- .... . / --.- ..- .. -.-. -.- / -... .-. --- .-- -. / ..-. --- -..- / .--- ..- -- .--. ... / --- ...- . .-. / - .... . / .-.. .- --.. -.-- / -.. --- --.");
		assertEquals("the quick brown fox jumps over the lazy dog", converter1);

	}

	@Test
	public void testConvertMorseFileToEnglishString() {

		/*
		 * Make sure howDoILoveThee.txt is in the src directory for this test to pass
		 */
		File file = new File("src/howDoILoveThee.txt");
		try {
			assertEquals("how do i love thee let me count the ways", MorseCodeConverter.convertToEnglish(file));
		} catch (FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", false);
		}
	}

//assigned tests from document
	@Test
	public void assignedTestmorseCodeConverterConvertToEnglish() {

		String testConverter = MorseCodeConverter.convertToEnglish(
				"- .... .. ... / -.-. .-.. .- ... ... / .. ... / .-. . .- .-.. .-.. -.-- / .... .- .-. -..");
		assertEquals("this class is really hard", testConverter);
	}

	@Test
	public void assignedTestConvertMorseFileToEnglishString() {

		File file = new File("src/this is hard.txt");
		try {
			assertEquals("this class is really hard", MorseCodeConverter.convertToEnglish(file));
		} catch (FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", false);
		}
	}

}

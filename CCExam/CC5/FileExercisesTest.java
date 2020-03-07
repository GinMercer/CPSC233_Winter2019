import static org.junit.Assert.*;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

import org.junit.Test;

public class FileExercisesTest {
	private String getRandomFilename() {
		return "test" + (new Random()).nextInt(100000);
	}
		
	private String createFile(String text){
		String filename = getRandomFilename() + ".txt";
		try {
			PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
			output.print(text);
			output.close();
		} catch (IOException ioe) {
			fail("Unable to set up test environment, tried to (re)create file " + filename);
		}
		return filename;
	}
	
	private String createFile(boolean[] bools){
		String filename = getRandomFilename() + ".bin";
		try {
			DataOutputStream out = new DataOutputStream(new FileOutputStream(filename));
			out.writeInt(bools.length);
			for (int counter = 0; counter < bools.length; counter++) {
				out.writeBoolean(bools[counter]);
			}
			out.close();		
		} catch (IOException ioe) {
			fail("Unable to set up test environment, tried to create file " + filename);
		}
		return filename;
	}

	//Test with valid files
	
	@Test
	public void test_getLetters_MultipleWordsAndLines() {
		FileExercises fl = new FileExercises();
		
		String inFilename = createFile("Hello\nand\nwelcome\nTo the\nUniversity of Calgary");
		String outFilename = getRandomFilename() + ".txt";
		try {
			fl.getLetters(inFilename, outFilename);
		} catch (FileNotFoundException fnfe) {
			fail("File exists, did not expect FileNotFoundException: " + fnfe.getMessage());
		}
		
		String expected = "hawttuoc";
		
		//Read from the output file
		try {
			//Initialize scanner
			Scanner scan = new Scanner(new FileInputStream(outFilename));

			if (scan.hasNext()){
				//Read the first line in the file
				String line = scan.nextLine();
				assertEquals("Strings don't match.", expected, line);
			} else {
				//If there is nothing in the file, then the test fails
				fail("The output file is empty.");
			}
			scan.close();
		} catch (FileNotFoundException fnfe){
			//If cannot open output file, then test fails
			fail("Cannot open the output file.");
		}
		
		File f = new File(inFilename);
		f.delete();
		f = new File(outFilename);
		f.delete();
	}
	
	@Test
	public void test_getLetters_OneLine() {
		String inFilename = createFile("Hello World");
		String outFilename = getRandomFilename() + ".txt";
		FileExercises fl = new FileExercises();
		
		try {
			fl.getLetters(inFilename, outFilename);
		} catch (FileNotFoundException fnfe) {
			fail("File exists, did not expect FileNotFoundException: " + fnfe.getMessage());
		}

		//Expected output
		String expected = "hw";
		
		//Read from the output file
		try {
			//Initialize scanner
			Scanner scan = new Scanner(new FileInputStream(outFilename));

			if (scan.hasNext()){
				//Read the first line in the file
				String line = scan.nextLine();
				assertEquals("Strings don't match.", expected, line);
			} else {
				//If there is nothing in the file, then the test fails
				fail("The output file is empty.");
			}
			scan.close();
		} catch (FileNotFoundException fnfe){
			//If cannot open output file, then test fails
			fail("Cannot open the output file.");
		}
		
		File f = new File(inFilename);
		f.delete();
		f = new File(outFilename);
		f.delete();
	}

	//Test with input file name as null
	
	@Test
	public void test_getLetters_nullInputFile() {
		
		//Initialize Tutorial2
		FileExercises fl = new FileExercises();
		String outFilename = getRandomFilename() + ".txt";

		try {
			fl.getLetters(null, outFilename);
		} catch (FileNotFoundException fnfe) {
			fail("If null is provided instead of a filename, expected NullPointerException printed to output file, not FileNotFoundException thrown: " + fnfe.getMessage());
		}
		
		//Expected output
		String expected = "NullPointerException";
		
		//Read from the output file
		try {
			//Initialize scanner
			Scanner scan = new Scanner(new FileInputStream(outFilename));

			if (scan.hasNext()){
				//Read the first line in the file
				String line = scan.nextLine();
				assertEquals("Strings don't match.", expected, line);
			} else {
				//If there is nothing in the file, then the test fails
				fail("The output file is empty.");
			}
			scan.close();
		} catch (FileNotFoundException fnfe){
			//If cannot open output file, then test fails
			fail("Cannot open the output file.");
		}
		File f = new File(outFilename);
		f.delete();
	}
	
	//Test with the input file doesn't exist
	
	@Test
	public void test_getLetters_InvalidInputFileName() {
		
		//Initialize Tutorial2
		FileExercises fl = new FileExercises();

		String inFilename = getRandomFilename() + ".txt";
		String outFilename = getRandomFilename() + ".txt";
		
		File f = new File(inFilename);
		f.delete();

		try {
			fl.getLetters(inFilename, outFilename);
			fail("Called with input file that does not exist.  Expected FileNotFoundException to be thrown.");
		} catch (FileNotFoundException fnfe) {
			// test passed
		}
		f = new File(inFilename);
		f.delete();
		f = new File(outFilename);
		f.delete();
	}
	
	@Test
	public void test_count_noSixLetterWordInFile() {
		String inFilename = createFile("This is a test\nfor counting this word\nand here and there is a few tests\nand another test");
		
		//Initialize Tutorial2
		FileExercises fl = new FileExercises();
		
		// run the test
		int actual = fl.count(6, inFilename);
		
		// verify result
		assertEquals("There is no six letter word in the file", 0, actual);
		
		File f = new File(inFilename);
		f.delete();
	}
	
	@Test
	public void test_count_oneSixLetterWordInFile() {
		String inFilename = createFile("This is a test\nfor finding six letter word\nand here and there is a few tests\nand another test");
		
		//Initialize Tutorial2
		FileExercises fl = new FileExercises();
		
		// run the test
		int actual = fl.count(6, inFilename);
		
		// verify result
		assertEquals("There is one 6 letter word in the file (seeing)", 1, actual);
		
		File f = new File(inFilename);
		f.delete();
	}
	
	@Test
	public void test_count_wordManyFourLetterWordsInFile() {
		String inFilename = createFile("This is a test\nfor counting this word\nand here and there is a few tests\nand another test");

		//Initialize Tutorial2
		FileExercises fl = new FileExercises();
		
		// run the test
		int actual = fl.count(4, inFilename);
		
		// verify result
		assertEquals("There are six four letter words in the file", 6, actual);

		File f = new File(inFilename);
		f.delete();
	}
	
	@Test
	public void test_count_invalidFileName() {
		String inFilename = getRandomFilename() + ".txt";
		File f = new File(inFilename);
		f.delete();
		
		//Initialize Tutorial2
		FileExercises fl = new FileExercises();
		
		// run the test
		int actual = fl.count(4, inFilename);
		
		// verify result
		assertEquals("The file does not exist", -1, actual);

		f = new File(inFilename);
		f.delete();
	}
	
	@Test
	public void test_append_validFile() {
		String inFilename = createFile("one\n");		

		FileExercises fl = new FileExercises();
		
		// run the test
		fl.append(56.46, inFilename);
		
		//Read from the output file
		try {
			//Initialize scanner
			Scanner scan = new Scanner(new FileInputStream(inFilename));

			if (scan.hasNext()){
				//Read the first line in the file
				String line = scan.nextLine();
				assertEquals("Expected 'one' to remain on first line in file", "one", line);
			} else {
				//If there is nothing in the file, then the test fails
				fail("The output file is empty.");
			}
			
			if (scan.hasNext()){
				//Read the second line in the file
				String line = scan.nextLine();
				assertEquals("Expected '56.46' to be added to the file (as text)", "56.46", line);
			} else {
				//If there is nothing in the file, then the test fails
				fail("The output file does not have additional line.");
			}
			if (scan.hasNext()){
				fail("The file to append to had more lines than expected");
			} 
			scan.close();
		} catch (FileNotFoundException fnfe){
			//If cannot open output file, then test fails
			fail("Cannot open the output file.");
		}
		
		File f = new File(inFilename);
		f.delete();
	}	
	@Test
	public void test_append_newFile() {
		String inFilename = getRandomFilename() + ".txt";
		File f = new File(inFilename);
		f.delete();		
		
		FileExercises fl = new FileExercises();
		
		fl.append(123.456, inFilename);
		
		try {
			//Initialize scanner
			Scanner scan = new Scanner(new FileInputStream(inFilename));

			if (scan.hasNext()){
				//Read the first line in the file
				String line = scan.nextLine();
				assertEquals("Expected '123.456' to be first line in new file", "123.456", line);
			} else {
				//If there is nothing in the file, then the test fails
				fail("The output file is empty.");
			}
			
			if (scan.hasNext()){
				fail("The file to append to had more lines than expected");
			} 
			scan.close();
			
		} catch (FileNotFoundException fnfe){
			//If cannot open output file, then test fails
			fail("Cannot open the output file.");
		}
		
		f = new File(inFilename);
		f.delete();
	}	
	
	@Test
	public void test_countTrues_invalidFileName() {
		String inFilename = getRandomFilename() + ".bin";
		File f = new File(inFilename);
		f.delete();		
				
		FileExercises fl = new FileExercises();

		try {
			int actual = fl.countTrues(inFilename);
			assertEquals("The file invalid.bin does not exist", -1, actual);
		} catch (IOException ioe) {
			fail("Only IOException should be due to first entry with value 0.  In this case file does not exist: " + ioe.getMessage());
		} finally {
			f = new File(inFilename);
			f.delete();					
		}
	}
	
	@Test
	public void test_countTrues_oneTrueInFile() {
		boolean[] nums = {true};
		String inFilename = createFile(nums);
		
		FileExercises fl = new FileExercises();
		try {
			int actual = fl.countTrues(inFilename);
			assertEquals("The file contains one boolean: true", 1, actual);
		} catch (IOException ioe) {
			fail("Unexpected IOException, provided file with one boolean: " + ioe.getMessage());
		} finally {
			File f = new File(inFilename);
			f.delete();					
		}
	}
	
	@Test
	public void test_countTrues_oneFalseInFile() {
		boolean[] nums = {false};
		String inFilename = createFile(nums);
		
		FileExercises fl = new FileExercises();
		try {
			int actual = fl.countTrues(inFilename);
			assertEquals("The file contains one boolean: false", 0, actual);
		} catch (IOException ioe) {
			fail("Unexpected IOException, provided file with one boolean: " + ioe.getMessage());
		} finally {
			File f = new File(inFilename);
			f.delete();					
		}
	}
	
	@Test
	public void test_countTrues_manyBooleansInFile() {
		boolean[] nums = {true,true,false,false,true,false, true,true,false,true};
		String inFilename = createFile(nums);
		
		FileExercises fl = new FileExercises();
		
		try {
			int actual = fl.countTrues(inFilename);
			assertEquals("The file contains one false, many true", 6, actual);
		} catch (IOException ioe) {
			fail("Unexpected IOException, provided file with many booleans: " + ioe.getMessage());
		} finally {
			File f = new File(inFilename);
			f.delete();					
		}
	}
	
	@Test
	public void test_countTrues_onlyFalseInFile() {
		boolean[] nums = {false,false,false,false,false,false,false,false,false,false};
		String inFilename = createFile(nums);
		
		FileExercises fl = new FileExercises();
		
		try {
			int actual = fl.countTrues(inFilename);
			assertEquals("The file contains only false", 0, actual);
		} catch (IOException ioe) {
			fail("Unexpected IOException, provided file with many booleans: " + ioe.getMessage());
		} finally {
			File f = new File(inFilename);
			f.delete();					
		}
	}
	
	@Test
	public void test_countTrues_onlyTrueInFile() {
		boolean[] nums = {true,true,true,true,true,true,true,true,true,true};
		String inFilename = createFile(nums);
		
		FileExercises fl = new FileExercises();

		try {
			int actual = fl.countTrues(inFilename);
			assertEquals("The file contains many trues", 10, actual);
		} catch (IOException ioe) {
			fail("Unexpected IOException, provided file with many booleans: " + ioe.getMessage());
		} finally {
			File f = new File(inFilename);
			f.delete();					
		}
	}

	@Test
	public void test_countTrues_zeroBooleansInFile() {
		boolean[] nums = {};
		String inFilename = createFile(nums);
		
		FileExercises fl = new FileExercises();

		try {
			int actual = fl.countTrues(inFilename);
			fail("Provided file with 0 entries, expected IOException, instead method returned " + actual);
		} catch (IOException ioe) {
			assertEquals("Got IOException as required, but message in exception not correct.", "Unexpected number of booleans 0", ioe.getMessage());
		} finally {
			File f = new File(inFilename);
			f.delete();					
		}
	}
}

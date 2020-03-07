import java.io.*;
import java.util.*;

public class FileExercises{
	public int checkNumber(int num) throws Exception{
		if(num > 0){
			return num;
		}else{
			throw new IOException();
		}	
	}
	
	public void append(String text, String filename){
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
			writer.append(text);
			writer.close();
		}catch (IOException e){
					// do nothing according to question
		}
	}
	
	public void getLetters (String inputFileName, String outputFileName){
		try{
			BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));

			String line = null;
			String[] arr;
			String firstLetter;
			String capitalLetters = "";
			
			while ((line = reader.readLine()) != null){
						// this will split the complete 'line' into array of words based on space
				arr = line.split(" ");
				for ( String word : arr){
							// find the first letter of every word
					firstLetter = word.substring(0, 1);

							// this will convert the letter to upper case
					capitalLetters += firstLetter.toUpperCase();
				}
			}
			writer.write(capitalLetters);
					// Always close files.
			reader.close();
			writer.close();
		}catch (IOException e){
			e.printStackTrace();
		}	
	}

	
	public int count(String word, String filename){
		try{
			BufferedReader reader = new BufferedReader(new FileReader(filename));

			int c = 0;
			String line = null;
			String[] arr;

			while ((line = reader.readLine()) != null){
				arr = line.split(" ");
				for ( String a : arr){
					if (word.equals(a)){
						c++;
					}
				}
			}
			reader.close();
			return c;
		}catch (IOException e){
			return -1;
		}	
	}
	
	public double sumNumbers(String inputFilename){
		try{
			BufferedReader reader = new BufferedReader(new FileReader(inputFilename));

			String line = null;
			double sum = 0;
			double number;
			line = reader.readLine();
			int n = Integer.parseInt(line);
			for(int i = 0 ; i < n ; i++){
				line = reader.readLine();
				number = Double.parseDouble(line);
				sum += number;
			}
			return sum;
		}catch (IOException e){
			return -1.0;
		}
	}
}
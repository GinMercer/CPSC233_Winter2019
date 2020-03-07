import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.*;

public class FileExercises {
	public void append(double num, String filename){
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
			String n = String.valueOf(num);	
			writer.append(n);
			writer.close();
		}catch(Exception e){

		}
	}
	
	public void getLetters(String inputFileName, String outputFileName)throws FileNotFoundException{
		try{
			BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
			
			String line = null;
			String[] arr;
			String firstLetter;
			String capitalLetters = "";
			
			while ((line = reader.readLine()) != null){
				arr = line.split(" ");
				for ( String word : arr){
					firstLetter = word.substring(0, 1);
					capitalLetters += firstLetter.toLowerCase();
				}
			}
			writer.write(capitalLetters);
			reader.close();
			writer.close();
		}catch (IOException e) {
			e.printStackTrace();

		}
	}
	
	public int count(int length, String filename){
		try{
			BufferedReader reader = new BufferedReader(new FileReader(filename));

			int c = 0;
			String line = null;
			String[] arr;

			while ((line = reader.readLine()) != null){
				arr = line.split(" ");
				for ( String a : arr){
					if (length == a.length()){
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
	
	public int countTrues(String inputFilename)throws IOException{
		try {
			BufferedReader reader = new BufferedReader(new FileReader(inputFilename));
			
			String line = null;
			int count = 0;
			
			line = reader.readLine();
			line.trim();
			int n = Integer.parseInt(line);//读第一个数并转成int
			
			for(int i = 0; i < n ; i++){
				line = reader.readLine();
				if(line == "true")
					count++;
			}
			return count;
		} catch (IOException e) {
			return -1;
		}
	}
}
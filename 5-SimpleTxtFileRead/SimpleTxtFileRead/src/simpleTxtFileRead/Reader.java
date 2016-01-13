package simpleTxtFileRead;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Reader {
	
	private ArrayList<Student> students = new ArrayList<>();
	
	public Reader(){}
	
	public ArrayList<Student> readFromTxtFile(String path){
		Scanner s = null;
		try {
			s = new Scanner(new BufferedReader(new FileReader(path)));
			while(s.hasNextLine()){
				String line = s.nextLine();
				if (new StringTokenizer(line,",").countTokens()==2)
					students.add(createStudentFromTxtLines(line, 0));
				else
					students.add(createStudentFromTxtLines(line, 1));	
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found !");
		} catch (NumberFormatException e) {
			System.out.println("Grade must be an integer !");
		} finally { if(s != null) s.close();}
		
		return students;
	}	
		
	private Student createStudentFromTxtLines(String line, int type){
		StringTokenizer st = new StringTokenizer(line,",");
		String name = st.nextToken();
		String am = st.nextToken().trim();
		int amNum = Integer.parseInt(am);		
		if (type==0)
			return new Student(name, amNum);		
		else {
			String numberOfTitles = st.nextToken();
			numberOfTitles = numberOfTitles.trim();
			int numberOfTitlesNum = Integer.parseInt(numberOfTitles);
			return new Student(name, amNum ,numberOfTitlesNum);			
		}
	}	
}

package thema2;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Reader {
	
	private ArrayList<Course> courses = new ArrayList<>();
	
	public Reader(){}

	/**
	 * H methodos auth dexetai ena String path kai epistrefei mia ArrayList me courses.
	 * Xrhsimopoieitai apo to ApplicationFrame gia thn fortwsh ths ArrayList<Course> courses.
	 * H xrhsh ths einai profanh, xrhsimopoiei to path tou arxeiou .txt pou erxetai san parametros
	 * dhmiourgei ena FileReader-BufferedReader-Scanner kai sarwnei kathe grammh tou.
	 * Kathe grammh pou efere to scanner (String), th stelnei sthn parakatw methodo createCourseFromTxtLines
	 * h opoia einai ypeuthini na xwrisei th grammh se onoma mathimatos, vathmo kai Y/E, na kataskeuasei kai na epistrepsei ena Course object.
	 * Sth synexeia to Course object prostithetai se mia ArrayList me Courses kai otan to arxeio .txt ftasei sto telos tou (den exei epomenh grammh),
	 * h methodos oloklhrwnetai epistrefontas (return) thn ArrayList courses pou gemise me antikeimena Course apo to arxeio .txt.
	 * 
	 * @param String path
	 * @return ArrayList<Course> courses
	 */
	public ArrayList<Course> readFromTxtFile(String path){
		// here is going to read the data from the txt file, create the Course objects and fill an ArrayList with these Course objects.
		Scanner s = null;
		try {
			s = new Scanner(new BufferedReader(new FileReader(path)));
			while(s.hasNextLine()){
				String line = s.nextLine();
				courses.add(createCourseFromTxtLines(line));
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found !");
		} catch (NumberFormatException e) {
			System.out.println("Grade must be an integer !");
		} finally { if(s != null) s.close();}
		
		return courses;
	}
	
	/**
	 * H methodos auth xrhsimopoieitai eswterika apo auth th klash (private).
	 * Kaleitai apo thn parapanw methodo readFromTxtFile.
	 * Dexetai san parametro ena String (to opoio einai mia grammh tou txt file).
	 * H grammh tha einai ths morfhs px: "Diktya H/Y, 6, Y"
	 * Giauto to logo xrhsimopoiei StringTokenizer gia na parei gia kathe mathima:
	 * - to onoma = "Diktya H/Y"
	 * - to vathmo = 6 (to metatrepei apo string se int)
	 * - to eidos tou mathimatos = Y (to metatrepei apo string se char)
	 * Ksexwrizei autes ths 3 times apo to line, kataskeuazei ena new object Course 
	 * kai to epistrefei (return).
	 * 
	 * @param String line
	 * @return new Course 
	 */
	private Course createCourseFromTxtLines(String line){
		StringTokenizer st = new StringTokenizer(line,",");
		String name = st.nextToken();
		String grade = st.nextToken();
		grade = grade.trim(); //Returns a copy of the string, with leading and trailing whitespace omitted.
		int gradeNum = Integer.parseInt(grade);
		char kind = (st.nextToken()).trim().charAt(0);		
		return new Course(name, gradeNum, kind);		
	}	
}

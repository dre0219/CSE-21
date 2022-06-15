import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Match {
	
	private static Student[] students = new Student[100];
	private static int numStudents = 0;
	
	private static void makeStudent(String studentInfo, int index) {
		Scanner inSS = new Scanner(studentInfo);
		inSS.useDelimiter("\t");
		
		String name      = inSS.next();
		char gender      = inSS.next().charAt(0);
		String birthdate = inSS.next();
		int quietTime    = inSS.nextInt();
		int music        = inSS.nextInt();
		int reading      = inSS.nextInt();
		int chatting     = inSS.nextInt();
		
		Scanner ugh = new Scanner(birthdate);
		ugh.useDelimiter("-");
		int month = ugh.nextInt();
		int day = ugh.nextInt();
		int year = ugh.nextInt();
		
		
		Preference p = new Preference(quietTime, music, reading, chatting);
		Date d = new Date(year, month, day);
		
		students[index] = new Student(name, gender, d, p);
		numStudents++;
		
		ugh.close();
		inSS.close();
	}
	
	private static void compareStudents() {
		for(int i = 0; i < numStudents; i++) {
			
			int maxScore = 0;
			int bestMatchIndex = -1;
			if(students[i].getMatched() == true) continue;
			
			for(int j = 0; j < numStudents; j++) {
				if(i == j) continue;
				if(students[j].getMatched() == true) continue;
				int currentScore = students[i].compare(students[j]);
				
				if(currentScore > maxScore) {
					maxScore = currentScore;
					bestMatchIndex = j;
				}
				
			}
			if(bestMatchIndex != -1) {
				students[i].setMatched(true);
				students[bestMatchIndex].setMatched(true);
				System.out.print(students[i].getName() + " matches with " + students[bestMatchIndex].getName());
				System.out.println(" with a score of " + maxScore);
			}
			
			else System.out.println(students[i].getName() + " has no matches.");
			
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		
		FileInputStream fileByteStream = new FileInputStream("FullRoster.txt");
		Scanner inFS = new Scanner(fileByteStream);
		
		for(int i = 0; i < students.length; i++) {
			String studentInfo = inFS.nextLine();
			makeStudent(studentInfo, i);
			if(!inFS.hasNextLine()) break;
		}
		
		compareStudents();
		
		inFS.close();
	}
}

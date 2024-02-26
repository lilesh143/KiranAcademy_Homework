package Assignments.Task;

public class gradeCalculator {
	
	public String findGrade(int Score) {
		if(Score < 0 || Score > 100) {
			return "Please enter valid score";
		}else if(Score >= 90) {
			return "The grade is A";
		}else if(Score >= 80 && Score <=89) {
			return "The grade is B";
		}else if(Score >= 70 && Score <=79) {
			return "The grade is C";
		}else if(Score >= 60 && Score <=699) {
			return "The grade is D";
		}else {
			return "The grade is F";
		}
	}
	
	public static void main(String[] args) {
		
		gradeCalculator G = new gradeCalculator();
		String ans = G.findGrade(99);
		
		System.out.println(ans);
		
	}
}

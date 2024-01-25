package HW3.division;

import HW3.additions.add;
import HW3.subtractions.subtract;

public class divide {
	public double div() {
		add a = new add();
		int ans1 = a.sum(20,  30);
		
		subtract s = new subtract();
		int ans2 = s.sub(8);
		
		double answer = ans1 / ans2;
		return answer;
	}
}

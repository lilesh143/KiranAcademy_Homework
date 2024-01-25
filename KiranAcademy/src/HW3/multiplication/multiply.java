package HW3.multiplication;

import HW3.additions.add;
import HW3.subtractions.subtract;

public class multiply {
	public double multi() {
		add a = new add();
		int ans1 = a.sum(20, 30);
		
		subtract s = new subtract();
		int ans2 = s.sub(8);
		
		double answer = ans1*ans2;
		return answer;
	}
}

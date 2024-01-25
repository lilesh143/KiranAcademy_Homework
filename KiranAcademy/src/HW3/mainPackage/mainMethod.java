package HW3.mainPackage;

import HW3.additions.add;
import HW3.division.divide;
import HW3.multiplication.multiply;
import HW3.subtractions.subtract;

public class mainMethod {
	public static void main(String[] args) {
		add a = new add();
		int ans1 = a.sum(20, 30);
		System.out.println(ans1);
		
		subtract s = new subtract();
		int ans2 = s.sub(8);
		System.out.println(ans2);
		
		multiply m = new multiply();
		double ans3 = m.multi();
		System.out.println(ans3);
		
		divide d = new divide();
		double ans4 = d.div();
		System.out.println(ans4);
	}
}

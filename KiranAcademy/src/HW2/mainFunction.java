package HW2;

public class mainFunction {
	public static void main(String[] args) {
		sum s1 = new sum();
		int ans1 = s1.add(10, 20);
		System.out.println(ans1);
		
		subtract s2 = new subtract();
		int ans2 = s2.sub(6);
		System.out.println(ans2);
		
		multiply m = new multiply();
		double ans3 = m.multi(3);
		System.out.println(ans3);
		
		greater g = new greater();
		int ans4 = g.great(2432, 2422);
		System.out.println(ans4);
		
	}
}

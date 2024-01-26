package HW1;

public class oneClass {
	
	int sum(int a, int b) {
		int ans1 = a + b;
		return ans1;
	}
	
	int sub(int a, int b) {
		int ans2 = a-b;
		return ans2;
	}
	
	int multiply(int a, int b) {
		int ans3 = a*b;
		return ans3;
	}
	
	float areaOfCircle(float r) {
		float pi = 3.14f;
		float ans4 = pi * r * r;
		return ans4;
	}
	
	public static void main(String[] args) {
		oneClass s = new oneClass();
		int answer1 = s.sum(9, 33);
		System.out.println(answer1);
		
		int answer2 =s.sub(9, 33);
		System.out.println(answer2);
		
		int answer3 =s.multiply(9, 33);
		System.out.println(answer3);

		float answer4 =s.areaOfCircle(2.6f);
		System.out.println(answer4);

		


	}
}

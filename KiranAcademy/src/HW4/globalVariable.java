package HW4;


public class globalVariable {
	// global variable
	int a = 9;
	int b = 33;

	int sum() {
		int ans1 = a + b;
		return ans1;
	}
	
	int sub() {
		int ans2 = a-b;
		return ans2;
	}
	
	int multiply() {
		int ans3 = a*b;
		return ans3;
	}
	
	float areaOfCircle(float r) {
		float pi = 3.14f;
		float ans4 = pi * r * r;
		return ans4;
	}
	
	public static void main(String[] args) {
		globalVariable s = new globalVariable();
		
		int answer1 = s.sum();
		System.out.println(answer1);
		
		int answer2 =s.sub();
		System.out.println(answer2);
		
		int answer3 =s.multiply();
		System.out.println(answer3);

		float answer4 =s.areaOfCircle(2.6f);
		System.out.println(answer4);

	}


}

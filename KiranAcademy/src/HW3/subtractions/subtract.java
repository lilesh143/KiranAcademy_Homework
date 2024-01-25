package HW3.subtractions;

import HW3.additions.add;

public class subtract {
	public int sub(int c) {
		add a = new add();
		int total = a.sum(20, 30);
		int ans2 = total - c;
		return ans2;
	}
}

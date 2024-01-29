package Assignments.Task;

public class InventoryItem {
	
	static int totalItems = 0;
		
	void addToInventory(int quantity, String itemName) {
		totalItems += quantity;
		System.out.println(quantity + " " + itemName + " added");
	}
	
	void removeFromInventory(int quantity, String itemName) {
		totalItems -= quantity;
		System.out.println(quantity + " " + itemName + " removed");
	}
	
	static int getTotalItems(int totalItems) {
		return totalItems;
	}
	
		
	public static void main(String[] args) {
		InventoryItem I = new InventoryItem();
		
		I.addToInventory(5, "pen");
		I.addToInventory(5, "pencil");
		
		I.removeFromInventory(4, "pencil");
		
		int ans = getTotalItems(totalItems);
		System.out.println("total items = " + ans);
		
		
	}
}

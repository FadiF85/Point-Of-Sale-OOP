import java.util.ArrayList;

public class Inventory {
	
	//variables
	private ArrayList<Product> inventory;
	private static boolean found = false;
	private final double TAX_RATE = 0.13;
	
	
	//create constructor
	public Inventory() {
		this.inventory = new ArrayList<Product>();
	}
	
	//create getters and setters
	public static boolean isFound() {
		return found;
	}
	
	
	//create a method to add items to Inventory
	public void addToInventory(Product product) {
		this.inventory.add(product);
	}
	
	
	//create a method to add items to Inventory
	public void removeFromInvetory(Product product) {
		this.inventory.remove(product);
	}
	
	//create a method to display the content of the inventory
	public void displayInventory() {
		for(int i = 0; i < this.inventory.size(); i++) {
			this.inventory.get(i).printProduct();
		}
	}
	
	//create a method to get the size of inventory objects
	public int getSize() {
		return this.inventory.size();
	}
	
	//create a method to access elements of inventory objects by giving their serial numbers
	public Product getProduct(String serialNumber) {
		Product product = null;
		for(int i = 0; i < this.inventory.size(); i++) {
			if (this.inventory.get(i).getSerialNumber().equals(serialNumber)) {
				product = this.inventory.get(i);
			}
		}
		return product; 
	}
	
//	//create a method to access elements of inventory objects by giving their index number
//	public Product getProductByIndex(int index) {
//		Product product = this.inventory.get(index)
//		
//
//		return product; 
//	}
	
	//create a method to find a product
	public void findProduct(String serialNumber) {
		found = false;
		int counter = 0;
		String productNumber = "";
		int quantity = 0;

		do {
			if(this.inventory.get(counter).getSerialNumber().equals(serialNumber)) {
				this.inventory.get(counter).printProduct();
				productNumber = this.inventory.get(counter).getUpc();
				found = true;
			} 
			counter++;
		} while (found == false && counter < this.inventory.size());
		
		if (found == false) {
			System.out.println("This product does not exist!\n");
		}
		
		for(int i = 0; i < this.inventory.size(); i++) {
			if (this.inventory.get(i).getUpc().equals(productNumber)) {
				quantity++;
			}
		}
		if (quantity > 0) {
			System.out.println("Quantity of the scanned item: " + quantity + " unit(s)\n");
		}
	}
	
	//create a method to add an item to the shopping cart and remove it from the inventory
	public void addToShoppingCart(String serialNumber) {
		for(int i = 0; i < this.inventory.size(); i++) {
			if (this.inventory.get(i).getSerialNumber().equals(serialNumber)) {

			}
	}
	}
	
	//create a method to print the receipt
	public void printReceipt() {
		double subTotal = 0;
//		double hst = subTotal * TAX_RATE;
//		double total = subTotal + hst;
		
		for(int i = 0; i < this.inventory.size(); i++) {
			subTotal += this.inventory.get(i).getPrice();
			System.out.println("    " + this.inventory.get(i).getSerialNumber() 
							 + "           " + ((Bike) this.inventory.get(i)).getBrand()
							 + "           " + this.inventory.get(i).getPrice());
		}
		
		System.out.println("===================================================\n");
		System.out.printf("Your sub-total %.2f$", subTotal);
		System.out.printf("\nYour HST: %.2f$     ", subTotal * TAX_RATE);
		System.out.printf("\nYour total: %.2f$   ", subTotal + (subTotal * TAX_RATE));
	}

}

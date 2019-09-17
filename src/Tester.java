import java.util.Scanner;

public class Tester {
	
	//variables
	static Inventory bikesInventory;
	static Inventory shoppingCart;
	static String serialNumber;
	static boolean buyMore = true;
	static int menuOption;

	public static void main(String[] args) {
		//public Bike(double price, String serialNumber, String brand, String type, String colour)
		Bike bike1 = new Bike(150.5, "123456", "300", "GT Bikes", "Road Bike", "Silver");
		Bike bike2 = new Bike(200, "123457", "301", "GT Bikes", "Road Bike", "Yellow");
		Bike bike3 = new Bike(150.5, "123458", "302", "GT Bikes", "Track bike", "Red");
		Bike bike4 = new Bike(200, "123459", "303", "GT Bikes", "Kids bike", "White");
		Bike bike5 = new Bike(150.5, "123452", "304", "GT Bikes", "Folding bike", "Green");
		Bike bike6 = new Bike(200, "123455", "301", "GT Bikes", "Road Bike", "Yellow");
		
		//create an inventory
		bikesInventory = new Inventory();
		shoppingCart = new Inventory();
		
		//add bikes to inventory
		bikesInventory.addToInventory(bike1);
		bikesInventory.addToInventory(bike2);
		bikesInventory.addToInventory(bike3);
		bikesInventory.addToInventory(bike4);
		bikesInventory.addToInventory(bike5);
		bikesInventory.addToInventory(bike6);
		//bikesInventory.displayInventory();
		
		//create a Scanner
		Scanner inputSerialNumber = new Scanner(System.in);
		Scanner input = new Scanner(System.in);
				
		do {
			System.out.println("Enter serial number please!...");
			serialNumber = inputSerialNumber.nextLine();
			
			
			//display the scanned product
			bikesInventory.findProduct(serialNumber);
			
			if (Inventory.isFound() == true) {
				
				System.out.println("What would you like to do with this product?\n" 
						 + "1) Add to shopping cart\n" 
						 + "2) Discard it and keep shopping\n");
		
				menuOption = input.nextInt();
				switch (menuOption) {
				case 1:
					addToShoppingCart(serialNumber);
					System.out.println("Item has been added to shopping cart..\n"
									+  "What would you like to do?\n"
									+  "1) Continue shopping\n" 
									+  "2) Proceed to check out and print receipt");
					int subMenuOption = input.nextInt();
					if (subMenuOption == 1) {
						buyMore = true;
					}
					else {
						//print receipt
						System.out.println("================== Your receipt ===================\n"
										+  "serial number  |     category     |    price ($)  \n"
										+  "===================================================\n");
						shoppingCart.printReceipt();
						buyMore = false;
					}
					break;
					
				case 2:
					buyMore = true;
					break;
				}
			}
			
			else {
				System.out.println("Choose what you would like to do: \n"
								+  "1) Press '1' to continue shopping by trying a valid serial number\n"
								+  "2) Press '2' to exit the program");
				int subMenuOption2 = input.nextInt();
				if (subMenuOption2 == 1) {
					buyMore = true;
				}
				
				else {
					System.out.println("Thank you for using the program and have a good day!");
					System.exit(1);
				}
			}

		} while (buyMore == true);
		
		input.close();
	}
	
	//create a method to remove an item from inventory and add to shopping cart
	public static void addToShoppingCart(String serialNumber) {
		Product purchasedProduct = null;
		for(int i = 0; i < bikesInventory.getSize(); i++) {
			if ((bikesInventory.getProduct(serialNumber)).getSerialNumber().equals(serialNumber)) {
				purchasedProduct = (bikesInventory.getProduct(serialNumber));
				bikesInventory.removeFromInvetory(bikesInventory.getProduct(serialNumber));
				shoppingCart.addToInventory(purchasedProduct);
				break;
			}
		}
	}
	
}

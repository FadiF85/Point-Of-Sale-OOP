
public class Bike extends Product {
	
	//declare Bike's class variables
	private String brand;
	private String type;
	private String colour;

	
	//create a Bike's class constructor 
	public Bike(double price, String serialNumber, String upc, String brand, String type, String colour) {
		super(price, serialNumber, upc);
		this.brand = brand;
		this.type = type;
		this.colour = colour;
	}


	//generate getters and setters 
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}


	@Override
	public void printProduct() {
		System.out.println("Category: Bikes\n"
						 + "Serial number: " + this.getSerialNumber() + "\n"
						 + "Price: " + this.getPrice() + "$\n"
						 + "Brand: " + this.getBrand() + "\n"
						 + "Type: " + this.getType() + "\n" 
						 + "Colour: " + this.getColour() + "\n");
	}
	

}

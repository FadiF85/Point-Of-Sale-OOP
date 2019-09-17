import java.util.Date;

public abstract class Product {
	
	//declare variables
	private double price;
	private String serialNumber;
	private String upc;
	
	//create constructor
	public Product(double price, String serialNumber, String upc) {
		this.price = price;
		this.serialNumber = serialNumber;
		this.upc = upc;
	}
	
	
	//generate setters and getters
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getUpc() {
		return upc;
	}
	public void setUpc(String upc) {
		this.upc = upc;
	}


	public abstract void printProduct();
	
}

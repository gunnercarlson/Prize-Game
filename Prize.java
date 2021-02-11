/*
 * Written by Gunner Carlson
 */
public class Prize {
	//Instance variables
	private String name;
	private int price;
	
	//Constructors
	public Prize() {
		name = null;
		price = 0;
	}
	public Prize(String xName, int xPrice) {
		this.setName(xName);
		this.setPrice(xPrice);
	}
	
	//Accessors and mutators
	public String getName() {
		return this.name;
	}
	public int getPrice() {
		return this.price;
	}
	public void setName(String xName) {
		this.name = xName;
	}
	public void setPrice(int xPrice) {
		if (xPrice > 0)
			this.price = xPrice;
		else
			System.out.println("Invalid price input!");
		
	}
	public String toString() {
		return this.name;
	}
}
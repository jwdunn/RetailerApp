package com.BeerDropper.www;
/**
 * Class representing the details of the ordered items
 * @author gasparobimba
 *
 */
public class ItemsOrdered {
	
	private String item_name;
	int quantity;
	private double UnitPrice;

	public ItemsOrdered(String product_name, int quantity, double UnitPrice) {
		//super();
		this.item_name = product_name;
		this.quantity = quantity;
		this.UnitPrice = UnitPrice;
	
	}

	public String getProductName() {
		return item_name;
	}

	public void setProductName(String product_name) {
		this.item_name = product_name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotal(){
		return getQuantity()*UnitPrice;
	}

	public String toString(){
		return this.quantity+" of "+this.getProductName()+"\t$"+UnitPrice+"\n";
	}
	
	
}

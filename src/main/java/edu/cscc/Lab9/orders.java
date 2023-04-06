package edu.cscc.Lab9;

public class orders {
	public int id;
	public String firstName;
	public String lastName;
	public int quantity;
	public double price;
	
	public orders(int id, String firstName, String lastName, int quantity, double price) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.quantity = quantity;
		this.price = price;
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}

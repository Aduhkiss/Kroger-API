package me.atticuszambrana.kroger.entities.products;

public class Product {
	private String upc; // the item's UPC number
	private String number; // which aisle the item is in
	private String brand; // the item brand
	private String description; // The Item name
	
	private String indicator; // is the item refrigerated?
	private boolean heatSensitive; // self explainitory
	
	public Product(String upc, String number, String brand, String description,
			String indicator, boolean heatSensitive) {
		this.upc = upc;
		this.number = number;
		this.brand = brand;
		this.description = description;
		this.indicator = indicator;
		this.heatSensitive = heatSensitive;
	}
	
	public String getUPC() {
		return upc;
	}
	
	public String getAisleNumber() {
		return number;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public String getName() {
		return description;
	}
	
	public String getIndicator() {
		return indicator;
	}
	
	public boolean isHeatSensitive() {
		return heatSensitive;
	}
}

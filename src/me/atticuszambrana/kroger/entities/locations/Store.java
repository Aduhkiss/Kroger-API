package me.atticuszambrana.kroger.entities.locations;

public class Store {
	private String locationId; // Location ID to be used when searching for a specific store
	private String name; // the building name
	private String phone; // the building phone number
	
	// Location shit
	private String addressLine1; // the building address
	private String city;
	private String state;
	private String zipCode;
	private String county;
	
	public Store(String locationId, String name, String phone, String addressLine1, String city, String state, String zipCode, String county) {
		this.locationId = locationId;
		this.name = name;
		this.phone = phone;
		this.addressLine1 = addressLine1;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.county = county;
	}

	public String getLocationId() {
		return locationId;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return addressLine1;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getCounty() {
		return county;
	}
}

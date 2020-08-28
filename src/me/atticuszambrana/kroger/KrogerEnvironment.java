package me.atticuszambrana.kroger;

public enum KrogerEnvironment {
	
	Production("https://api.kroger.com/v1/"),
	Certification("https://api-ce.kroger.com/v1/");
	
	private String serverAddress;
	
	KrogerEnvironment(String serverAddress) {
		this.serverAddress = serverAddress;
	}
	
	public String getServerAddress() {
		return serverAddress;
	}
}

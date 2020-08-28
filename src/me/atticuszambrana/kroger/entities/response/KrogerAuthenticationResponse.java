package me.atticuszambrana.kroger.entities.response;

public class KrogerAuthenticationResponse {
	
	private int expires_in;
	private String access_token;
	private String token_type;
	
	public KrogerAuthenticationResponse(int expires_in, String access_token, String token_type) {
		this.expires_in = expires_in;
		this.access_token = access_token;
		this.token_type = token_type;
	}
	
	public int getExpireTime() {
		return expires_in;
	}
	
	public String getAccessToken() {
		return access_token;
	}
	
	public String getTokenType() {
		return token_type;
	}
}

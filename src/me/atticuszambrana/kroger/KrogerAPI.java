package me.atticuszambrana.kroger;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

import com.google.gson.Gson;

import me.atticuszambrana.kroger.entities.KrogerAuthenticationResponse;
import me.atticuszambrana.kroger.util.EncodingUtil;
import me.atticuszambrana.kroger.util.StreamUtil;

public class KrogerAPI {
	
	private Gson gson;
	
	private KrogerEnvironment env;
	private String oneTimeAuthorization;
	private boolean isAuthenticated;
	
	private String AccessToken;
	
	public KrogerAPI(KrogerEnvironment env, String clientId, String clientSecret) {
		this.gson = new Gson();
		this.env = env;
		this.oneTimeAuthorization = Base64.getEncoder().encodeToString((clientId + ":" + clientSecret).getBytes());
	}
	
	public void authenticate() {
		try {
			URL url = new URL(env.getServerAddress() + "/connect/oauth2/token?scope=" + EncodingUtil.encodeURIComponent("product.compact"));
			URLConnection conn = url.openConnection();
			HttpURLConnection http = (HttpURLConnection) conn;
			
			http.setRequestMethod("POST");
			http.setDoOutput(true);
			Map<String,String> arguments = new HashMap<>();
			
			arguments.put("grant_type", "client_credentials");
			StringJoiner sj = new StringJoiner("&");
			for(Map.Entry<String,String> entry : arguments.entrySet())
			    sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "=" 
			         + URLEncoder.encode(entry.getValue(), "UTF-8"));
			byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			http.setRequestProperty("Authorization", "Basic " + oneTimeAuthorization);
			http.connect();
			try(OutputStream os = http.getOutputStream()) {
			    os.write(out);
			}
			
			String response = StreamUtil.convertInputStreamToString(http.getInputStream());
			KrogerAuthenticationResponse krogerResponse = gson.fromJson(response, KrogerAuthenticationResponse.class);
			
			AccessToken = krogerResponse.getAccessToken();
			isAuthenticated = true;
		} catch(IOException ex) {
			isAuthenticated = false;
		}
	}
	
	public String getProducts(String product) throws IOException {
		if(!isAuthenticated) {
			return "KrogerError|NotAuthenticated";
		}
		//System.out.println(AccessToken);
		URL url = new URL(env.getServerAddress() + "products?filter.term=" + product);
		URLConnection conn = url.openConnection();
		HttpURLConnection http = (HttpURLConnection) conn;
		http.setRequestMethod("GET");
		http.setDoOutput(true);
		http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		http.setRequestProperty("Authorization", "Bearer " + AccessToken);
		http.setRequestProperty("Cache-Control", "no-cache");
		http.connect();
		String response = StreamUtil.convertInputStreamToString(http.getInputStream());
		return response;
	}
	
	public String getStoresFromZip(String zipCode) throws IOException {
		if(!isAuthenticated) {
			return "KrogerError|NotAuthenticated";
		}
		URL url = new URL(env.getServerAddress() + "locations?filter.zipCode.near=" + zipCode);
		URLConnection conn = url.openConnection();
		HttpURLConnection http = (HttpURLConnection) conn;
		http.setRequestMethod("GET");
		http.setDoOutput(true);
		http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		http.setRequestProperty("Authorization", "Bearer " + AccessToken);
		http.setRequestProperty("Cache-Control", "no-cache");
		http.connect();
		String response = StreamUtil.convertInputStreamToString(http.getInputStream());
		return response;
	}
}

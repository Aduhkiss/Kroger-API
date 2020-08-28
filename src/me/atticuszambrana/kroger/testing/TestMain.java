package me.atticuszambrana.kroger.testing;

import java.io.IOException;

import com.google.gson.Gson;

import me.atticuszambrana.kroger.KrogerAPI;
import me.atticuszambrana.kroger.KrogerEnvironment;
import me.atticuszambrana.kroger.entities.locations.Store;
import me.atticuszambrana.kroger.entities.locations.StoreList;

public class TestMain {

	public static void main(String[] args) throws IOException {
		KrogerAPI api = new KrogerAPI(KrogerEnvironment.Production, "nah bruh", "you aint gettin this info lol");
		api.authenticate();
		// dont worry about these comments, just stuff i need to remember lol
		// 70100659
		Gson gson = new Gson();
//		ProductList list = gson.fromJson(api.getProducts("012000038488", "70100659"), ProductList.class);
//		
//		for (Product p : list.data) {
//			System.out.println(p.getName() + " - UPC: " + p.getUPC());
//		}
		
		StoreList stores = gson.fromJson(api.getStoresFromZip("98512"), StoreList.class);
		for (Store s : stores.data) {
			System.out.println(s.getName() + " - " + s.getLocationId());
		}
		
		
		//System.out.println(api.getStoresFromZip("98512"));
	}

}

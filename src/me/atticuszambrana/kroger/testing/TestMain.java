package me.atticuszambrana.kroger.testing;

import java.io.IOException;

import me.atticuszambrana.kroger.KrogerAPI;
import me.atticuszambrana.kroger.KrogerEnvironment;

public class TestMain {

	public static void main(String[] args) throws IOException {
		KrogerAPI api = new KrogerAPI(KrogerEnvironment.Production, "nah bruh", "you aint gettin this info lol");
		api.authenticate();
		// dont worry about these comments, just stuff i need to remember lol
		// 70100659
		//System.out.println(api.testProductSearch("Milk"));
		//System.out.println(api.getStoresFromZip("98512"));
	}

}

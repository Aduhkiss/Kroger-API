package me.atticuszambrana.kroger.testing;

import java.io.IOException;

import me.atticuszambrana.kroger.KrogerAPI;
import me.atticuszambrana.kroger.KrogerEnvironment;

public class TestMain {

	public static void main(String[] args) throws IOException {
		KrogerAPI api = new KrogerAPI(KrogerEnvironment.Certification, "cloudy-f3639baeb4530db03ef930eb16073f618847048699047712373", "IdsyGL2jfxU4tEih3eMkd8rUFGxGQg8mwaDx6OEB");
		api.authenticate();
		System.out.println(api.testProductSearch("Milk"));
	}

}

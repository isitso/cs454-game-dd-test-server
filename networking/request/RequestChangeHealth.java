package networking.request;

import java.io.IOException;

import networking.response.ResponseChangeHealth;
import utility.DataReader;

public class RequestChangeHealth extends GameRequest {

	private int healthChange;
	
	public RequestChangeHealth() {
		super();
	}

	@Override
	public void parse() throws IOException {
		healthChange = DataReader.readInt(dataInput);
	}

	@Override
	public void doBusiness() throws Exception {

		/*
		 * When the user damages a character, they report who the damage is
		 * being dealt to and how much. The server responds by updating all
		 * health bars involved through ResponseChangeHealth.
		 */
		if (client.getGame() == null)
			throw new Exception("Client has no game.");
		client.getPlayer().getCharacter().setHealth(client.getPlayer().getCharacter().getHealth() + healthChange);
		ResponseChangeHealth response = new ResponseChangeHealth();
		response.setData(client.getPlayer().getUsername(), healthChange);
		client.getGame().addResponseForAllClients(response);
	}
}
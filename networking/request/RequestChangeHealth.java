package networking.request;

import java.io.IOException;

import networking.response.ResponseChangeHealth;
import utility.DataReader;

public class RequestChangeHealth extends GameRequest {

	private String userName;
	private int healthChange;
	public RequestChangeHealth() {
		super();
	}

	@Override
	public void parse() throws IOException {
		userName = DataReader.readString(dataInput);
		healthChange = DataReader.readInt(dataInput);
	}

	@Override
	public void doBusiness() throws Exception {

		/*
		 * When the user damages a character, they report who the damage is
		 * being dealt to and how much. The server responds by updating all
		 * health bars involved through ResponseChangeHealth.
		 */

	}
}
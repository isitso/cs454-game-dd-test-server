package networking.request;

import java.io.IOException;

import networking.response.ResponseDead;

public class RequestDead extends GameRequest {

	// Data
	// Responses

	public RequestDead() {
		super();
	}

	@Override
	public void parse() throws IOException {

	}

	@Override
	public void doBusiness() throws Exception {

		/*
		 * The client tells the server that it’s has died and the server
		 * response to all the other users in the lobby with ResponseDead
		 */

	}
}
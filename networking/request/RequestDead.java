package networking.request;

import java.io.IOException;

import networking.response.ResponseDead;

public class RequestDead extends GameRequest {

	public RequestDead() {
		super();
	}

	@Override
	public void parse() throws IOException {
		// nothing to parse
	}

	@Override
	public void doBusiness() throws Exception {

		/*
		 * The client tells the server that it’s has died and the server
		 * response to all the other users in the lobby with ResponseDead
		 */
		if (client.getGame() == null)
			throw new Exception("Client has no game.");
		ResponseDead response = new ResponseDead();
		response.setData(client.getPlayer().getUsername());
		client.getGame().addResponseForAllClients(response);
	}
}
package networking.request;

import java.io.IOException;

import metadata.Constants;
import networking.response.ResponseReady;


public class RequestReady extends GameRequest {
	public RequestReady() {
		super();
	}

	@Override
	public void parse() throws IOException {
		// nothing to parse
	}

	@Override
	public void doBusiness() throws Exception {
		if (client.getGame() != null){
			client.setGamestate(Constants.GAMESTATE_GAME_READY);
			ResponseReady response = new ResponseReady();
			response.setData(client.getGame());
			client.getGame().addResponseForAllClients(response);
		}
	}

}
package networking.request;

import java.io.IOException;

import networking.response.ResponseSetPosition;

public class RequestSetPosition extends GameRequest {

	public RequestSetPosition() {
		super();
	}
	
	@Override
	public void parse() throws IOException {
		// nothing to parse
	}

	@Override
	public void doBusiness() throws Exception {
		if (client.getGame() != null){
			ResponseSetPosition response = new ResponseSetPosition();
			response.setData(client.getGame().getPlayers());
			client.getGame().addResponseForAllClients(response);
		}
	}

}

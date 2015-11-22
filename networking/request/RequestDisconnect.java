package networking.request;


import java.io.IOException;

import metadata.Constants;
import networking.response.ResponseRemoveUser;

public class RequestDisconnect extends GameRequest {

	// Responses
	public RequestDisconnect() {
	}

	@Override
	public void parse() throws IOException {
		// nothing to parse
	}

	@Override
	public void doBusiness() throws Exception {
		// remove me
		if (client.getGame() != null){
			// inside game
			ResponseRemoveUser response = new ResponseRemoveUser();
			response.setData(client.getPlayer().getUsername());
			client.getGame().addResponseForAllClients(response);
			client.getGame().removeClient(client.getId());
		}else if (client.getGamestate() == Constants.GAMESTATE_LOBBY){
			// inside lobby
			client.getServer().removeClientFromLobby(client.getId());
		}else {
			client.getServer().deletePlayerThreadOutOfActiveThreads(client.getId());
		}
	}
}
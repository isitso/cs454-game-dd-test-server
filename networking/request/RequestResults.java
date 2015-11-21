package networking.request;

import java.io.IOException;

import core.GameClient;
import networking.response.ResponseResults;
import utility.DataReader;

public class RequestResults extends GameRequest {

	private int gameId;
	public RequestResults() {
		super();
	}

	@Override
	public void parse() throws IOException {
		gameId = DataReader.readInt(dataInput);
	}

	@Override
	public void doBusiness() throws Exception {

		/*
		 * When the client ends the race or dies they request the results to see
		 * where the placed in the gamemode. This calls the response for the
		 * user and all of the other users who have finished the race with
		 * ResponseResults
		 */
		if (client.getGame() != null){
			for (GameClient c : client.getGame().getClients().values()){
				ResponseResults response = new ResponseResults();
				response.setData(c.getPlayer().getCharacter().getPlace(), client.getGame().getPlayers());
				c.addResponseForUpdate(response);
			}
		}
	}
}
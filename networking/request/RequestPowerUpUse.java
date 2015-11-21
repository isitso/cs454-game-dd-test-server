package networking.request;

import java.io.IOException;

import networking.response.ResponsePowerUpUse;
import utility.DataReader;

public class RequestPowerUpUse extends GameRequest {

	private int powerId;

	public RequestPowerUpUse() {
		super();
	}

	@Override
	public void parse() throws IOException {
		powerId = DataReader.readInt(dataInput);
	}

	@Override
	public void doBusiness() throws Exception {
		// test purpose. ignore validation
		if (client.getGame() != null){
			ResponsePowerUpUse response = new ResponsePowerUpUse();
			response.setData(client.getPlayer().getUsername(), powerId);
			client.getGame().addResponseForAllClients(response);
		}
	}
}
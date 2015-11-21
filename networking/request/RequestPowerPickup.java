package networking.request;

import java.io.IOException;

import networking.response.ResponsePowerUpPickUp;
import utility.DataReader;

public class RequestPowerPickup extends GameRequest {

	private int powerId;
	public RequestPowerPickup() {
		super();
	}

	@Override
	public void parse() throws IOException {
		powerId = DataReader.readInt(dataInput);
	}

	@Override
	public void doBusiness() throws Exception {
		if (client.getGame() == null)
			throw new Exception("Client has no game");
		// test purpose: ignore validation
		ResponsePowerUpPickUp response = new ResponsePowerUpPickUp();
		response.setData(client.getPlayer().getUsername(), powerId);
		responses.add(response);
	}
}
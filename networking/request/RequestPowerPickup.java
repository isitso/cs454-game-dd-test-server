package networking.request;

import java.io.IOException;

import networking.response.ResponsePowerUpPickUp;

public class RequestPowerPickup extends GameRequest {

	// Data
	// Responses

	public RequestPowerPickup() {
		super();
	}

	@Override
	public void parse() throws IOException {

	}

	@Override
	public void doBusiness() throws Exception {

		/*
		 * When the client picks up a power up. The servers adds the power-up to
		 * the car object it has in memory.
		 */

	}
}
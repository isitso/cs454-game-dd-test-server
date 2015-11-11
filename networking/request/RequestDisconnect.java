package networking.request;


import java.io.IOException;

import networking.response.ResponseDisconnect;

public class RequestDisconnect extends GameRequest {

	// Responses
	private ResponseDisconnect responseDisconnect;
	public RequestDisconnect() {
		responses.add(responseDisconnect = new ResponseDisconnect());
	}

	@Override
	public void parse() throws IOException {

	}

	@Override
	public void doBusiness() throws Exception {
		
		/*
		 * Client sends out request to disconnect. Server replies and removes
		 * user from current list also inform other clients to remove the user.
		 * Followed by creating a number of ResponseRemoveUser. All
		 * ResponseRemoveUser will be queued up into all OTHER users’ update
		 * queue
		 */
		
		//client.getServer().addResponseForAllOnlinePlayers(client.getId(), (GameResponse) responseRemoveUser); 


	}
}
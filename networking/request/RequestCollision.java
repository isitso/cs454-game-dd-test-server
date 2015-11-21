package networking.request;

import java.io.IOException;

import core.GameClient;
import networking.response.ResponseCollision;
import utility.DataReader;

public class RequestCollision extends GameRequest {
	private int playerId;
	private int damage;

	public RequestCollision() {
		super();
	}

	@Override
	public void parse() throws IOException {
		try {
			playerId = DataReader.readInt(dataInput);
			damage = DataReader.readInt(dataInput);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void doBusiness() throws Exception {

		/*
		 * The client sends the player that it hit and the damage calculated
		 * through the damage modifier to the server, and responses the damage
		 * to the user that was hit with ResponseCollision
		 * Damage=(base_damage×weight_modifier×speed
		 * modifier×inflicting_part)/(receiving_part)
		 */
		GameClient target = 
	}
}
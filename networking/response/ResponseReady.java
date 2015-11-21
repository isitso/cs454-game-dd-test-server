package networking.response;

import core.GameClient;
import core.GameMode;
import metadata.Constants;
import utility.GamePacket;

public class ResponseReady extends GameResponse {
	GameMode game;
	public ResponseReady() {
		responseCode = Constants.SMSG_READY;
	}
	
	@Override
	public byte[] constructResponseInBytes() {
		GamePacket packet = new GamePacket(responseCode);
		packet.addInt32(game.getClients().size());
		for (GameClient client : game.getClients().values()){
			packet.addString(client.getPlayer().getUsername());
			packet.addInt32((client.getGamestate() == Constants.GAMESTATE_GAME_READY) ? 1 : 0);
		}
		return packet.getBytes();
	}

	public void setData(GameMode game){
		this.game = game;
	}
}

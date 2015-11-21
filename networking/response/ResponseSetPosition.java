package networking.response;

import java.util.ArrayList;

import core.Player;
import metadata.Constants;
import utility.GamePacket;

public class ResponseSetPosition extends GameResponse {
	private ArrayList<Player> playerList = new ArrayList<Player>();
	
	public ResponseSetPosition() {
		responseCode = Constants.SMSG_SET_POSITION;
	}
	
	@Override
	public byte[] constructResponseInBytes() {
		GamePacket packet = new GamePacket(responseCode);
		packet.addInt32(playerList.size());
		for (Player p : playerList){
			packet.addString(p.getUsername());
			packet.addFloat(p.getCharacter().getX());
			packet.addFloat(p.getCharacter().getY());
			packet.addFloat(p.getCharacter().getZ());
			packet.addFloat(p.getCharacter().getH());
		}
		return packet.getBytes();
	}

	public void setData(ArrayList<Player> list){
		this.playerList = list;
	}
}

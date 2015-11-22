package networking.response;

import metadata.Constants;
import utility.GamePacket;

public class ResponseSetReady extends GameResponse {

	private String username;
	public ResponseSetReady() {
		responseCode = Constants.SMSG_SET_READY;
	}
	@Override
	public byte[] constructResponseInBytes() {
		GamePacket packet = new GamePacket(responseCode);
		packet.addString(username);
		return packet.getBytes();
	}

	public void setData(String username){
		this.username = username;
	}
}

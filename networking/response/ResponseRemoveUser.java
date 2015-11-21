package networking.response;

import metadata.Constants;
import utility.GamePacket;

public class ResponseRemoveUser extends GameResponse {

	private String username;
	public ResponseRemoveUser() {
		responseCode = Constants.SMSG_REMOVE_CHARACTER;
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

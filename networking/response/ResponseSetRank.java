package networking.response;

import metadata.Constants;
import utility.GamePacket;

public class ResponseSetRank extends GameResponse {

	private int rank;
	
	public ResponseSetRank() {
		responseCode = Constants.SMSG_SET_RANK;
	}
	@Override
	public byte[] constructResponseInBytes() {
		GamePacket packet = new GamePacket(responseCode);
		packet.addInt32(rank);
		return packet.getBytes();
	}

	public void setData(int rank){
		this.rank = rank;
	}
}

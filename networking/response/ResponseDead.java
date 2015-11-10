package networking.response;

// Custom Imports
import metadata.Constants;
import utility.GamePacket;

public class ResponseDead extends GameResponse {
	int playerId;
    public ResponseDead() {
        responseCode = Constants.SMSG_DEAD;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
      /*Construct packet*/
        packet.addInt32(playerId);
        return packet.getBytes();
    }
    
    public void setData(int playerId){
    	this.playerId = playerId;
    }
}

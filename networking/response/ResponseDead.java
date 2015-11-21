package networking.response;

// Custom Imports
import metadata.Constants;
import utility.GamePacket;

public class ResponseDead extends GameResponse {
	private String username;
    public ResponseDead() {
        responseCode = Constants.SMSG_DEAD;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
      /*Construct packet*/
        packet.addString(username);
        return packet.getBytes();
    }
    
    public void setData(String username){
    	this.username = username;
    }
}

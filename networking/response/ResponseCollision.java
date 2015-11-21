package networking.response;

// Custom Imports
import metadata.Constants;
import utility.GamePacket;

public class ResponseCollision extends GameResponse {
	private String username;
	private int damage;
    public ResponseCollision() {
        responseCode = Constants.SMSG_COLLISION;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
      /*Construct packet*/
        return packet.getBytes();
    }
    
    public void setData(String username, int damage){
    	this.username = username;
    	this.damage = damage;
    }
}

package networking.response;

// Custom Imports
import metadata.Constants;
import utility.GamePacket;

public class ResponseHealth extends GameResponse {
	String username;
	int health;
    public ResponseHealth() {
        responseCode = Constants.SMSG_HEALTH;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
      /*Construct packet*/
        packet.addString(username);
        packet.addInt32(health);
        return packet.getBytes();
    }
    
    public void setData(String name, int health){
    	username = name;
    	this.health = health;
    }
}

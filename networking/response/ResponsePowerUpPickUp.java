package networking.response;

// Custom Imports
import metadata.Constants;
import utility.GamePacket;

public class ResponsePowerUpPickUp extends GameResponse {
	private int itemId;
	private String username;
    public ResponsePowerUpPickUp() {
        responseCode = Constants.SMSG_POWER_PICKUP;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
      /*Construct packet*/
        packet.addString(username);
        packet.addInt32(itemId);
        return packet.getBytes();
    }
    
    /** Set data
     * 
     */
    public void setData(String username, int itemId){
    	this.username = username;
    	this.itemId = itemId;
    }
}

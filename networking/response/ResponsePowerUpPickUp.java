package networking.response;

// Custom Imports
import metadata.Constants;
import utility.GamePacket;

public class ResponsePowerUpPickUp extends GameResponse {
	int validate;
    public ResponsePowerUpPickUp() {
        responseCode = Constants.SMSG_POWER_PICKUP;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
      /*Construct packet*/
        packet.addInt32(validate);
        return packet.getBytes();
    }
    
    /** Set data
     * 
     */
    public void setData(int validate){
    	this.validate = validate;
    }
}

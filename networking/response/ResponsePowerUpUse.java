package networking.response;

// Custom Imports
import metadata.Constants;
import utility.GamePacket;

public class ResponsePowerUpUse extends GameResponse {
	String username;
	int validate;
    public ResponsePowerUpUse() {
        responseCode = Constants.SMSG_POWER_UP;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
      /*Construct packet*/
        packet.addString(username);
        packet.addInt32(validate);
        return packet.getBytes();
    }
    
    public void setData(String name, int validate){
    	username = name;
    	this.validate = validate;
    }
}

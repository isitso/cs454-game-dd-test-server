package networking.response;

// Custom Imports
import metadata.Constants;
import utility.GamePacket;

public class ResponsePowerUpUse extends GameResponse {
	String username;
	int powerId;
    public ResponsePowerUpUse() {
        responseCode = Constants.SMSG_POWER_UP;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
      /*Construct packet*/
        packet.addString(username);
        packet.addInt32(powerId);
        return packet.getBytes();
    }
    
    public void setData(String name, int powerId){
    	username = name;
    	this.powerId = powerId;
    }
}

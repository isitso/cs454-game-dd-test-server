package networking.response;

// Custom Imports
import metadata.Constants;
import utility.GamePacket;

public class ResponsePrizes extends GameResponse {
	int itemId;
    public ResponsePrizes() {
        responseCode = Constants.SMSG_PRIZES;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
      /*Construct packet*/
        packet.addInt32(itemId);
        return packet.getBytes();
    }
    
    public void setData(int itemId){
    	this.itemId = itemId;
    }
}

package networking.response;


import metadata.Constants;
import utility.GamePacket;

public class ResponseRegister extends GameResponse {
	private int flag;
	
	/**
	 * Must have for each response class because responseCode must be set
	 */
	public ResponseRegister() {
		// TODO Auto-generated constructor stub
		responseCode = Constants.SMSG_REGISTER;
	}
	
	/**
	 * Generate packet for registration
	 */
    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
        packet.addInt32(flag);
        return packet.getBytes();
    }
    
    public void setData(int flag){
    	this.flag = flag;
    }
}
package networking.response;

import metadata.Constants;
import utility.GamePacket;

public class ResponseChat extends GameResponse {

	String name, msg;
	
	/**
	 * Constructor. set the response code
	 */
	public ResponseChat() {
		// TODO Auto-generated constructor stub
		responseCode = Constants.SMSG_CHAT;
	}
	
	/**
	 * Generate the packet to sent
	 * Info for the packet: flag [character name] chat msg
	 */
    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
        packet.addString(name);
        packet.addString(msg);
        return packet.getBytes();
    }

    public void setData(String name, String msg){
    	this.name = name;
    	this.msg = msg;
    }
}

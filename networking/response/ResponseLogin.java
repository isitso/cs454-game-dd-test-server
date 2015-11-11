package networking.response;

import java.util.ArrayList;




import metadata.Constants;
import utility.GamePacket;
import core.Character;

public class ResponseLogin extends GameResponse {
	private int flag;
	ArrayList<Character> list;
	
	public ResponseLogin() {
		// TODO Auto-generated constructor stub
		// Set the response id 
		responseCode = Constants.SMSG_AUTH;
	}

	/**
	 * Construct the packet using the flag, errorType,
	 * 
	 */
    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
        packet.addInt32(flag);
        if (flag == 1){
        	packet.addInt32(list.size());
        	for (Character c: list){
        		packet.addString(c.getName());
        		packet.addInt32(c.getId());
        		packet.addInt32(c.getTypeId());
        	}
        }
        return packet.getBytes();
    }
    
    public void setData(int flag, ArrayList<Character> list){
	    this.flag = flag;
	    this.list = list;
    }
}

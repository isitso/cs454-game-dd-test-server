package networking.response;

import metadata.Constants;
import utility.GamePacket;

public class ResponseMove extends GameResponse {
	String username;
	float x, y, z, h;
	/**
	 * constructor. set response code
	 */
	public ResponseMove() {
		// TODO Auto-generated constructor stub
		responseCode = Constants.SMSG_MOVE;
	}
	
	/**
	 * generate the packet
	 * info: player_id, x, y, z
	 */
    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
        packet.addString(username);
        packet.addFloat(x);
        packet.addFloat(y);
        packet.addFloat(z);
        packet.addFloat(h);
        return packet.getBytes();
    }
    
    /** 
     * Set the player and the position
     * @param id
     * @param x
     * @param y
     * @param z
     * @param h
     * @param p
     * @param r
     */
    public void setMove(String name, float x, float y, float z,
    		float h){
    	// sets the info
    	username = name;
    	this.x = x;
    	this.y = y;
    	this.z = z;
    	this.h = h;
    }
}
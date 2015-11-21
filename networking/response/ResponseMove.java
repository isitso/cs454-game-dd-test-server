package networking.response;

import metadata.Constants;
import utility.GamePacket;

public class ResponseMove extends GameResponse {
	String username, keys;
	float x, y, z, h, p, r;
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
        packet.addFloat(p);
        packet.addFloat(r);
        packet.addString(keys);
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
    		float h, float p, float r, String keys){
    	// sets the info
    	username = name;
    	this.x = x;
    	this.y = y;
    	this.z = z;
    	this.h = h;
    	this.p = p;
    	this.r = r;
    	this.keys = keys;
    }
}
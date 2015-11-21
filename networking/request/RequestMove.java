package networking.request;

import java.io.IOException;

import networking.response.ResponseMove;
import utility.DataReader;

public class RequestMove extends GameRequest {
	float x, y, z, h, p, r;
	String keys;
	/** constructor
	 * 
	 */
	public RequestMove() {
		super();
	}
	
	/**
	 * get data from socket
	 * expected: x, y, z, h, p, r
	 */
    @Override
    public void parse() throws IOException {
    	try {
    		x = DataReader.readFloat(dataInput);
    		y = DataReader.readFloat(dataInput);
    		z = DataReader.readFloat(dataInput);
    		h = DataReader.readFloat(dataInput);
    		p = DataReader.readFloat(dataInput);
    		r = DataReader.readFloat(dataInput);
    		keys = DataReader.readString(dataInput);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

    /**
     * move the player. ignore collision detection for now
     * broadcast to all online players
     */
    @Override
    public void doBusiness() throws Exception {
    	if (client.getGame() != null)
    		throw new Exception("Client has no game.");
    	ResponseMove response = new ResponseMove();
    	// set character new position
    	client.getPlayer().getCharacter().setPos(x, y, z);
    	client.getPlayer().getCharacter().setH(h);
    	// generate response
    	response.setMove(client.getPlayer().getCharacter().getName(), x, y, z, h, p, r, keys);
    	// send to other players
    	client.getGame().addResponseForAllClientsExcept(client.getId(), response);
    }
}

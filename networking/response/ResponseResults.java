package networking.response;

import java.util.ArrayList;

import core.Player;
// Custom Imports
import metadata.Constants;
import utility.GamePacket;

public class ResponseResults extends GameResponse {
	int place;
	ArrayList<Player> playerList = new ArrayList<Player>();
	
    public ResponseResults() {
        responseCode = Constants.SMSG_RESULTS;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
        packet.addInt32(place);
        packet.addInt32(playerList.size());
        for (Player p : playerList){
        	packet.addString(p.getUsername());
        	packet.addInt32(p.getCharacter().getPlace());
        }
        return packet.getBytes();
    }
    
    public void setData(int place, ArrayList<Player> playerList){
    	this.place = place;
    	this.playerList = playerList;
    }
}

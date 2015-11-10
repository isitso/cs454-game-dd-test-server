package networking.response;

import java.util.ArrayList;

import core.GameMode;
import core.Player;
// Custom Imports
import metadata.Constants;
import utility.GamePacket;

public class ResponseRankings extends GameResponse {
	GameMode game;
    public ResponseRankings() {
        responseCode = Constants.SMSG_RANKINGS;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
      /*Construct packet*/
        ArrayList<Player> list = game.getPlayers();
        packet.addInt32(list.size());
    	for (Player player: list){
    		// testing purpose: score = 1
    		packet.addString(player.getUsername());
    		packet.addInt32(1);
    	}
        return packet.getBytes();
    }
    
    void setData(GameMode game){
    	this.game = game;
    }
}

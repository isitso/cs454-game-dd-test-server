package networking.request;

import java.io.IOException;

import core.GameClient;
import networking.response.ResponseChat;
import metadata.Constants;
import utility.DataReader;

public class RequestChat extends GameRequest {
	int flag;
	String chatMsg;
	String receiverName;
	
	/**
	 * Constructor
	 */
	public RequestChat() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	/**
	 * Get data from socket
	 * Expect: flag [character name] msg 
	 * get character name only if it is private msg
	 */
    @Override
    public void parse() throws IOException {
    	try {
    		chatMsg = DataReader.readString(dataInput);
    	} catch (Exception e){
    		e.printStackTrace();
    	}
    }

    /**
     * Generate response
     * if it is private chat. add response only for the target
     * if it is global, add response to every online player
     * if there is no character for private chat, response fail to 
     * the one sending message
     */
    @Override
    public void doBusiness() throws Exception {
    	ResponseChat response = new ResponseChat();
    	response.setData(client.getPlayer().getUsername(), chatMsg);
    	if (client.getGamestate() == Constants.GAMESTATE_LOBBY){
    		// send to whole lobby
    	}else if (client.getGame() != null){
    		client.getGame().addResponseForAllClients(response);
    	}
    }
}

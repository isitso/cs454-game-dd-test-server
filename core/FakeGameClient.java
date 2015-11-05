package core;

import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.Queue;

import networking.response.GameResponse;

public class FakeGameClient extends GameClient{
	/** This class will be used to simulate gameclient
	 * 
	 */
	
	
	public FakeGameClient(GameServer server) throws IOException{
		super(null, server);
	}
	
	/**
	 * Simulate player's actions
	 * socket reading/sending is not needed
	 */
	@Override
	public void run(){
		while (isPlaying){
			try {
				// player's simulating should go inside this method
				this.sleep(1);	// this should let cpu 'rest' a bit
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/** dummy, do nothing
	 * 
	 * @return
	 */
	public boolean addResponseForUpdate(){
		return true;
	}
	
	/** Override GameClient's counterpart
	 * 
	 */
	public Queue<GameResponse> getUpdates(){
		return new LinkedList<GameResponse>();}
	
	/** Override GameClient's counterpart
	 * 
	 */
	public OutputStream getOutputStream(){
		return System.out;
	}
	
	/** Override GameClient's counterpart
	 * 
	 */
	public void clearUpdateBuffer(){}
	
	/** Override GameClient's counterpart
	 * 
	 */
	public void flushResponse(){}
	
	/** Override GameClient's counterpart
	 * 
	 */
	public String getIP(){
		return "Fake IP";
	}
	
	public void simulateLogout(){}
	
	public void simulateJoinGame(){};
	
	public void simulateQuitGame(){};

}

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
	
	/** Constructor
	 * FakeGameClient does not need the Socket like the GameClient
	 * So sending 'null' as the Socket parameter is good enough 
	 * @param server
	 * @throws IOException
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
	
	
	/** Simulate player logout
	 * Should this be in the FakeGameClient or FakePlayer?
	 * Since we will have to remove this object from the list
	 */
	public void simulateLogout(){}
	
	/** Simulate player join the game in the lobby
	 * When joining the game from the lobby, player stay there until
	 * server tell client to load the game
	 */
	public void simulateJoinGame(){};
	
	/** Simulate player quit game(demolition derby, not the actual game)
	 *  
	 */
	public void simulateQuitGame(){};
	
	/** Randomly move around
	 * 
	 */
	public void simulateRandomMove(){}

	/** Move around, but not randomly
	 * it can be any pattern
	 */
	public void simulateScriptedMove(){}
}

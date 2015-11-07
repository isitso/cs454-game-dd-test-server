package core;

import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.Queue;

import networking.response.GameResponse;
import networking.response.ResponseLogout;

public class FakeGameClient extends GameClient{
	/** This class will be used to simulate GameClient
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
				// player's simulating should go inside this scope
				
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
	public GameResponse simulateLogout(){
		return new ResponseLogout();
	}
	
	/** Simulate player join the game in the lobby
	 * When joining the game from the lobby, player stay there until
	 * server tell client to load the game
	 */
	public GameResponse simulateJoinGame(){
		return new ResponseLogout();
	};
	
	/** Simulate player quit game(demolition derby, not the actual game)
	 *  
	 */
	public GameResponse simulateQuitGame(){
		return new ResponseLogout();
	};
	
	/** Randomly move around
	 * 
	 */
	public GameResponse simulateRandomMove(){
		return new ResponseLogout();
	}

	/** Move around, but not randomly
	 * it can be any pattern
	 */
	public GameResponse simulateScriptedMove(){
		return new ResponseLogout();
	}
	
	/** Simulate chat
	 * 
	 */
	public GameResponse simulateChat(){
		return new ResponseLogout();
	}
	
	/** Simulate power up
	 * 
	 */
	public GameResponse simulatePowerUp(){
		return new ResponseLogout();
	}
	
	/** Simulate picking up power item
	 * 
	 */
	public GameResponse simulatePowerPickup(){
		return new ResponseLogout();
	}
	
	/** Randomly pick one of the simulation
	 * Do not care about logical error
	 * @return
	 */
	public GameResponse simulateRandomWithError(){
		return new ResponseLogout();
	}
	
	/** Randomly pick one of the simulation
	 * Avoid logical error as much as possible
	 * @return
	 */
	public GameResponse simulateRandomWithoutError(){
		return new ResponseLogout();		
	}
	
}

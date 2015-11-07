package core;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import metadata.Constants;

import java.lang.reflect.*;
import networking.response.GameResponse;
import networking.response.ResponseLogin;
import networking.response.ResponseLogout;
import networking.response.ResponsePlayerLogout;

public class FakeGameClient extends GameClient{
	/** This class will be used to simulate GameClient
	 * NOTE: gamestate and player are not directly accessible from this class
	 * must use getters/setters to access
	 */
	private long lastActivity;
	// Method maps to be randomized on
	HashMap<Integer, Method> methods = new HashMap<Integer, Method>();
	HashMap<Integer, Method> lobbyMethods = new HashMap<Integer, Method>();
	HashMap<Integer, Method> gameLobbyMethods = new HashMap<Integer, Method>();
	HashMap<Integer, Method> gameCountdownMethods = new HashMap<Integer, Method>();
	HashMap<Integer, Method> gamePlayingMethods = new HashMap<Integer, Method>();
	HashMap<Integer, Method> gameFinishedMethods = new HashMap<Integer, Method>();
	
	Queue<GameResponse> responses = new LinkedList<GameResponse>();	// store response to broadcast
	
	/** Constructor
	 * FakeGameClient does not need the Socket like the GameClient
	 * So sending 'null' as the Socket parameter is good enough 
	 * @param server
	 * @throws IOException
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public FakeGameClient(GameServer server) throws IOException, NoSuchMethodException, SecurityException{
		super(null, server);
		// generate method maps
		methods.put(1, FakeGameClient.class.getMethod("simulateLogin"));
		methods.put(2, FakeGameClient.class.getMethod("simulateChat"));
		methods.put(3, FakeGameClient.class.getMethod("simulateJoinGame"));
		methods.put(4, FakeGameClient.class.getMethod("simulateLogout"));
		methods.put(5, FakeGameClient.class.getMethod("simulatePowerPickup"));
		methods.put(6, FakeGameClient.class.getMethod("simulatePowerUp"));
		methods.put(7, FakeGameClient.class.getMethod("simulateQuitGame"));
		methods.put(8, FakeGameClient.class.getMethod("simulateRandomMove"));
		methods.put(9, FakeGameClient.class.getMethod("simulateReady"));
		methods.put(10, FakeGameClient.class.getMethod("simulateDead"));
		methods.put(11, FakeGameClient.class.getMethod("simulateCreateGame"));
		//methods.put(1, FakeGameClient.class.getMethod("simulateScriptedMove"));
		
		// just logged in. strolling in lobby
		lobbyMethods.put(1, FakeGameClient.class.getMethod("simulateChat"));
		lobbyMethods.put(2, FakeGameClient.class.getMethod("simulateCreateGame"));
		lobbyMethods.put(3, FakeGameClient.class.getMethod("simulateJoinGame"));
		if (Constants.SIMULATION_AUTO_LOGOUT)
			lobbyMethods.put(4, FakeGameClient.class.getMethod("simulateLogout"));
		
		// inside game lobby. waiting for 
		gameLobbyMethods.put(1, FakeGameClient.class.getMethod("simulateChat"));
		if (Constants.SIMULATION_AUTO_LOGOUT)
			gameLobbyMethods.put(2, FakeGameClient.class.getMethod("simulateLogout"));
		
		// finished loading game (waiting for count down)
		gameCountdownMethods.put(1, FakeGameClient.class.getMethod("simulateChat"));
		if (Constants.SIMULATION_AUTO_LOGOUT)
			gameCountdownMethods.put(2, FakeGameClient.class.getMethod("simulateLogout"));
		
		// game is on. can do: chat, move, (leave game? no protocol yet), log out, power up, pick power item, dead
		gamePlayingMethods.put(1, FakeGameClient.class.getMethod("simulateChat"));
		gamePlayingMethods.put(2, FakeGameClient.class.getMethod("simulateRandomMove"));
		gamePlayingMethods.put(3, FakeGameClient.class.getMethod("simulatePowerUp"));
		gamePlayingMethods.put(4, FakeGameClient.class.getMethod("simulatePowerPickup"));
		gamePlayingMethods.put(5, FakeGameClient.class.getMethod("simulateDead"));
		if (Constants.SIMULATION_AUTO_LOGOUT)
			gamePlayingMethods.put(1, FakeGameClient.class.getMethod("simulateLogout"));
		
		// game over. can do: chat, back to lobby, move, log out
		gameFinishedMethods.put(1, FakeGameClient.class.getMethod("simulateChat"));
		gameFinishedMethods.put(2, FakeGameClient.class.getMethod("simulateRandomMove"));
		if (Constants.SIMULATION_AUTO_LOGOUT)
			gameFinishedMethods.put(3, FakeGameClient.class.getMethod("simulateLogout"));

		getPlayer().setId(100 + (int)getId());
		getPlayer().setUsername("FakeUser" + getPlayer().getId());
	}
	
	/**
	 * Simulate player's actions
	 * socket reading/sending is not needed
	 */
	//@Override
	public void run(){
		isPlaying = true;
		lastActivity = System.currentTimeMillis();
		while (isPlaying){
			try {
				// player's simulating should go inside this scope
				if (System.currentTimeMillis() - lastActivity > Constants.SIMULATION_LOBBY_DELAY){
					simulateRandomWithoutError();
					lastActivity = System.currentTimeMillis();
				}
				//simulateRandomWithError();
				this.sleep(1);	// this should let cpu 'rest' a bit
				
				// have a response to broadcast to other real players
				// do it here
			} catch (Exception e) {
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
	
	/** Simulate player login
	 * @return
	 */
	public void simulateLogin(){
		getServer().addClientToLobby(this);
		setGamestate(Constants.GAMESTATE_LOBBY);
		System.out.printf("Fake client [%d:%s] logged in\n", getId(), getPlayer().getUsername());
		lastActivity = System.currentTimeMillis();
		// need to generate player login notice for other players
	}
	/** Simulate player logout
	 * Should this be in the FakeGameClient or FakePlayer?
	 * Since we will have to remove this object from the list
	 */
	public void simulateLogout(){
	}
	
	/** Simulate player join the game in the lobby
	 * When joining the game from the lobby, player stay there until
	 * server tell client to load the game
	 */
	public void simulateJoinGame(){
		
	};
	
	/** Simulate player quit game(demolition derby, not the actual game)
	 *  
	 */
	public void simulateQuitGame(){
	};
	
	/** Randomly move around
	 * 
	 */
	public void simulateRandomMove(){
		Random random = new Random();
		float x = random.nextFloat() * Constants.SIMULATION_PLAYER_MAX_SPEED;
		float y = random.nextFloat() * Constants.SIMULATION_PLAYER_MAX_SPEED;
		getPlayer().getCharacter().setPos(x, y, getPlayer().getCharacter().getZ());
		// generate response here
	}

	/** Move around, but not randomly
	 * it can be any pattern
	 */
	public void simulateScriptedMove(){
	}
	
	/** Simulate chat
	 * 
	 */
	public void simulateChat(){
		// generate chat here
	}
	
	/** Simulate power up
	 * 
	 */
	public void simulatePowerUp(){
		// for now just pick up powerId 1
		if (getPlayer().getCharacter().hasPowerUp(1)) {
			try {
				getPlayer().getCharacter().usePowerUp(1);
				// generate response here
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
	}
	
	/** Simulate picking up power item
	 * 
	 */
	public void simulatePowerPickup(){
	}
	
	/** Randomly pick one of the simulation
	 * Do not care about logical error
	 * do not care about gamestate.
	 * WARNING: only use this when the client keeps track of gamestate or 
	 * some kind of packet validation
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	public void simulateRandomWithError() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Random random = new Random();
		methods.get(random.nextInt() % methods.size()).invoke(this);
	}
	
	/** Randomly pick one of the simulation
	 * Avoid logical error as much as possible
	 * use gamestate to determine the set of possible actions
	 * all methods inside should add a response to the response queue to broadcase later
	 */
	public void simulateRandomWithoutError(){
		Random random = new Random();
		try {
			switch (getGamestate()){
			case Constants.GAMESTATE_NOT_LOGGED_IN:
				// not logged in yet. log in now
				simulateLogin();
				break;
			case Constants.GAMESTATE_LOBBY:
				// in lobby. can do: chat, create game, join game, log out
				lobbyMethods.get(random.nextInt() % lobbyMethods.size()).invoke(this);
				break;
			case Constants.GAMESTATE_GAME_WAITING:
				// waiting in game lobby. can do: chat, (leave game? no protocol yet), log out
				gameLobbyMethods.get(random.nextInt() % gameLobbyMethods.size()).invoke(this);
				break;
			case Constants.GAMESTATE_GAME_COUNTDOWN:
				// finished load game and ready to start. can do: chat, (leave game? no protocol yet), log out
				gameCountdownMethods.get(random.nextInt() % gameCountdownMethods.size()).invoke(this);
				break;
			case Constants.GAMESTATE_GAME_PLAYING:
				// game is on. can do: chat, move, (leave game? no protocol yet), log out, power up, pick power item, dead
				gamePlayingMethods.get(random.nextInt() % gamePlayingMethods.size()).invoke(this);
				break;
			case Constants.GAMESTATE_GAME_FINISHED:
				// game over. can do: chat, back to lobby, move, log out
				gameFinishedMethods.get(random.nextInt() % gameFinishedMethods.size()).invoke(this);
				break;
			default:
				break;
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	/** simulate player dead
	 * @return
	 */
	public void simulateDead(){
		if (getPlayer().getCharacter().isDead()){
			//generate response here
		}
	}
	
	/** simulate player ready for game
	 * @return
	 */
	public void simulateReady(){
	}
	
	/** simulate create game lobby
	 * 
	 */
	public void simulateCreateGame(){
		GameMode gm = getServer().createGame(1);
		getServer().addClientToGame(this, gm);
		// generate response here
	}
	
	/** simulate collision. report the damage done on another player
	 * 
	 */
	public void simulateCollision(){
		int damage = 1;
		ArrayList<Character> characterList = new ArrayList<Character>();
		for (Player player: getGame().getPlayers()){
			if (player.getCharacter().getId() != getPlayer().getCharacter().getId())
				characterList.add(player.getCharacter());
		}
		if (characterList.size() >= 1){
			// car collision should only happen when there are 2 cars or more
			Random random = new Random();
			int targetId = random.nextInt() % characterList.size();
			// generate response here
			
		}
	}
	
	@Override
	public String toString(){
		return "FakeGameClient [" + getId() + "]";
	}
}

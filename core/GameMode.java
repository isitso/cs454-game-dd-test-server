package core;

import java.util.ArrayList;
import java.util.HashMap;

import networking.response.GameResponse;

public abstract class GameMode extends Thread {
	/**
	 * Abstract class for game mode
	 */
	
	protected HashMap<Long, GameClient> clients = new HashMap<Long, GameClient>();
	protected HashMap<Long, Player> players = new HashMap<Long, Player>();
	public final static int MAX_PLAYER_COUNT = 10;
	protected boolean isRunning;
	protected GameServer server;
	
	/** Start the game (dd or rr)
	 * 
	 */
	public abstract void startGame();
	
	/** End the game (dd or rr)
	 * 
	 */
	public abstract void endGame();
	
	/** Add client to the list of this game object
	 * 
	 * @param id
	 * @param client
	 * @throws Exception
	 */
	public void addClient(long id, GameClient client) throws Exception {
		synchronized (clients){
			if (clients.size() >= MAX_PLAYER_COUNT)
				throw new Exception("Game is full.");
			clients.put(id, client);
		}
	}
	
	/** RemoveClient from the list of game object
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void removeClient(long id) throws Exception {
		synchronized (clients){
			if (!clients.containsKey(id))
				throw new Exception("Client not found.");
			clients.remove(id);
		}
	}

	public HashMap<Long, GameClient> getClients() {
		return clients;
	}

	public void setClients(HashMap<Long, GameClient> clients) {
		this.clients = clients;
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	
	/** add a response for all client in the game
	 * 
	 * @param response
	 */
	public void addResponseForAllClients(GameResponse response){
		for (GameClient client: clients.values()){
			client.addResponseForUpdate(response);
		}
	}

	public ArrayList<Player> getPlayers(){
		return new ArrayList<Player>(players.values());
	}
	
	public GameClient getClient(long id){
		return clients.get(id);
	}
	
	public boolean isFull(){
		return clients.size() >= MAX_PLAYER_COUNT;
	}
	
}

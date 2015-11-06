package core;

import java.util.HashMap;

public abstract class GameMode extends Thread {
	/**
	 * Abstract class for game mode
	 */
	
	protected HashMap<Long, GameClient> clientList = new HashMap<Long, GameClient>();
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
		synchronized (clientList){
			if (clientList.size() >= MAX_PLAYER_COUNT)
				throw new Exception("Game is full.");
			clientList.put(id, client);
		}
	}
	
	/** RemoveClient from the list of game object
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void removeClient(long id) throws Exception {
		synchronized (clientList){
			if (!clientList.containsKey(id))
				throw new Exception("Client not found.");
			clientList.remove(id);
		}
	}

	public HashMap<Long, GameClient> getClientList() {
		return clientList;
	}

	public void setClientList(HashMap<Long, GameClient> clientList) {
		this.clientList = clientList;
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

}

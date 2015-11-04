package core;

import java.util.HashMap;

public abstract class GameMode extends Thread {
	/**
	 * Abstract class for game mode
	 */
	
	protected HashMap<Long, Player> playerList = new HashMap<Long, Player>();
	public final static int MAX_PLAYER_COUNT = 10;
	
	public abstract void startGame();
	
	public abstract void endGame();
	
	public void addPlayer(long id, Player player) throws Exception {
		if (playerList.size() >= MAX_PLAYER_COUNT)
			throw new Exception("Game is full.");
		playerList.put(id, player);
	}
	
	public void removePlayer(long id) throws Exception {
		if (!playerList.containsKey(id))
			throw new Exception("Player not found.");
		playerList.remove(id);
	}

	public HashMap<Long, Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(HashMap<Long, Player> playerList) {
		this.playerList = playerList;
	}

}

package core;

public class DemolitionDerbyGame extends GameMode {

	/** Demolition Derby Game Mode
	 * 
	 */
	public DemolitionDerbyGame(GameServer server){
		this.server = server;
	}
	
	public void startGame(){}
	public void endGame(){}
	
	@Override
	public void run(){}
	
	/**
	 * create fake client to simulate
	 */
	public void createFakeClient() throws Exception{
		if (clientList.size() >= MAX_PLAYER_COUNT)
			throw new Exception("Game is full.");
		FakeGameClient fgc = new FakeGameClient(this.server);
		clientList.put(fgc.getId(), fgc);
	}
}

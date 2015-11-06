package core;

public class FakePlayer extends Player{
	/** Player class with extra simulating stuffs
	 * Simulate player
	 */
	public FakePlayer() {
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
	
	/** Simulate chat
	 * 
	 */
	public void simulateChat(){}
}

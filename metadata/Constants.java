package metadata;

/**
 * The Constants class stores important variables as constants for later use.
 */
public class Constants {

    // Request (1xx) + Response (2xx)
    public final static short C_AUTH = 101;
    public final static short S_AUTH = 201;
    public final static short C_REGISTER = 105;
    public final static short S_REGISTER = 205;
    public final static short C_CREATE_CHARACTER = 106;
    public final static short S_CREATE_CHARACTER = 206;
    public final static short C_DISCONNECT = 102;
    public final static short S_DISCONNECT = 202;
    public final static short C_GO_TO_CHARACTER_SELECTION = 103;
    public final static short S_GO_TO_CHARACTER_SELECTION = 203;
    public final static short C_SELECT_CHARACTER = 104;
    public final static short S_SELECT_CHARACTER = 204;
    public final static short C_MOVE = 110;
    public final static short S_MOVE = 210;
    public final static short S_PLAYER_LOGOUT = 212;
    public final static short C_CHAT = 111;
    public final static short S_CHAT = 211;
    public final static short C_HEARTBEAT = 120;
    public final static short S_HEARTBEAT = 220;
    public final static short C_SAVE_EXIT_GAME = 119;
    public final static short S_SAVE_EXIT_GAME = 219;
    public final static short S_SPAWN = 213;

    //Test Request + Response
    public final static short RAND_INT = 1;
    public final static short RAND_STRING = 2;
    public final static short RAND_SHORT = 3;
    public final static short RAND_FLOAT = 4;
    // Other
    public static final int SAVE_INTERVAL = 60000;
    public static final String CLIENT_VERSION = "1.00";
    public static final int TIMEOUT_SECONDS = 30;
    
    
    // Login flags
    public static final int LOGIN_FAIL = 0;
    public static final int LOGIN_SUCCESS = 1;
    public static final int ERROR_ACCOUNT_NOT_FOUND = 2;
    public static final int ERROR_WRONG_PASSWORD = 3;
    public static final int ERROR_ACCOUNT_IS_IN_USE = 4;
    
    // Chat flags
    public static final int CHAT_GLOBAL = 0;
    public static final int CHAT_PRIVATE = 1;
    public static final int CHAT_FAIL = 2;
    
    // Character selection flags
    public static final int CHARACTER_SELECTION_FAIL = 0;
    public static final int CHARACTER_SELECTION_SUCCESS = 1;
    
    // Registration flags
    public static final int REGISTRATION_FAIL = 0;
    public static final int REGISTRATION_SUCCESS = 1;
    public static final int REGISTRATION_ACCOUNT_ALREADY_EXIST = 0;
    public static final int REGISTRATION_INCORRECT_INPUT = 1;
    
    // Character creation flags
    public static final int CHARACTER_CREATION_FAIL = 0;
    public static final int CHARACTER_CREATION_SUCESS = 1;
    public static final int CHARACTER_CREATION_SLOTS_FULL = 0;
    public static final int CHARACTER_CREATION_NAME_TAKEN = 1;

    // Spawn flags
    public static final int SPAWN_PLAYER = 0;
    public static final int SPAWN_NPC = 1;
    public static final int SPAWN_MAIN_PLAYER = 2;
    
    // Gamestates. keep track of each gameclient state
    public static final int GAMESTATE_NOT_LOGGED_IN = 0;	// still not logged in
    public static final int GAMESTATE_LOBBY = 1;			// logged in. currently in lobby
    public static final int GAMESTATE_GAME_WAITING = 2;		// created/ joined a game. in game lobby
    public static final int GAMESTATE_GAME_COUNTDOWN = 3;	// counting down
    public static final int GAMESTATE_GAME_PLAYING = 4;		// game is in process
    public static final int GAMESTATE_GAME_FINISHED = 5;	// game has finished
    public static final int GAMESTATE_GAME_READY = 6;		// finished loading. client is ready for count down
    public static final int GAMESTATE_LOADING = 9;			// special state. give client time to load stuff.
    														// used to counter heartbeat timeout if needed
    
    // DEBUG
    public static final boolean DEBUG = true;
    
    // SIMULATION
    public static final boolean SIMULATION_ON = false;	// true: use FakeGameClient to simulate multiplayers
    public static final int SIMULATION_FAKE_CLIENT_COUNT = 4;	// number of simulated clients
    public static final float SIMULATION_PLAYER_MAX_SPEED = 0.001f;		// max move speed
    public static final int SIMULATION_DELAY = 5000; // miliseconds		// delay between each action
    public static final boolean SIMULATION_AUTO_LOGOUT = false;			// add log out to random actions
    public static final boolean SIMULATION_AUTO_QUIT_GAME = false;		// add leave game to random actions
    public static final int SIMULATION_LOBBY_DELAY = 5; //seconds	// delay in lobby state
    public static final int SIMULATION_GAME_LOBBY_DELAY = 5;	// delay in game lobby state
    public static final int SIMULATION_GAME_DELAY = 3;		// delay in game play state
    public static final int SIMULATION_GAME_TIME_OUT = 15;	//seconds. game will end if it has run for x seconds
    
    // GAME MODE
    public static final int GAMEMODE_DD = 0;
    public static final int GAMEMODE_RR = 1;
    public static final int GAMEMODE_STATE_LOBBY = 0;		// game is in lobby state
    public static final int GAMEMODE_STATE_WAIT = 1;		// game is waiting for clients to ready
    public static final int GAMEMODE_STATE_COUNTDOWN = 2;	// game is counting down
    public static final int GAMEMODE_STATE_PLAY = 3;		// game is in process
    public static final int GAMEMODE_STATE_ENDED = 4;		// game has ended
}

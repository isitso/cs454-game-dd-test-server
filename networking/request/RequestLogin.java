package networking.request;

import java.io.IOException;

import utility.DataReader;
import utility.GamePacket;

import java.sql.*;
import java.util.ArrayList;

import metadata.Constants;
import networking.response.ResponseLogin;
import core.Character;
import core.Player;

public class RequestLogin extends GameRequest {
	String username, pwd;
	public RequestLogin() {
		super();
	}

	/**
	 * Get the data from socket
	 * Expect: username and password
	 */
	@Override
	public void parse() throws IOException {
		/**
		 * Get the data from socket
		 */
		// Expected data: String username, String pwd
		try {
			username = DataReader.readString(dataInput);
			pwd = DataReader.readString(dataInput);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Connect to the database
	 * Check for account exist or not
	 * Check for password is correct or not
	 * Check for account is currently in use or not
	 * Generate the Response
	 */
	@Override
	public void doBusiness() throws Exception {
		ResponseLogin responseLogin = new ResponseLogin();
		// Testing purpose: just let client log in
		int clientId = (int)client.getId();
		client.getPlayer().getCharacter().setId(clientId);
		client.getPlayer().getCharacter().setName("name" + clientId);
		client.getPlayer().getCharacter().setTypeId(1);
		ArrayList<Character> list = new ArrayList<Character>();
		list.add(client.getPlayer().getCharacter());
		responseLogin.setData(1, list);
		responses.add(responseLogin);
	}
}

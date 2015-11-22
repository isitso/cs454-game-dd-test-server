package networking.request;

import java.io.IOException;

import utility.DataReader;

public class RequestSetRank extends GameRequest {

	private int rank;
	public RequestSetRank() {
		super();
	}
	
	@Override
	public void parse() throws IOException {
		rank = DataReader.readInt(dataInput);		
	}

	@Override
	public void doBusiness() throws Exception {
		client.getPlayer().getCharacter().setRank(rank);
	}

}

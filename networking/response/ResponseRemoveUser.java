package networking.response;

import metadata.Constants;

public class ResponseRemoveUser extends GameResponse {

	private String username;
	public ResponseRemoveUser() {
		responseCode = Constants.SMSG_REMOVE_CHARACTER;
	}
	@Override
	public byte[] constructResponseInBytes() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setData(String username){
		this.username = username;
	}
}

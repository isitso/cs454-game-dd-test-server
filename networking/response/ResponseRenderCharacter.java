package networking.response;

import metadata.Constants;
import utility.GamePacket;

public class ResponseRenderCharacter extends GameResponse {

	private String name;
	private int carType, carPaint, carTire;
	public ResponseRenderCharacter() {
		responseCode = Constants.SMSG_RENDER_CHARACTER;
	}
	@Override
	public byte[] constructResponseInBytes() {
		GamePacket packet = new GamePacket(responseCode);
		packet.addString(name);
		packet.addInt32(carType);
		packet.addInt32(carPaint);
		packet.addInt32(carTire);
		return packet.getBytes();
	}

	public void setData(String name, int carType, int carPaint, int carTire){
		this.name = name;
		this.carPaint = carPaint;
		this.carTire = carTire;
		this.carType = carType;
	}
}

package networking.request;

import java.io.IOException;

public class RequestCreateCharacter extends GameRequest {
	
	public RequestCreateCharacter() {
		super();
	}
	// Must override the abstract class' method
    @Override
    public void parse() throws IOException {
    }

    // Must override the abstract class' method
    @Override
    public void doBusiness() throws Exception {
    }
}

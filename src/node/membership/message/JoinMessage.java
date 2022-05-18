package node.membership.message;

import java.nio.ByteBuffer;
import java.util.ArrayList;

public class JoinMessage extends Message {
    private final Integer counter;
    private final Integer port;

    public JoinMessage(int counter, int port) {
        super(MessageType.JOIN);
        this.counter = counter;
        this.port = port;

        this.buildBody();
    }

    private void buildBody() {
        this.body = new ArrayList<>();
        byte[] bytes = ByteBuffer.allocate(4).putInt(counter).array();

        for (byte b : bytes) {
            body.add(b);
        }

        body.add((byte) ' ');

        bytes = ByteBuffer.allocate(4).putInt(port).array();

        for (byte b : bytes) {
            body.add(b);
        }
    }
}

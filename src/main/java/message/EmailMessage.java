package message;

import javax.crypto.Mac;

public class EmailMessage implements Message {
    @Override
    public void send() {
        System.out.println("Email message sent");
    }
}

package message;

public class SmsMessage implements Message{
    @Override
    public void send() {
        System.out.println("SMS sent");
    }
}

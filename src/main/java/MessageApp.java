import factory.MessageFactory;
import message.Message;

public class MessageApp {
    public static void main(String[] args) {
        Message email = MessageFactory.createMessage("EMAIL");
        email.send();

    }
}
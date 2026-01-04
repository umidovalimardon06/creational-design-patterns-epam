package factory;

import message.EmailMessage;
import message.Message;
import message.SmsMessage;

public class MessageFactory {
    public static Message createMessage(String type) {
        if (type.equals("EMAIL")) {
            return new EmailMessage();
        } else if (type.equals("SMS")) {
            return new SmsMessage();
        }

        return null;
    }
}

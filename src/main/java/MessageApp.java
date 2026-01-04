import service.EmailService;
import service.SmsService;
import service.TelegramService;
import service.WhatsAppService;

public class MessageApp {
    public void sendMessage(String type) {
        // too many "if-else" statements:
        switch (type) {
            case "EMAIL" -> {
                ///  problem-1:
                ///  tight-coupling here

                ///  problem-2:
                ///  violating single-responsibility-principle (SOLID-S)

                EmailService emailService = new EmailService();
                emailService.send();
            }
            case "SMS" -> {
                SmsService smsService = new SmsService();
                smsService.send();
            }
            case "TELEGRAM" -> {
                TelegramService telegramService = new TelegramService();
                telegramService.send();
            }
            ///  problem-3:
            ///  whenever we add WhatsAppService.,
            ///  new-modification (SOLID-O)
            case "WHATSAPP" -> {
                WhatsAppService whatsAppService = new WhatsAppService();
                whatsAppService.send();
            }

        }
    }
}
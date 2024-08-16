// Interface que define el servicio de mensajería
interface MessageService {
    void sendMessage(String message, String recipient);
}

// Implementación del servicio de mensajería por correo electrónico
class EmailService implements MessageService {
    @Override
    public void sendMessage(String message, String recipient) {
        System.out.println("Email sent to " + recipient + " with message: " + message);
    }
}

// Implementación del servicio de mensajería por SMS
class SMSService implements MessageService {
    @Override
    public void sendMessage(String message, String recipient) {
        System.out.println("SMS sent to " + recipient + " with message: " + message);
    }
}

// Clase que usa el servicio de mensajería
class NotificationService {
    private final MessageService messageService;

    // Inyección de dependencia a través del constructor
    public NotificationService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void notifyUser(String message, String recipient) {
        messageService.sendMessage(message, recipient);
    }
}

// Clase principal
public class inyeccionDeDependencias {
    public static void main(String[] args) {
        // Inyección de la dependencia EmailService
        MessageService emailService = new EmailService();
        NotificationService notificationService1 = new NotificationService(emailService);
        notificationService1.notifyUser("Hello via Email!", "user@example.com");
        
        // Inyección de la dependencia SMSService
        MessageService smsService = new SMSService();
        NotificationService notificationService2 = new NotificationService(smsService);
        notificationService2.notifyUser("Hello via SMS!", "123-456-7890");
    }
}

@Service
public class ReminderService {

    @KafkaListener(topics = "reminder-events", groupId = "reminder-group")
    public void processReminder(String reminder) {
        // Simulate notification (e.g., print reminder to console or send email)
        System.out.println("Reminder received: " + reminder);
        // Send a notification via SMS, email, or another method here
    }
}

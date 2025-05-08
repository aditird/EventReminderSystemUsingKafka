@RestController
@RequestMapping("/reminders")
public class ReminderController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public ReminderController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public String setReminder(@RequestBody Reminder reminder) {
        String reminderMessage = "Reminder: " + reminder.getMessage() + " at " + reminder.getTime();
        kafkaTemplate.send("reminder-events", reminderMessage);
        return "Reminder set successfully!";
    }
}

@Configuration
public class KafkaConfig {

    @Bean
    public ProducerFactory<String, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    private Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return props;
    }
}

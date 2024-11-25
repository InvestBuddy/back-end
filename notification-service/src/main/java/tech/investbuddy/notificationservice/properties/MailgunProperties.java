package tech.investbuddy.notificationservice.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "mailgun")
@Data
public class MailgunProperties {
    private String apiKey;
    private String domain;
    private String baseUrl;
}
package tech.investbuddy.notificationservice.properties;

import org.springframework.stereotype.Component;

import io.github.cdimascio.dotenv.Dotenv;

@Component
public class MailgunProperties {
    private final Dotenv dotenv = Dotenv.load();

    public String getApiKey() {
        return dotenv.get("MAILGUN_API_KEY");
    }

    public String getDomain() {
        return dotenv.get("MAILGUN_DOMAIN");
    }

    public String getBaseUrl() {
        return dotenv.get("MAILGUN_BASE_URL");
    }
}

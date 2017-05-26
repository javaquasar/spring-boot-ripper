package conference.spring.boot.starter.profiles.prepared;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author tolkv
 * @version 25/05/2017
 */
@Data
@ConfigurationProperties(prefix = "prod")
public class NotificationProperties {
  private List<String> mails;
  private boolean canNotify;
}

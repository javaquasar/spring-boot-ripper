package conference.spring.boot.ripper;

import conference.spring.boot.starter.profiles.prepared.NotificationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tolkv
 * @version 25/05/2017
 */
@Configuration
public class RipperConfiguration {

  @Bean
  public DatabaseNotifier databaseNotifier(NotificationProperties notificationProperties) {
    return new DatabaseNotifier(notificationProperties);
  }

}

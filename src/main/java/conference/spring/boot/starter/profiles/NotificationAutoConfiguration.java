package conference.spring.boot.starter.profiles;

import conference.spring.boot.ripper.NotificationSender;
import conference.spring.boot.starter.profiles.prepared.NotificationProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;

/**
 * @author tolkv
 * @version 25/05/2017
 */
@Configuration
@EnableConfigurationProperties(NotificationProperties.class)
public class NotificationAutoConfiguration {

  @Bean
  @ConditionalOnBean(annotation = NotificationSender.class)
  @ConditionalOnProperty(havingValue = "true", name = "prod.can-notify", matchIfMissing = true)
  public ApplicationListener<ContextRefreshedEvent> applicationListenerContextRefreshedEvent(
      NotificationProperties notificationProperties
  ) {
    return (ContextRefreshedEvent event) -> {
      Environment environment = event.getApplicationContext().getEnvironment();

      if (environment.getActiveProfiles().length == 0) {
        throw new RuntimeException("Shoud have production profile");
      }

    };
  }

  @Bean
  public SendEmailListener SendEmailListener(NotificationProperties notificationProperties) {
    return new SendEmailListener(notificationProperties);
  }


}

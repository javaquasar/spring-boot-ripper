package conference.spring.boot.starter.profiles;

import conference.spring.boot.starter.profiles.prepared.NotificationProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author tolkv
 * @version 26/05/2017
 */
@Configuration
@EnableConfigurationProperties(NotificationProperties.class)
public class NotificationAutoConfig {

  @Bean
  @Profile("production")
  @ConditionalOnMissingBean(annotation = SenderMarker.class)
  @ConditionalOnProperty(name = "prod.can-notify", matchIfMissing = true, havingValue = "true")
  public ApplicationListener notificationListener(NotificationProperties notificationProperties) {
    return (ApplicationListener<ContextRefreshedEvent>) event -> notificationProperties.getMails().forEach(System.out::println);
  }

}

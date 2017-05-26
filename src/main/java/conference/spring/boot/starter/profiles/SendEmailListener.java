package conference.spring.boot.starter.profiles;

import conference.spring.boot.starter.profiles.prepared.NotificationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author tolkv
 * @version 26/05/2017
 */
@RequiredArgsConstructor
public class SendEmailListener implements ApplicationListener<ContextRefreshedEvent> {
  private final NotificationProperties notificationProperties;

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    notificationProperties.getMails().forEach(System.out::println);
  }
}

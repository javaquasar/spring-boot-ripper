package conference.spring.boot.ripper;

import conference.spring.boot.starter.profiles.prepared.NotificationProperties;
import lombok.RequiredArgsConstructor;

import javax.annotation.PostConstruct;

/**
 * @author tolkv
 * @version 28/05/2017
 */
@RequiredArgsConstructor
@NotificationSender
public class DatabaseNotifier {
  private final NotificationProperties notificationProperties;

  @PostConstruct
  public void init() {
    System.out.println("notify to database" + DatabaseNotifier.class);
    notificationProperties.getMails().forEach(System.out::println);
  }
}

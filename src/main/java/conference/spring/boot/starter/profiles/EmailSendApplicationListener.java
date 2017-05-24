package conference.spring.boot.starter.profiles;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.Arrays;

/**
 * @author tolkv
 * @version 25/05/2017
 */
public class EmailSendApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {

    System.out.println("send email event {" +
        "application has been started with profiles:" +
          Arrays.toString(event.getApplicationContext().getEnvironment().getActiveProfiles()) +
        "}"
    );

  }
}

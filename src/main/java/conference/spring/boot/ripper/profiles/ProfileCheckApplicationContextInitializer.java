package conference.spring.boot.ripper.profiles;

import com.sun.tools.javac.util.List;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author tolkv
 * @version 25/05/2017
 */
public class ProfileCheckApplicationContextInitializer implements ApplicationContextInitializer {
  @Override
  public void initialize(ConfigurableApplicationContext applicationContext) {
    if (!List.from(applicationContext.getEnvironment().getActiveProfiles()).contains("production")) {
      throw new RuntimeException("Shoud have production profile");
    }
  }
}

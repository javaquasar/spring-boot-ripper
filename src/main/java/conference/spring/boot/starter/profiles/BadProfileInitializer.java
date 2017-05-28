package conference.spring.boot.starter.profiles;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author tolkv
 * @version 26/05/2017
 */
public class BadProfileInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
  /**
   * does not work
   */
  //  @Autowired
  //  ApplicationContext applicationContext;

  @Override
  public void initialize(ConfigurableApplicationContext applicationContext) {
    if (applicationContext.getEnvironment().getActiveProfiles().length == 0) {
      throw new RuntimeException("Shoud have production profile");
    }
  }
}

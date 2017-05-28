package conference.spring.boot.starter.profiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author tolkv
 * @version 26/05/2017
 */
public class CheckEnvAndSetAccordingToOsNameEnvironmentPostProcessor implements EnvironmentPostProcessor {
  @Override
  public void postProcessEnvironment(ConfigurableEnvironment environment,
                                     SpringApplication application) {

    String os = System.getProperty("os.name");

    if (os.equalsIgnoreCase("Windows")) {
      environment.addActiveProfile("dev");
    }

  }
}

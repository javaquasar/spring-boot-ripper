package conference.spring.boot.starter.profiles;

import com.sun.tools.javac.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author tolkv
 * @version 25/05/2017
 */
public class ProfilesEnvironmentPostProcessor implements EnvironmentPostProcessor {
  @Override
  public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
    List<String> profiles = List.from(environment.getActiveProfiles());
    if (profiles.contains("production") && profiles.contains("debug")) {
      environment.addActiveProfile("trace");
    }
  }
}

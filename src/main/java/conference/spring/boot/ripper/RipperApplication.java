package conference.spring.boot.ripper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class RipperApplication {

  @Autowired
  Environment environment;

  @PostConstruct
  public void init() {
    System.out.println("profiles" + Arrays.toString(environment.getActiveProfiles()));
  }

  public static void main(String[] args) {
    SpringApplication.run(new Object[]{RipperConfiguration.class, RipperApplication.class}, args);
  }

}

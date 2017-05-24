package conference.spring.boot.ripper.profiles;

import org.springframework.boot.diagnostics.FailureAnalysis;
import org.springframework.boot.diagnostics.FailureAnalyzer;

/**
 * @author tolkv
 * @version 25/05/2017
 */
public class ProfileNeededFailureAnalyzer implements FailureAnalyzer {
  @Override
  public FailureAnalysis analyze(Throwable failure) {
    if (failure.getMessage().contains("Shoud have production profile")) {
      return new FailureAnalysis("Shoud have production profile", "add --spring.profiles.active=production", failure);
    }
    return null;
  }
}

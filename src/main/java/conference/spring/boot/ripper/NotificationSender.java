package conference.spring.boot.ripper;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author tolkv
 * @version 25/05/2017
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface NotificationSender {
}

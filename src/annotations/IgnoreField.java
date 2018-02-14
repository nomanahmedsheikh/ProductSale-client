package annotations;

/**
 * Created by nomanahmedsheikh on 11/02/18.
 */

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)

public @interface IgnoreField {
    String value() default  "";
}

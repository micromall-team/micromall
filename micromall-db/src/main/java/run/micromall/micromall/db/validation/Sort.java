package run.micromall.micromall.db.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Administrator
 */
@Target({METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = SortValidator.class)
public @interface Sort {
    String message() default "排序字段不支持";

    String[] accepts() default {"add_time","sort_order"};

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

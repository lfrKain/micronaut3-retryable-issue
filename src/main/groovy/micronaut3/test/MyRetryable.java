package micronaut3.test;

import io.micronaut.aop.Around;
import io.micronaut.context.annotation.AliasFor;
import io.micronaut.context.annotation.Type;
import io.micronaut.retry.annotation.DefaultRetryPredicate;
import io.micronaut.retry.annotation.RetryPredicate;
import io.micronaut.retry.annotation.Retryable;
import io.micronaut.retry.intercept.DefaultRetryInterceptor;

import javax.validation.constraints.Digits;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * AOP Advice that can be applied to any method.
 *
 * @author graemerocher
 * @since 1.0
 */
@Documented
@Retention(RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Around
@Type(DefaultRetryInterceptor.class)

////////////////////// New annotations added to the original annotation
@Retryable
@Inherited
/////////////////////
public @interface MyRetryable {

    int MAX_INTEGRAL_DIGITS = 4;

    /**
     * @return The exception types to include (defaults to all)
     */
    Class<? extends Throwable>[] value() default {};

    /**
     * @return The exception types to include (defaults to all)
     */
    @AliasFor(member = "value")
    Class<? extends Throwable>[] includes() default {};

    /**
     * @return The exception types to exclude (defaults to none)
     */
    Class<? extends Throwable>[] excludes() default {};

    /**
     * @return The maximum number of retry attempts
     */
    @Digits(integer = MAX_INTEGRAL_DIGITS, fraction = 0)
    String attempts() default "3";

    /**
     * @return The delay between retry attempts
     */
    String delay() default "1s";

    /**
     * @return The maximum overall delay
     */
    String maxDelay() default "";

    /**
     * @return The multiplier to use to calculate the delay
     */
    @Digits(integer = 2, fraction = 2)
    String multiplier() default "1.0";

    /**
     * @return The retry predicate class to use instead of {@link Retryable#includes} and {@link Retryable#excludes}
     * (defaults to none)
     */
    Class<? extends RetryPredicate> predicate() default DefaultRetryPredicate.class;
}

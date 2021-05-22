package com.souljit2.selleverything.annotation;

import com.souljit2.selleverything.annotation.validator.CategoryValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CategoryValidator.class)
public @interface Category {

    String message() default "incorrect category";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

package com.souljit2.selleverything.annotation.validator;

import com.souljit2.selleverything.annotation.Category;
import com.souljit2.selleverything.utils.Constants;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class CategoryValidator implements ConstraintValidator<Category, String> {

    @Override
    public boolean isValid(String input, ConstraintValidatorContext constraintValidatorContext) {
        return Constants.categories.get(
            input.toUpperCase()
        ) != null;
    }

}

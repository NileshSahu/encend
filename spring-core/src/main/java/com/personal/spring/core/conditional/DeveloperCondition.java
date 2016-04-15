package com.personal.spring.core.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by Nilesh on 3/20/2016.
 */
public class DeveloperCondition implements Condition {
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String roleProperty = conditionContext.getEnvironment().getProperty("role");
        return roleProperty.equalsIgnoreCase("Developer");
    }
}

package test.order_statemachine;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.statemachine.annotation.OnTransition;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@OnTransition
public @interface OrderStatesOnTransition {

  OrderStates[] source() default {};

  OrderStates[] target() default {};
}

package test.order_statemachine;

import java.util.EnumSet;

import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.statemachine.config.StateMachineBuilder.Builder;

public class StateMachineCustom {

  public StateMachine<OrderStates, OrderEvents> buildMachine() throws Exception {
    Builder<OrderStates, OrderEvents> builder = StateMachineBuilder.builder();
    builder.configureStates().withStates().initial(OrderStates.NEW).end(OrderStates.PACKED)
        .states(EnumSet.allOf(OrderStates.class));
    
    builder.configureTransitions()
    .withExternal()
    .source(OrderStates.NEW).target(OrderStates.PAID)
    .event(OrderEvents.PAYMENT)
    .and()
    .withExternal()
    .source(OrderStates.PAID).target(OrderStates.PACKED)
    .event(OrderEvents.PACK);
    
    return builder.build();
  }

}

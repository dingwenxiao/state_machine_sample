package test.order_statemachine;

import java.util.EnumSet;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

@Configuration
@EnableStateMachineFactory
public class Config1 extends EnumStateMachineConfigurerAdapter<OrderStates, OrderEvents> {

  @Override
  public void configure(StateMachineConfigurationConfigurer<OrderStates, OrderEvents> config)
          throws Exception {
      config
          .withConfiguration()
              .autoStartup(true);
  }
  
  @Override
  public void configure(StateMachineStateConfigurer<OrderStates, OrderEvents> states)
            throws Exception {
        states
            .withStates()
                .initial(OrderStates.NEW)
                .states(EnumSet.allOf(OrderStates.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<OrderStates, OrderEvents> transitions)
            throws Exception {
        transitions
            .withExternal()
                .source(OrderStates.NEW).target(OrderStates.PAID)
                .event(OrderEvents.PAYMENT)
                .and()
            .withExternal()
                .source(OrderStates.PAID).target(OrderStates.PACKED)
                .event(OrderEvents.PACK);
    }
}

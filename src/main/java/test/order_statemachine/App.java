package test.order_statemachine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App implements CommandLineRunner {
  
  @Autowired
  StateMachineFactory<OrderStates, OrderEvents> stateMachineFactory;
  
//  @Autowired
//  StateMachine<OrderStates, OrderEvents> stateMachine;

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }

  void doSignals() {
   // stateMachine.start();
    StateMachine<OrderStates, OrderEvents> stateMachine = stateMachineFactory.getStateMachine();
    stateMachine.start();
    stateMachine.getExtendedState().getVariables().put("test", "parameter pass");
    stateMachine.sendEvent(OrderEvents.PAYMENT);
    stateMachine.sendEvent(OrderEvents.PACK);
  }

  public void run(String... arg0) throws Exception {
    doSignals();
  }
}

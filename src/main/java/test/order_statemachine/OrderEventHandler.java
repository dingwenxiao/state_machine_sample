package test.order_statemachine;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.ExtendedState;
import org.springframework.statemachine.annotation.EventHeaders;
import org.springframework.statemachine.annotation.WithStateMachine;

@WithStateMachine
public class OrderEventHandler {
    @Autowired
    OrderService orderService;

    @OrderStatesOnTransition(source= OrderStates.NEW,target = OrderStates.PAID)
    public void handlePayment(@EventHeaders Map<String, Object> headers, ExtendedState extendedState) {
     System.out.println(extendedState.getVariables().get("test"));
      orderService.processOrder();
    }
    
    @OrderStatesOnTransition(source= OrderStates.PAID,target = OrderStates.PACKED)
    public void handlePack(@EventHeaders Map<String, Object> headers, ExtendedState extendedState) {
      orderService.packOrder();
    }
}

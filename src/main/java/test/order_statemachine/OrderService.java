package test.order_statemachine;

import org.springframework.stereotype.Component;

@Component
public class OrderService {
  
  public void processOrder() {
    System.out.println("processing order");
  }

  public void packOrder() {
    System.out.println("packing order");
  }

}

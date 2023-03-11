package org.university.ordersys;

import java.util.Arrays;

public class OrderApp {
  static int itemId = 1;
  public static void main(String[] args) {
    OrderSystem orderSystem = new OrderSystem();

    Item screws = new Item(itemId++, 2.5, "100pcs M2 8mm Screws");
    Item screwDriver = new Item(itemId++, 7, "Simple screw driver");
    Item nails = new Item(itemId++, 2.0, "20pcs 40 mm Nails");
    Item hammer = new Item(itemId++, 15, "Simple Hammer");
    Order screwOrder = new Order(screws, 10);
    orderSystem.addOrder(screwOrder);
    Order screwDriverOrder = new Order(screwDriver, 2);
    orderSystem.addOrder(screwDriverOrder);
    Order nailsOrderOne = new Order(nails, 1);
    orderSystem.addOrder(nailsOrderOne);
    Order nailsOrderTwo = new Order(nails, 1);
    orderSystem.addOrder(nailsOrderTwo);
    Order hammerOrder = new Order(hammer, 1);
    orderSystem.addOrder(hammerOrder);

    System.out.println("PRINTING ORDERS AFTER PART 1");
    Arrays.stream(orderSystem.getOrders()).forEach(System.out::println);

    orderSystem.changeOrder(screwOrder, Status.CANCELLED);
    orderSystem.changeOrder(screwDriverOrder, Status.PROCESSING);
    orderSystem.changeOrder(nailsOrderOne, Status.FULFILLED);
    orderSystem.changeOrder(nailsOrderTwo, Status.PROCESSING);
    orderSystem.changeOrder(hammerOrder, Status.FULFILLED);

    Item onehundredScrews = new Item(itemId++, 2.5, "100pcs M2 8mm Screws");
    Order screwSecondOrder = new Order(onehundredScrews, 1);
    orderSystem.addOrder(screwSecondOrder);

    System.out.println("PRINTING ORDERS AFTER PART 2");
    Arrays.stream(orderSystem.getOrders()).forEach(System.out::println);

    Order[] fullfilled = orderSystem.getOrdersByStatus(Status.FULFILLED);
    System.out.println("PRINTING ALL FULLFILLED ORDERS");
    Arrays.stream(fullfilled).forEach(System.out::println);

    Order[] nailOrders = orderSystem.getOrdersByItem(nails);
    System.out.println("PRINTING ALL NAIL ORDERS");
    Arrays.stream(nailOrders).forEach(System.out::println);

    System.out.println("PRINTING ALL OPEN ORDERS");
    Arrays.stream(orderSystem.getOpenOrders()).forEach(System.out::println);
  }
}

package org.university.ordersys;

import java.util.Arrays;

public class OrderSystem {
  private Item[] items = new Item[2];
  private int itemIndex = 0;
  private int itemId = 1;
  private Order[] orders = new Order[2];
  private int orderIndex = 0;

  public int addOrder(Order order) {
    if (orderIndex == orders.length) {
      this.orders = Arrays.copyOf(orders, orders.length * 2);
    }

    orders[orderIndex] = order;

    return orderIndex++;
  }

  public int deleteItem(Item itemToRemove) {
    int removedItemIndex = -1;
    for (int i = 0; i < items.length; i++) {
      if (items[i].equals(itemToRemove)) {
        items[i] = null;
        removedItemIndex = i;
        break;
      }
    }

    Item[] newItems = new Item[items.length -1];
    if (removedItemIndex > 0) {
     newItems = Arrays.copyOfRange(items, 0, removedItemIndex);
     System.arraycopy(items, removedItemIndex+1, newItems, removedItemIndex, items.length - 1);
    }

    this.items = newItems;
    return newItems.length;
  }

  public void changeOrder(Order order, Status status) {
      order.setStatus(status);
  }

  public Order[] getOrders() {
    Order[] returnOrder = Arrays.copyOfRange(orders, 0, orderIndex);
    return returnOrder;
  }

  public Order[] getOrdersByStatus(Status status) {
    Order[] copy = Arrays.copyOfRange(orders, 0, orderIndex);
    int newArrayCounter = 0;

    for (int i = 0; i < orderIndex; i++) {
      if (copy[i].status.equals(status)) {
        newArrayCounter++;
      }
    }

    if (newArrayCounter == 0) {
      return new Order[0];
    }

    Order[] newArray = new Order[newArrayCounter];
    int newArrayIndex = 0;
    for (int i = 0; i < copy.length; i++) {
      if (copy[i].status.equals(status)) {
        newArray[newArrayIndex++] = copy[i];
      }
    }

    return newArray;
  }

  public Order[] getOrdersByItem(Item item) {
    Order[] copy = Arrays.copyOfRange(orders, 0, orderIndex);
    int newArrayCounter = 0;

    for (Order order : copy) {
      if (order.getItem().equals(item)) {
        newArrayCounter++;
      }
    }

    if (newArrayCounter == 0) {
      return new Order[0];
    }

    Order[] newArray = new Order[newArrayCounter];
    int newArrayIndex = 0;
    for (int i = 0; i < copy.length; i++) {
      if (copy[i].getItem().equals(item)) {
        newArray[newArrayIndex++] = copy[i];
      }
    }

    return newArray;
  }

  public Order[] getOpenOrders() {
    Order[] copy = Arrays.copyOfRange(orders, 0, orderIndex);
    int newArrayCounter = 0;

    for (Order order : copy) {
      if (order.status != Status.FULFILLED && order.status != Status.CANCELLED) {
        newArrayCounter++;
      }
    }

    if (newArrayCounter == 0) {
      return new Order[0];
    }

    Order[] newArray = new Order[newArrayCounter];
    int newArrayIndex = 0;
    for (int i = 0; i < copy.length; i++) {
      if (orders[i].status != Status.FULFILLED && orders[i].status != Status.CANCELLED) {
        newArray[newArrayIndex++] = copy[i];
      }
    }

    return newArray;
  }
}

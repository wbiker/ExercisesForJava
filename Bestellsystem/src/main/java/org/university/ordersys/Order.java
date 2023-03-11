package org.university.ordersys;

public class Order {
  private Item item;
  protected Status status;
  private int anzahl;

  public Order(Item item, int anzahl) {
    this.item = item;
    this.anzahl = anzahl;
    this.status = Status.OPEN;
  }

  public Item getItem() {
    return item;
  }

  public Status getStatus() {
    return status;
  }

  public int getAnzahl() {
    return anzahl;
  }

  protected void setStatus(Status status) {
    this.status = status;
  }

  public double getPrice() {
    return item.price() * anzahl;
  }

  @Override
  public String toString() {
    return """
        Order{orderedItem=%s, quantity=%d, total=%.1f, status=%s}""".formatted(item.name(), anzahl, getPrice(), status);
  }
}

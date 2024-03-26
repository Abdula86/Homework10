package coffee.order;

import java.util.ArrayList;
import java.util.List;

public class CoffeeOrderBoard {
    private List<Order> orders;

    public CoffeeOrderBoard() {
        this.orders = new ArrayList<>();
    }

    public void add(Order order) {
        order.setOrderNumber(orders.size() + 1);
        orders.add(order);
    }

    public Order deliver() {
        if (!orders.isEmpty()) {
            return orders.remove(0);
        } else {
            return null;
        }
    }

    public Order deliverByNumber(int orderNumber) {
        for (Order order : orders) {
            if (order.getOrderNumber() == orderNumber) {
                orders.remove(order);
                return order;
            }
        }
        return null;
    }

    public void draw() {
        System.out.println("=============");
        System.out.println("Num | Name");
        for (Order order : orders) {
            System.out.println(order.getOrderNumber() + " | " + order.getName());
        }
        System.out.println("=============");
    }

    public static void main(String[] args) {
        CoffeeOrderBoard board = new CoffeeOrderBoard();
        board.add(new Order("Alen"));
        board.add(new Order("Yoda"));
        board.add(new Order("Obi-van"));
        board.add(new Order("John Snow"));

        board.draw();
    }
}

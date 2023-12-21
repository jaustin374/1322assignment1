import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        OrderList restaurantOrders = new OrderList();
        Scanner myScan = new Scanner(System.in);

        int menuSelection;

        do {
            System.out.println("1- Create order\n2- Delete order\n3- Ready order\n4- Print order\n" +
                    "5- Print all orders\n6- Exit");
            menuSelection = Integer.parseInt(myScan.nextLine());

            if (menuSelection == 1) {
                String[] order = new String[3];
                for (int i = 0; i < 3; i ++) {
                    System.out.print("Item "+ (i+1)+": ");
                    order[i] = myScan.nextLine();
                }
                Order newOrder = new Order(order);
                restaurantOrders.addOrder(newOrder);
                System.out.println("Order has been added.");
            }
            else if (menuSelection == 2) {
                System.out.print("Order id? ");
                int orderId = Integer.parseInt(myScan.nextLine());
                restaurantOrders.removeOrder(orderId);
                System.out.println("Order has been removed.");
            }
            else if (menuSelection == 3) {
                System.out.print("Order id? ");
                int orderId = Integer.parseInt(myScan.nextLine());
                restaurantOrders.readyOrder(orderId);
                System.out.println("Order has been set to \"Ready\"");
            }
            else if (menuSelection == 4) {
                System.out.print("Order id? ");
                int orderId = Integer.parseInt(myScan.nextLine());
                if (restaurantOrders.getOrder(orderId-1) == null) {
                    System.out.println("No order with such id.");
                }
                else {
                    System.out.println(restaurantOrders.printOrder(orderId));
                }
            }
            else if (menuSelection == 5) {
                restaurantOrders.printOrders();
            }
        } while (menuSelection != 6);
    }
}

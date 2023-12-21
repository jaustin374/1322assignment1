public class OrderList {
    private Order[] orderList;

    public OrderList() {
        orderList = new Order[1];
    }

    public void addOrder(Order order) {
        for (int i = 0; i < orderList.length; i++) {
            if (orderList[i] == null) {
                orderList[i] = order;
                return;
            }
        }
        int length = orderList.length;
        Order[] tempList = new Order[length];
        for (int i = 0; i < length; i ++) {
            tempList[i] = orderList[i];
        }
        orderList = new Order[length*2];
        for (int i = 0; i < length; i++) {
            orderList[i] = tempList[i];
        }
        orderList[length]=order;
    }

    public Order getOrder(int id) {
        if (orderList.length < id) {
            return null;
        }
        return orderList[id];
    }

    public void removeOrder(int id) {
        for (int i = 0; i < orderList.length; i++) {
            if (orderList[i].getId() == id) {
                orderList[i]  = null;
                return;
            }
        }
    }

    public void readyOrder(int id) {
        for (int i = 0; i < orderList.length; i++) {
            if (orderList[i].getId() == id) {
                orderList[i].ready = true;
                return;
            }
        }
    }

    private void sortOrders() {
        // this organizes the orders by ID, but the print orders prints them separating ready and preparing
        for (int i = 0; i < orderList.length; i ++) {
            int minPos = i;
            for (int j = i+1; j < orderList.length-1;j++) {
                if (orderList[j].getId() < orderList[minPos].getId()) {
                    minPos = j;
                }
            }
            if (i != minPos) {
                Order temp = orderList[minPos];
                orderList[minPos] = orderList[i];
                orderList[i] = temp;
            }
        }
    }

    public String printOrder(int id) {
        for (int i = 0; i < orderList.length; i++) {
            if (orderList[i].getId() == id) {
                return orderList[i].toString();
            }
        }
        return "";
    }

    public void printOrders() {
        sortOrders();
        System.out.println("READY");
        for (int i = 0; i < orderList.length; i++) {
            if (orderList[i] == null) {

            }
            else if (orderList[i].ready) {
                System.out.println(orderList[i].getId());
            }
        }
        System.out.println("PREPARING");
        for (int i = 0; i < orderList.length; i++) {
            if (orderList[i] == null) {

            }
            else if (!orderList[i].ready) {
                System.out.println(orderList[i].getId());
            }
        }
    }
}

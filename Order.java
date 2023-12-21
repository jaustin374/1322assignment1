public class Order {
    private int id;
    private static int nextId = 1;
    public boolean ready;
    public String[] items;

    public Order() {
        id = nextId;
        nextId++;
        ready = false;
        items = new String[3];
    }

    public Order(String[] i) {
        id = nextId;
        nextId++;
        ready = false;
        items = i;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        String toReturn = "Order number: "+getId()+"\n";
        if (ready) {
            toReturn += "Ready\n";
        }
        else {
            toReturn += "Not Ready\n";
        }
        for (int i = 0; i < items.length; i++) {
            toReturn += items[i]+"\n";
        }
        return toReturn;
    }
}

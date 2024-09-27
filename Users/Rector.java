package Users;

import java.io.Serializable;
import java.util.PriorityQueue;
import Attributes.Request;

public final class Rector extends Employee implements Serializable {
    private static Rector instance = null;
    private PriorityQueue<Request> orders = new PriorityQueue<>();

    private Rector(String password, String firstName, String lastName, int age) {
        super(password, firstName, lastName, age);
        this.setId(this.idGenerator());
        this.setUserName("ADMIN");
    }

    public static synchronized Rector getInstance() {
        if (instance == null) {
            instance = new Rector("RECTOR", "RECTOR", "RECTOR", 0);
        }
        return instance;
    }

    public void addOrder(Request request) {
        orders.add(request);
    }

    public boolean processOrder() {
        if (!orders.isEmpty()) {
            Request nextOrder = orders.poll();
            return true;
        }
        return false;
    }

    public Request getOrder() {
        return orders.peek();
    }

    @Override
    public String idGenerator() {
        return "RECTOR";
    }
}


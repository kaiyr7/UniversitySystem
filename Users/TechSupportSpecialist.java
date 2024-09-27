package Users;

import java.util.PriorityQueue;
import Attributes.Request;
import Enums.Priority;

public class TechSupportSpecialist extends Employee {
    private PriorityQueue<Request> orders = new PriorityQueue<>();

    public TechSupportSpecialist(String password, String firstName, String lastName, int age) {
        super(password, firstName, lastName, age);
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

}


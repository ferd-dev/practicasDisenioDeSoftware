import java.util.ArrayList;
import java.util.List;

class manageOrden {
    private List<Orden> orders;

    public manageOrden() {
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Orden orden) {
        orders.add(orden);
    }

    public void completeOrder(Orden orden) {
        orders.remove(orden);
    }
}

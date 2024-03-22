import java.util.ArrayList;
import java.util.List;

class Orden implements observable {
    private List<IMenu> items;
    private List<Observer> customers;

    public Orden() {
        this.items = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public void addItem(IMenu item) {
        items.add(item);
        notifyObserver();
    }

    public void deleteItem(IMenu item) {
        items.remove(item);
        notifyObserver();
    }

    public List<IMenu> getItems() {
        return items;
    }

    @Override
    public void addObserver(Observer observer) {
        customers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        customers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : customers) {
            observer.update();
        }
    }
}

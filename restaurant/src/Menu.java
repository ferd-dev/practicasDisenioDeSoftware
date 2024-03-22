import java.util.HashMap;
import java.util.Map;

class Menu {
    private Map<String, IMenu> items;

    public Menu() {
        this.items = new HashMap<>();
    }

    public void add(String name, IMenu item) {
        items.put(name, item);
    }

    public void delete(String name) {
        items.remove(name);
    }

    public IMenu getItem(String name) {
        return items.get(name);
    }

    public void show() {
        System.out.println("**************************");
        System.out.println("List Menu:");
        for (Map.Entry<String, IMenu> entry : items.entrySet()) {
            IMenu item = entry.getValue();
            System.out.println(item.getName() + " price: " + item.getPrice());
        }
    }
}

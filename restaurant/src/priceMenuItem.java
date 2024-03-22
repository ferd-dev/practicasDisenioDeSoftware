public class priceMenuItem implements IMenu {
    private String name;
    private double price;
    public priceMenuItem(String _name, double _price){
        this.name = _name;
        this.price = _price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}

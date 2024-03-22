public class Dron {
    private String name;
    private int capacity;
    private int actualWeight;
    public Dron(String _name, int _capacity){
        this.name = _name;
        this.capacity = _capacity;
        this.actualWeight = 0;
    }
    public boolean canLoad(int weight){
        return actualWeight + weight <= capacity;
    }
    public void load(int weight){
        actualWeight += weight;
    }
    public void reset(){
        actualWeight = 0;
    }
    public String getName(){
        return name;
    }
    public int getCapacity(){
        return capacity;
    }
    public int getActualWeight(){
        return actualWeight;
    }
}

import java.util.Comparator;

public class CompareWeight implements Comparator<Dron> {
    @Override
    public int compare(Dron dron1, Dron dron2) {
        return Integer.compare(dron1.getActualWeight(), dron2.getActualWeight());
    }
}

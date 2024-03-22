import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Dron> drones = ReadEntriesDrones.read(in);
        List<String[]> locations = ReadEntriesLocations.read(in);

        IAssignPackagesStrategy strategy = new AssignByWeight();
        strategy.assignPackages(drones, locations);

        IDelivery entrega = new ShowDelivery();
        entrega.show(drones, locations);
    }
}
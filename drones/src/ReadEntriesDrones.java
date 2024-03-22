import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ReadEntriesDrones {
    public static List<Dron> read(Scanner in) {
        List<Dron> drones = new ArrayList<>();
        String[] droninput=in.nextLine().split(", ");

        for (int i = 0; i < droninput.length; i++) {
            drones.add(new Dron(droninput[i], Integer.parseInt(droninput[i + 1])));
        }

        return drones;
    }
}

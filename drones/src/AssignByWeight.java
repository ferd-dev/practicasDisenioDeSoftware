import java.util.List;

public class AssignByWeight implements IAssignPackagesStrategy {
    @Override
    public void assignPackages(List<Dron> dron, List<String[]> locations) {
        dron.sort(new CompareWeight());
        for (String[] location : locations) {
            int weight = Integer.parseInt(location[1]);
            for (Dron drone : dron) {
                if (drone.canLoad(weight)) {
                    drone.load(weight);
                    break;
                }
            }
        }
    }
}

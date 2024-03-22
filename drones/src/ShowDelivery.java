import java.util.List;

public class ShowDelivery implements IDelivery {
    @Override
    public void show(List<Dron> drones, List<String[]> locations) {
        showDroneName(drones);
        assignDronesToLocations(drones, locations);
    }

    private static void showDroneName(List<Dron> drones) {
        for (Dron drone : drones) {
            System.out.println(drone.getName());
        }
    }

    private static void assignDronesToLocations(List<Dron> drones, List<String[]> locations) {
        for(int i = 0; i< drones.size(); i++){
            Dron drone = drones.get(i);
            System.out.println(drone.getName());
            assignTripsToDrone(locations, drone);
        }
    }

    private static void assignTripsToDrone(List<String[]> locations, Dron drone) {
        int tripNumber = 1;
        for (int j = 0; j < locations.size(); j++) {
            if (drone.canLoad(Integer.parseInt(locations.get(j)[1]))) {
                System.out.println("Trip #" + tripNumber++);
                System.out.println(locations.get(j)[0]);
                drone.load(Integer.parseInt(locations.get(j)[1]));
            }
        }
    }


}

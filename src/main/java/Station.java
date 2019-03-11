public class Station {
    private String name;
    private int zone;

    Station(String name, int zone) {
        this.name = name;
        this.zone = zone;
    }

    String getName() {
        return name;
    }

    int getZone() {
        return zone;
    }
}

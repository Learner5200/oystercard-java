import java.util.ArrayList;

class JourneyLog {
    ArrayList<Journey> journeys = new ArrayList<Journey>();

    public JourneyLog() {
    }

    ArrayList<Journey> getJourneys() {
        return new ArrayList<Journey>(journeys);
    }

    void add(Journey journey) {
        journeys.add(journey);
    }
}

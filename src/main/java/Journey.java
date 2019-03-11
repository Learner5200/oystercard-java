class Journey {
    private Station entryStation;
    private Station exitStation;
    private final int MINIMUM_FARE = 1;
    private final int PENALTY_FARE = 6;

    Journey(Station entryStation) {
        this.entryStation = entryStation;
    }

    public Station getEntryStation() {
        return entryStation;
    }

    public Station getExitStation() {
        return exitStation;
    }

    public void exit(Station exitStation) {
        this.exitStation = exitStation;
    }

    boolean isComplete() {
        return this.exitStation != null;
    }

    int calculateFare() {
        if (!isComplete()) return PENALTY_FARE;
        int zonesCrossed = Math.abs(entryStation.getZone() - exitStation.getZone());
        return MINIMUM_FARE + zonesCrossed;
    }


}

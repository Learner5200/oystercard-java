import java.util.ArrayList;

class Card {
    private Account account;
    private JourneyLog journeyLog;
    private Journey currentJourney;

    Card(Account account, JourneyLog journeyLog) {
        this.account = account;
        this.journeyLog = journeyLog;
    }

    int getBalance() {
        return this.account.getBalance();
    }

    ArrayList<Journey> getJourneyLog() {
        return this.journeyLog.getJourneys();
    }

    void topUp(int amount) throws Exception {
        this.account.topUp(amount);
    }

    void spend(int amount) throws Exception {
        this.account.spend(amount);
    }

    Journey getCurrentJourney() {
        return this.currentJourney;
    }

    void setCurrentJourney(Journey journey) {
        this.currentJourney = journey;
    }

    void touchIn(Station station) {
        setCurrentJourney(new Journey(station));
    }

    void touchOut(Station station) {
        currentJourney.exit(station);
    }

}

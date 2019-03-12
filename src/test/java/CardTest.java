import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CardTest {
    Account mockAccount;
    JourneyLog mockJourneyLog;
    Card card;

    @Before
    public void setUp() throws Exception {
        mockAccount = mock(Account.class);
        mockJourneyLog = mock(JourneyLog.class);
        card = new Card(mockAccount, mockJourneyLog);
    }


    @Test
    public void canDisplayBalanceFromAccount() {
        when(mockAccount.getBalance()).thenReturn(20);
        assertEquals(20, card.getBalance());
    }

    @Test
    public void canTopUpAccount() throws Exception {
        card.topUp(1);
        verify(mockAccount).topUp(1);
    }

    @Test
    public void canSpendFromAccount() throws Exception {
        card.spend(1);
        verify(mockAccount).spend(1);
    }

    @Test
    public void canDisplayJourneyLog() {
        Journey mockJourney1 = mock(Journey.class);
        Journey mockJourney2 = mock(Journey.class);
        ArrayList<Journey> mockLog = new ArrayList<Journey>(Arrays.asList(mockJourney1, mockJourney2));
        when(mockJourneyLog.getJourneys()).thenReturn(mockLog);
        assertEquals(mockLog, card.getJourneyLog());
    }

    @Test
    public void touchingInCreatesNewJourney() {
        Station mockStation1 = mock(Station.class);
        card.touchIn(mockStation1);
        Journey currentJourney = card.getCurrentJourney();
        assertEquals(mockStation1, currentJourney.getEntryStation());
    }

    @Test
    public void touchingOutUpdatesCurrentJourney() {
//        Station mockStation1 = mock(Station.class);
//        Station mockStation2 = mock(Station.class);
//        card.touchIn(mockStation1);
//        Journey currentJourneySpy = spy(card.getCurrentJourney());
//        card.touchOut(mockStation2);
//        verify(currentJourneySpy).exit(mockStation2);
    }

    @Test
    public void touchingOutSpendsFare() {
        Station mockStation1 = mock(Station.class);
        Station mockStation2 = mock(Station.class);
        card.touchIn(mockStation1);
        card.touchOut(mockStation2);
        int fare = card.getCurrentJourney().calculateFare();

    }
}
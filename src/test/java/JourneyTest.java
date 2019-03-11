import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JourneyTest {
    Journey journey;
    Station entryStation;
    Station exitStation;

    @Before
    public void setUp() throws Exception {
        entryStation = mock(Station.class);
        when(entryStation.getZone()).thenReturn(4);
        journey = new Journey(entryStation);
        exitStation = mock(Station.class);
    }

    @Test
    public void initializesWithEntryStation() {
        assertEquals(entryStation, journey.getEntryStation());
    }

    @Test
    public void setsExitStationAfterExiting() {
        journey.exit(exitStation);
        assertEquals(exitStation, journey.getExitStation());
    }

    @Test
    public void isCompleteAfterExiting() {
        journey.exit(exitStation);
        assertTrue(journey.isComplete());
    }

    @Test
    public void isNotCompleteBeforeExiting() {
        assertFalse(journey.isComplete());
    }

    @Test
    public void givesFareOf1WhenTravellingAcross0Zones() {
        when(exitStation.getZone()).thenReturn(4);
        journey.exit(exitStation);
        assertEquals(1, journey.calculateFare());
    }

    @Test
    public void givesFareOf4WhenTravellingAcross3Zones() {
        when(exitStation.getZone()).thenReturn(1);
        journey.exit(exitStation);
        assertEquals(4, journey.calculateFare());
    }
}
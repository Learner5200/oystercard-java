import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class JourneyLogTest {
    JourneyLog log;
    @Before
    public void setUp() throws Exception {
        log = new JourneyLog();
    }

    @Test
    public void beginsEmpty() {
        ArrayList<Journey> expected = new ArrayList<Journey>();
        assertEquals(expected, log.getJourneys());
    }

    @Test
    public void canAddJourneyToLog() {
        Journey journey1 = mock(Journey.class);
        Journey journey2 = mock(Journey.class);
        log.add(journey1);
        log.add(journey2);
        ArrayList<Journey> expected = new ArrayList<Journey>(Arrays.asList(journey1, journey2));
        assertEquals(expected, log.getJourneys());
    }
}
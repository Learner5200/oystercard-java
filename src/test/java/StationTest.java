import org.junit.Test;

import static org.junit.Assert.*;

public class StationTest {

    @Test
    public void canSpecifyNameAndZone() {
        Station station = new Station("Hampstead", 2);
        assertEquals("Hampstead", station.getName());
        assertEquals(2, station.getZone());
    }
}
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class CardTest {

    @Before
    public void setUp() throws Exception {
        Account mockAccount = mock(Account.class);
        Card card = new Card(mockAccount);
    }

    @Test
    public void name() {
    }
}
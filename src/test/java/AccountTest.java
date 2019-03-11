import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
    private Account account;

    @org.junit.Before
    public void setUp() {
        account = new Account();
    }

    @Test
    public void cardStartsWithZeroBalance() {
        int expected = 0;
        int actual = account.getBalance();
        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void canSetStartingBalance() {
        account = new Account(10, 50);
        int actual = account.getBalance();
        int expected = 10;
        assertEquals(expected, actual);
    }

    @Test
    public void canTopUpBalance() throws Exception{
        account.topUp(5);
        assertEquals(5, account.getBalance());
    }

    @Test(expected = LimitExceededException.class)
    public void cannotTopUpBalanceAboveLimit() throws Exception {
        account.topUp(51);
        assertEquals(0, account.getBalance());
    }

    @Test(expected = LimitExceededException.class)
    public void canSetLimitAtConstruction() throws Exception {
        account = new Account(0, 5);
        account.topUp(6);
        assertEquals(0, account.getBalance());
    }

    @Test
    public void canSpendBalance() throws Exception {
        account.topUp(15);
        account.spend(5);
        assertEquals(10, account.getBalance());
    }

    @Test(expected = InsufficientFundsException.class)
    public void cannotReduceBalanceBelow0() throws Exception {
        account.topUp(1);
        account.spend(2);
        assertEquals(1, account.getBalance());
    }

}
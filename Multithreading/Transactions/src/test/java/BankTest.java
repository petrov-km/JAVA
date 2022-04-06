import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

public class BankTest extends TestCase {
    Account acc;
    @Override
    protected void setUp() throws Exception {
       Bank.createAccounts();
    }

   /* public void testGetBalance() {
        long actual = Bank.getBalance("2");
        long expected = 100000;
        assertEquals(expected, actual);
    }*/
    public void testTransfer(){
        long n = Bank.getSumAllAccounts();
        Bank.runThreadsOfTransfers();
        long actual = Bank.getSumAllAccounts();
        long expected = n;
        assertEquals(expected, actual);
    }

}

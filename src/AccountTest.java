import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class AccountTest {
    private Accounting accounting;

    @Before
    public void before() {
        accounting = new Accounting();
    }

    @Test
    public void testWholeMonth() {

        accounting.setBudgets(Arrays.asList(
                new Budget("202010",31))
        );


        assertEquals(BigDecimal.valueOf(31), accounting.totalAmount("20201001", "20201031"));
    }

    @Test
    public void testOneday() {

        accounting.setBudgets(Arrays.asList(
                new Budget("202010",31))
        );


        assertEquals(BigDecimal.valueOf(1), accounting.totalAmount("20201001", "20201001"));
    }
}

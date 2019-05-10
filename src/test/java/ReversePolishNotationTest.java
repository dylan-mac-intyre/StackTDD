import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReversePolishNotationTest {

    ReversePolishNotation rpn;

    @Before
    public void setUp() throws Exception {
        rpn = new ReversePolishNotation();
    }

    @Test
    public void testIsANumber() {
        assertTrue(rpn.isANumber("1"));
    }

    @Test
    public void testIsNotANumber() {
        assertFalse(rpn.isANumber("+"));
    }

    @Test
    public void testOneNumberReturnsCorrectly() {
        assertEquals("1", rpn.performCalculation("1"));
    }

    @Test
    public void testCalculationReturnsTwo() {
        assertEquals("2", rpn.performCalculation("1 1 +"));
    }

    @Test
    public void testCalculationReturnsOne() {
        assertEquals("1", rpn.performCalculation("2 1 -"));
    }

    @Test
    public void testCalculationReturnsEight() {
        assertEquals("8", rpn.performCalculation("4 2 *"));
    }

    @Test
    public void testCalculationReturnsTen() {
        assertEquals("10", rpn.performCalculation("20 2 /"));
    }

    @Test
    public void testLongCalculation() {
        assertEquals("-192", rpn.performCalculation("10 20 + 2 14 16 * - +"));
    }

    @Test
    public void testIncorrectOperator() {
        assertEquals("Error: Incorrect Format", rpn.performCalculation("10 20 ?"));
    }

    @Test
    public void testIncorrectFormat() {
        assertEquals("Error: Incorrect Format", rpn.performCalculation("1 1 + 1"));
    }

    @Test
    public void testIncorrectFormat2() {
        assertEquals("Error: Incorrect Format", rpn.performCalculation("1 1 + +"));
    }



}
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {
    Stack emptyStack = new Stack();
    Stack notEmptyStack = new Stack();

    @Before
    public void setUp() throws Exception {
        notEmptyStack.push("1");
        notEmptyStack.push("2");
    }

    @Test
    public void stackIsEmptyTrue() throws Exception {
        assertTrue(emptyStack.isEmpty());
        assertFalse(notEmptyStack.isEmpty());
    }

    @Test
    public void testSize() throws Exception {
        assertEquals(0, emptyStack.size());
        assertTrue(notEmptyStack.size() > 0);
    }


    @Test
    public void testContains() throws Exception {
        assertFalse(emptyStack.contains("1"));
        assertFalse(emptyStack.contains("2"));
        assertTrue(notEmptyStack.contains("1"));
        assertTrue(notEmptyStack.contains("2"));
    }

    @Test
    public void testPeek() throws Exception {
        assertEquals(null, emptyStack.peek());
        assertEquals("2", notEmptyStack.peek());
        assertEquals(2, notEmptyStack.size());
    }

    @Test
    public void testPop() throws Exception {
        Stack aStack = new Stack();
        aStack.push("1");
        aStack.push("2");

        assertEquals(null, emptyStack.pop());
        assertEquals("2", aStack.pop());
        assertEquals(1, aStack.size());
        assertFalse(aStack.contains("2"));
        assertEquals("1", aStack.pop());
        assertEquals(0, aStack.size());
        assertEquals(null, aStack.pop());
    }

    @Test
    public void testGrows() throws Exception {
        Stack aStack = new Stack(1);
        aStack.push("1");
        aStack.push("2");

        assertEquals(2, aStack.size());
    }

}
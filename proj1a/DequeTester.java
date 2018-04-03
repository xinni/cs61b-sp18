import org.junit.Test;
import static org.junit.Assert.*;

public class DequeTester {
    @Test
    public void checkEmptyTest() {
        ArrayDeque input = new ArrayDeque();
        assertTrue(input.isEmpty());

        input.addLast("last");
        assertEquals(1, input.size());
        input.printDeque();
    }

    @Test
    public void addFirstTest() {
        String[] a = new String[]{"Hello", "World", "!", "I", "am", "the", "king", "of", "the", "world"};
        String[] b = new String[]{"God", "Hello", "World", "!", "I", "am", "the", "king", "of", "the", "world"};
        ArrayDeque input = new ArrayDeque(a);
        assertEquals(10, input.size());
        ArrayDeque exp = new ArrayDeque(b);
        input.addFist("God");
        assertEquals(11, input.size());

        assertEquals("God", input.removeFirst());
        assertEquals("world", input.removeLast());
//        input.printDeque();
//        exp.printDeque();
    }
}

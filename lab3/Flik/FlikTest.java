import org.junit.Test;
import static org.junit.Assert.*;

public class FlikTest {
    @Test
    public void testSameNumber() {
        assertTrue(Flik.isSameNumber(127,127));
        assertTrue(Flik.isSameNumber(128,128));
    }

    @Test
    public void testEqual() {
        Integer a = 128;
        Integer b = 128;
        assertTrue(a == b);
    }

}

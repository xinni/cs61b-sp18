package hw2;
import org.junit.Test;
import static org.junit.Assert.*;

public class PercolationTester {
    @Test
    public void checkPercolationTest() {
        Percolation tester = new Percolation(5);
        tester.open(0,1);
        tester.open(1,1);
        tester.open(2,1);
        tester.open(3,1);
        tester.open(4,1);

        tester.isOpen(0,2);
        tester.isOpen(1,1);
        tester.isFull(0,1);

        assertTrue(tester.isOpen(0,1));
        assertFalse(tester.isOpen(0,2));
        assertTrue(tester.isOpen(1,1));
        assertTrue(tester.isFull(0,1));
        assertTrue(tester.isFull(1,1));
        assertTrue(tester.isFull(2,1));
        assertTrue(tester.isFull(3,1));
        assertTrue(tester.isFull(4,1));

        assertTrue(tester.percolates());
    }

}
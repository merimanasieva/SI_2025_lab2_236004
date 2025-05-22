import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Arrays;

public class SILab2Test {

    @Test
    public void testEveryStatement() {
        // Test 1: allItems = null
        RuntimeException ex1 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(null, "1234567890123456")
        );
        assertEquals("allItems list can't be null!", ex1.getMessage());

        // Test 2: item with null name
        Item item2 = new Item(null, 1, 100, 0);
        RuntimeException ex2 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(List.of(item2), "1234567890123456")
        );
        assertEquals("Invalid item!", ex2.getMessage());

        // Test 3: valid input
        Item item3 = new Item("Soap", 5, 100, 0.2);
        double result = SILab2.checkCart(List.of(item3), "1234567890123456");
        assertEquals(370.0, result);
    }

    @Test
    public void testMultipleCondition() {
        // 8 combinations
        Item i1 = new Item("a", 1, 100, 0); // F, F, F
        Item i2 = new Item("a", 1, 400, 0); // T, F, F
        Item i3 = new Item("a", 1, 100, 0.1); // F, T, F
        Item i4 = new Item("a", 11, 100, 0); // F, F, T
        Item i5 = new Item("a", 1, 400, 0.1); // T, T, F
        Item i6 = new Item("a", 12, 400, 0); // T, F, T
        Item i7 = new Item("a", 15, 100, 0.1); // F, T, T
        Item i8 = new Item("a", 12, 400, 0.1); // T, T, T

        List<Item> items = Arrays.asList(i1, i2, i3, i4, i5, i6, i7, i8);
        double result = SILab2.checkCart(items, "1234567890123456");

        // Each of i2-i8 triggers -30 penalty, so 7 * (-30) = -210
        // Prices (with discount or not)
        double expected =
                100 +                  // i1
                        -30 + 400 +           // i2
                        -30 + 90 +            // i3
                        -30 + 1200 +          // i4
                        -30 + 400 * 0.9 +     // i5
                        -30 + 400 * 12 +      // i6
                        -30 + 100 * 0.9 * 15 +// i7
                        -30 + 400 * 0.9 * 12; // i8

        assertEquals(expected, result, 0.01);
    }
}

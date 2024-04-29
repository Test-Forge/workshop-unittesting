package day_one.assertj;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ListTransformerTest {

    // AssertJ provides improved readability compared to JUnit assertions
    private ListTransformer listTransformer;

    @BeforeEach
    public void setup() {
        listTransformer = new ListTransformer();
    }

    @Test
    public void containsLetterTest() {
        Item a = new Item(10, "raspberry");
        Item b = new Item(2, "banana");
        Item c = new Item(1, "apricot");
        List<Item> items = Arrays.asList(a, b, c);

        CharSequence cs = "b";
        List<Item> itemsWithB = listTransformer.containsLetter(cs, items);
        List<Item> expected = Arrays.asList(a, b);

        // assertions with JUnit
        assertNotNull(itemsWithB);
        assertEquals(2, itemsWithB.size());
        assertEquals(expected, itemsWithB);

        // assertions with AssertJ
        assertThat(itemsWithB)
                .hasSize(2)
                .hasSameElementsAs(expected);

    }

    @Test
    public void containsLetterAndSortTest() {
        Item a = new Item(10, "raspberry");
        Item b = new Item(2, "banana");
        Item c = new Item(1, "apricot");
        List<Item> items = Arrays.asList(a, b, c);

        CharSequence cs = "b";
        List<Item> itemsWithB = listTransformer.containsLetterAndSort(cs, items);
        List<Item> expected = Arrays.asList(a, b);

        // assertions with JUnit
//        assertNotNull(itemsWithB);
//        assertEquals(2, itemsWithB.size());
//        assertEquals(expected, itemsWithB);

        // assertions with AssertJ - asserts in any order
//        assertThat(itemsWithB)
//                .hasSize(2)
//                .hasSameElementsAs(expected);


        // assertions with AssertJ - asserts according an order
//        assertThat(itemsWithB)
//                .hasSize(2)
//                .hasSameElementsAs(expected)
//                .isSortedAccordingTo(Item::compareTo);

        Comparator<Item> comparator = Comparator.comparing(Item::getDescription).reversed();
        // assertions with AssertJ - asserts according an order
//        assertThat(itemsWithB)
//                .hasSize(2)
//                .hasSameElementsAs(expected)
//                .isSortedAccordingTo(comparator);

        // assertions with AssertJ - asserts against expected
        assertThat(itemsWithB).containsExactlyElementsOf(expected);
    }

}
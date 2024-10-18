package junit.homework.asserting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static junit.homework.asserting.StringUtils.removeVowels;
import static junit.homework.asserting.StringUtils.reverseString;
import static junit.homework.asserting.StringUtils.splitAndRemoveEmptyStrings;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class StringUtilsTest {

    @Test
    @DisplayName("reverseString() should return the reverse of the given string")
    void testReverseString() {
        // TODO: Write an assertEquals assertion
        assertEquals("cba", reverseString("abc"));
    }

    @Test
    @DisplayName("reverseString() should return an empty string for an empty string")
    void testReverseStringEmptyString() {
        // TODO: Write an assertEquals assertion
        assertEquals("", reverseString(""));
    }

    @Test
    @DisplayName("reverseString() should return null for a null string")
    void testReverseStringNullString() {
        // TODO: Write an assertNull assertion
        assertNull(reverseString(null));
    }

    @Test
    @DisplayName("reverseString() should not return the original string for non-empty and non-null input")
    void testReverseStringNotOriginal() {
        assertFalse(!"sca".equals(reverseString("acs")));
        // TODO: Write an assertFalse assertion
        assertFalse("hello".equals(reverseString("hello")));
    }

    @Test
    @DisplayName("removeVowels() should remove all vowels from the given string")
    void testRemoveVowels() {
        // TODO: Write an assertNotEquals assertion
        assertNotEquals("anyText", removeVowels("anyText"));
    }

    @Test
    @DisplayName("removeVowels() should return an empty string for a string containing only vowels")
    void testRemoveVowelsAllVowels() {
        // TODO: Write an assertEquals assertion
        assertEquals("", removeVowels("aeiou"));
    }

    @Test
    @DisplayName("removeVowels() should return the same string for a string without vowels")
    void testRemoveVowelsNoVowels() {
        // TODO: Write an assertSame assertion
        assertSame("bcdfg", removeVowels("bcdfg"));
    }

    @Test
    @DisplayName("splitAndRemoveEmptyStrings() should split the string by commas and remove empty strings")
    void testSplitAndRemoveEmptyStrings() {
        List<String> expected = Arrays.asList("apple", "banana", "cherry");
        // TODO: Write an assertIterableEquals assertion
        assertIterableEquals(expected, splitAndRemoveEmptyStrings("apple,banana,cherry"));
        assertIterableEquals(expected, splitAndRemoveEmptyStrings("apple,banana,,,,cherry"));
    }

    @Test
    @DisplayName("splitAndRemoveEmptyStrings() should return an empty list for an empty string")
    void testSplitAndRemoveEmptyStringsEmptyString() {
        // TODO: Write an assertTrue assertion
        assertTrue(splitAndRemoveEmptyStrings("").isEmpty());
    }

    @Test
    @DisplayName("splitAndRemoveEmptyStrings() should return an empty list for a null string")
    void testSplitAndRemoveEmptyStringsNullString() {
        // TODO: Write an assertNotNull assertion
        assertNotNull(splitAndRemoveEmptyStrings(null));
    }

    @Test
    @DisplayName("splitAndRemoveEmptyStrings() should return the same list for a string without commas")
    void testSplitAndRemoveEmptyStringsNoCommas() {
        List<String> expected = List.of("hello");
        // TODO: Write an assertArrayEquals assertion
        assertArrayEquals(expected.toArray(), splitAndRemoveEmptyStrings("hello").toArray());
    }

    @Test
    @DisplayName("splitAndRemoveEmptyStrings() should throw an exception for a null string")
    void testSplitAndRemoveEmptyStringsNullStringException() {
        // TODO: Write an assertThrows assertion
        assertThrows(NoSuchElementException.class, () -> splitAndRemoveEmptyStrings(null).getFirst());
        assertThrows(IndexOutOfBoundsException.class, () -> splitAndRemoveEmptyStrings(null).get(10));
    }

    @Test
    @DisplayName("splitAndRemoveEmptyStrings() should not throw an exception for an empty string")
    void testSplitAndRemoveEmptyStringsEmptyStringNoException() {
        // TODO: Write an assertDoesNotThrow assertion
        assertDoesNotThrow(() -> splitAndRemoveEmptyStrings(""));
    }

    @Test
    @DisplayName("splitAndRemoveEmptyStrings() should fail if the input contains invalid characters")
    void testSplitAndRemoveEmptyStringsInvalidInput() {
        // TODO: Write a fail assertion with message
        fail("This test should fail because the input contains invalid characters.");
    }

    @Test
    @DisplayName("splitAndRemoveEmptyStrings() should return the correct list for a string with multiple commas")
    void testSplitAndRemoveEmptyStringsMultipleCommas() {
        List<String> expected = Arrays.asList("apple", "banana", "cherry", "date");
        // TODO: Write an assertLinesMatch assertion
        assertLinesMatch(expected, splitAndRemoveEmptyStrings("apple,,banana,cherry,date"));
    }
}

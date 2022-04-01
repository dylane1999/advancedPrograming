import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Homework7Test {

    public static void test_fizzbuzz_negativeInput() {
        assertThrows(IllegalArgumentException.class, () -> Homework7.fizzbuzz(-5));
    }

    public static void test_fizzbuzz_happyPath() {
        Homework7.fizzbuzz(5); // should print 1 2 Fizz 4 Buzz
        Homework7.fizzbuzz(15); // should print 1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz
    }

    public static void test_oddSum_happyPath() {
        assertEquals(4, Homework7.oddSum(1, 3));
        assertEquals(8, Homework7.oddSum(-2, 5));

    }

    public static void test_oddSum_endLessThanStart() {
        assertThrows(IllegalArgumentException.class, () -> Homework7.oddSum(4, -5));
    }

    public static void test_oddSum_sameEndAndStart() {
        assertEquals(0, Homework7.oddSum(1, 1));
    }

    public static void test_countChar_emptyInput() {
        assertEquals(0, Homework7.countChar("", 'B'));
    }

    public static void test_countChar_noOccurances() {
        assertEquals(0, Homework7.countChar("ajflifnvnmgnkfmvkzlcmlioskd", 'B'));
    }

    public static void test_countChar_hapyPath() {
        assertEquals(3, Homework7.countChar("XaaaYaaaZaaaYaaaaY", 'Y'));
        assertEquals(13, Homework7.countChar("XaaaYaaaZaaaYaaaaY", 'a'));
    }

    public static void test_isPalindrome_happyPath() {
        assertTrue(Homework7.isPalindrome("go", "og"));
        assertFalse(Homework7.isPalindrome("banana", "nanaba"));
    }

    public static void test_isPalindrome_emptyInput() {
        assertTrue(Homework7.isPalindrome("go", "og"));
        assertFalse(Homework7.isPalindrome("banana", "nanaba"));
    }

    public static void test_isPalindrome_capitalizationDifferences() {
        assertTrue(Homework7.isPalindrome("cat", "TAC"));
    }

    public static void test_combination() {
        assertEquals(3003, Homework7.combination(15, 5));
        assertEquals(15, Homework7.combination(6, 2));
        assertEquals(0, Homework7.combination(1, 2));
        assertEquals(3, Homework7.combination(3, 2));

    }

    public static void main(String[] args) {
        test_fizzbuzz_negativeInput();
        test_fizzbuzz_happyPath();
        test_oddSum_happyPath();
        test_oddSum_endLessThanStart();
        test_oddSum_sameEndAndStart();
        test_countChar_emptyInput();
        test_countChar_noOccurances();
        test_countChar_hapyPath();
        test_isPalindrome_happyPath();
        test_isPalindrome_emptyInput();
        test_isPalindrome_capitalizationDifferences();
        test_combination();
        System.out.println("---- TESTS COMPLETE ----");
    }
}

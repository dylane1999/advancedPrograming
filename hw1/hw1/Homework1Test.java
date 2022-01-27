package hw1;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Homework1Test {

    public static void test_insertAfterVowels_nonLowercaseBasestring() {
        String baseString = "HELLO";
        String insertString = "insert";
        assertThrows(RuntimeException.class, () -> Homework1.insertAfterVowels(baseString, insertString));
    }

    public static void test_insertAfterVowels_happyPath() {
        String baseString = "hello";
        String insertString = "XYZ";
        String expectedResult = "heXYZlloXYZ";
        String actualResult = Homework1.insertAfterVowels(baseString, insertString);
        assertEquals(expectedResult, actualResult, "check that we get the correct substitution");
    }

    public static void test_insertAfterVowels_noInputString() {
        String baseString = "hello";
        String insertString = "";
        String actualResult = Homework1.insertAfterVowels(baseString, insertString);
        assertEquals(baseString, actualResult, "check that we get the correct substitution");
    }

    public static void test_insertAfterVowels_noBaseString() {
        String baseString = "";
        String insertString = "XYZ";
        String expectedResult = "";
        String actualResult = Homework1.insertAfterVowels(baseString, insertString);
        assertEquals(expectedResult, actualResult, "check that we get the correct substitution");
    }

    public static void test_addInString_emptyString() {
        String input = "";
        Integer expectedResult = 0;
        Integer actualResult = Homework1.addInString(input);
        assertEquals(expectedResult, actualResult);
    }

    public static void test_addInString_StringHasNoNumbers() {
        String input = "hello";
        Integer expectedResult = 0;
        Integer actualResult = Homework1.addInString(input);
        assertEquals(expectedResult, actualResult);

    }

    public static void test_addInString_onlyNumbers() {
        String input = "123";
        Integer expectedResult = 6;
        Integer actualResult = Homework1.addInString(input);
        assertEquals(expectedResult, actualResult);
    }

    public static void test_addInString_happyPath() {
        String input = "he12l41o5";
        Integer expectedResult = 13;
        Integer actualResult = Homework1.addInString(input);
        assertEquals(expectedResult, actualResult);
    }

    public static void test_deleteByIndex_outOfRange() {
        String inputString = "hello";
        Integer index = 1000;
        assertThrows(IndexOutOfBoundsException.class, () -> Homework1.deleteByIndex(inputString, index));
    }

    public static void test_deleteByIndex_happyPath() {
        String inputString = "hello";
        String expectedOutput = "helo";
        Integer index = 2;
        String actualResult = Homework1.deleteByIndex(inputString, index);
        assertEquals(expectedOutput, actualResult);
    }

    public static void test_deleteByIndex_emptyString() {
        String inputString = "";
        Integer index = 1;
        assertThrows(IndexOutOfBoundsException.class, () -> Homework1.deleteByIndex(inputString, index));
    }

    public static void test_passwordChecker_tooShort() {
        String password = "Fj5!";
        boolean isValid = Homework1.passwordChecker(password);
        assertFalse(isValid);
    }

    public static void test_passwordChecker_noNumbers() {
        String password = "gkdHITIUjasdfo!";
        boolean isValid = Homework1.passwordChecker(password);
        assertFalse(isValid);
    }

    public static void test_passwordChecker_noCapitals() {
        String password = "lkjadfkljadkf09435904354903j!";
        boolean isValid = Homework1.passwordChecker(password);
        assertFalse(isValid);
    }

    public static void test_passwordChecker_happyPath() {
        String password = "afjDFt848hIU!";
        boolean isValid = Homework1.passwordChecker(password);
        assertTrue(isValid);
    }

    public static void test_passwordChecker_emptyPassword() {
        String password = "!";
        boolean isValid = Homework1.passwordChecker(password);
        assertFalse(isValid);
    }

    public static void test_countTriple_emptyInput() {
        String inputString = "";
        Integer expectedNumTriples = 0;
        Integer actualNumTriples = Homework1.countTriple(inputString);
        assertEquals(expectedNumTriples, actualNumTriples);
    }

    public static void test_countTriple_happyPath() {
        String inputString = "xxxabyyyycd";
        Integer expectedNumTriples = 3;
        Integer actualNumTriples = Homework1.countTriple(inputString);
        assertEquals(expectedNumTriples, actualNumTriples);

    }

    public static void test_countTriple_TripleChain() {
        String inputString = "iiiiiiii"; // 8 i's in a row -> 1 + (8-3) -> 6 triples
        Integer expectedNumTriples = 6;
        Integer actualNumTriples = Homework1.countTriple(inputString);
        assertEquals(expectedNumTriples, actualNumTriples);

    }

    public static void test_countTriple_noTriples() {
        String inputString = "hello there";
        Integer expectedNumTriples = 0;
        Integer actualNumTriples = Homework1.countTriple(inputString);
        assertEquals(expectedNumTriples, actualNumTriples);

    }

    // A number is prime if it cannot evenly be divided by anything between 1 and
    // itself, except for 1 and itself. If the input is 0 or negative, throw an
    // IllegalArgumentException.
    public static void test_isPrime_zeroInput() {
        Integer input = 0;
        assertThrows(IllegalArgumentException.class, () -> Homework1.isPrime(input));
    }

    public static void test_isPrime_negativeInput() {
        Integer input = -5;
        assertThrows(IllegalArgumentException.class, () -> Homework1.isPrime(input));
    }

    public static void test_isPrime_primeInput() {
        Integer input = 5;
        boolean isPrime = Homework1.isPrime(input);
        assertTrue(isPrime);
    }

    public static void test_isPrime_compositeInput() {
        Integer input = 4;
        boolean isPrime = Homework1.isPrime(input);
        assertFalse(isPrime);
    }

    public static void test_nameFormatter_emptyInput() {
        String inputName = "";
        assertThrows(IllegalArgumentException.class, ()-> Homework1.nameFormatter(inputName));
    }

    public static void test_nameFormatter_oneWordOnlyName() {
        String inputName = "Stephen";
        assertThrows(IllegalArgumentException.class, ()-> Homework1.nameFormatter(inputName));
    }

    public static void test_nameFormatter_firstAndLast() {
        String inputName = "Stephen Strange";
        String expectedOutput = String.join("\n", "The full name is: Strange, Stephen.", "The initial is: SS.",
                "The name contains 14 characters, excluding the space.", "Welcome, Stephen!");
        String actualOutput = Homework1.nameFormatter(inputName);
        assertEquals(expectedOutput, actualOutput);
    }

    public static void main(String[] args) {
        // insertAfterVowels tests
        test_insertAfterVowels_nonLowercaseBasestring();
        test_insertAfterVowels_happyPath();
        test_insertAfterVowels_noInputString();
        test_insertAfterVowels_noBaseString();
        // addInString tests
        test_addInString_emptyString();
        test_addInString_StringHasNoNumbers();
        test_addInString_onlyNumbers();
        test_addInString_happyPath();
        // deleteByIndex tests
        test_deleteByIndex_outOfRange();
        test_deleteByIndex_happyPath();
        test_deleteByIndex_emptyString();
        // passwordChecker tests
        test_passwordChecker_tooShort();
        test_passwordChecker_noNumbers();
        test_passwordChecker_noCapitals();
        test_passwordChecker_happyPath();
        test_passwordChecker_emptyPassword();
        // countTriple tests
        test_countTriple_emptyInput();
        test_countTriple_happyPath();
        test_countTriple_TripleChain();
        test_countTriple_noTriples();
        // isPrime test
        test_isPrime_zeroInput();
        test_isPrime_negativeInput();
        test_isPrime_primeInput();
        test_isPrime_compositeInput();

        System.out.println("------- TESTS COMPLETED ------");

    }

}

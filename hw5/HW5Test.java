import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HW5Test {

    public static void test_reverseNumbers_happyPath() {
        double[] expectedResult = new double[] { 4.0, -3.4, 9.9, 3.2, 1.9 };
        double[] inpurArr = new double[] { 1.9, 3.2, 9.9, -3.4, 4.0 };
        double[] actualResult = Homework5.reverseNumbers(inpurArr);
        assertArrayEquals(expectedResult, actualResult);
    }

    public static void test_reverseNumbers_emptyInput() {
        double[] expectedResult = new double[] {};
        double[] inpurArr = new double[] {};
        double[] actualResult = Homework5.reverseNumbers(inpurArr);
        assertArrayEquals(expectedResult, actualResult);
    }

    public static void test_reverseNumbers_oneItem() {
        double[] expectedResult = new double[] { 3 };
        double[] inpurArr = new double[] { 3 };
        double[] actualResult = Homework5.reverseNumbers(inpurArr);
        assertArrayEquals(expectedResult, actualResult);
    }

    public static void test_sentanceLength_happyPath() {
        String input = "Do Or do not There is no try";
        Integer[] expectedResult = new Integer[] { 2, 2, 2, 3, 5, 2, 2, 3 };
        Integer[] actualResult = Homework5.sentenceLength(input);
        assertArrayEquals(expectedResult, actualResult);
    }

    public static void test_sentanceLength_noInput() {
        String input = "";
        Integer[] expectedResult = new Integer[] {};
        Integer[] actualResult = Homework5.sentenceLength(input);
        assertArrayEquals(expectedResult, actualResult);
    }

    public static void test_sentanceLength_spaceInput() {
        String input = " ";
        Integer[] expectedResult = new Integer[] {};
        Integer[] actualResult = Homework5.sentenceLength(input);
        assertArrayEquals(expectedResult, actualResult);
    }

    public static void test_usernameChecker_spaceInvalid() {
        String input = "snowFlake123@ gmail";
        boolean actualResult = Homework5.usernameChecker(input);
        assertFalse(actualResult);
    }

    public static void test_usernameChecker_emptyUsername() {
        String input = " ";
        boolean actualResult = Homework5.usernameChecker(input);
        assertFalse(actualResult);
    }

    public static void test_usernameChecker_happyPath() {
        String input = "dylanE1999";
        boolean actualResult = Homework5.usernameChecker(input);
        assertTrue(actualResult);
    }

    public static void main(String[] args) {
        // reverse nums tests
        test_reverseNumbers_happyPath();
        test_reverseNumbers_emptyInput();
        test_reverseNumbers_oneItem();
        // sentanceLength tests
        test_sentanceLength_happyPath();
        test_sentanceLength_noInput();
        test_sentanceLength_spaceInput();
        // usernameChecker tests
        test_usernameChecker_spaceInvalid();
        test_usernameChecker_emptyUsername();
        test_usernameChecker_happyPath();

        System.out.println("----- TESTS COMPLETE -----");
    }

}

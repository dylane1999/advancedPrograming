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


    public static void test_vowelCounter_happyPath() {
        String input = "i think, therefore i am";
        Integer[] expArray = new Integer[]{1, 3, 3, 1, 0};
        Integer[] actualResult = Homework5.vowelCounter(input);
        assertArrayEquals(expArray, actualResult);
    }

    public static void test_vowelCounter_noVowels() {
        String input = "shhhrrt vbc wdcbq";
        Integer[] expArray = new Integer[]{0, 0, 0, 0, 0};
        Integer[] actualResult = Homework5.vowelCounter(input);
        assertArrayEquals(expArray, actualResult);
    }

    public static void test_vowelCounter_emptyInput() {
        String input = "";
        Integer[] expArray = new Integer[]{0, 0, 0, 0, 0};
        Integer[] actualResult = Homework5.vowelCounter(input);
        assertArrayEquals(expArray, actualResult);
    }

    public static void test_moveZeros_happyPath() {
        Integer[] input = new Integer[]{0,0,1,0,3,0,5,0,6};
        Integer[] expArray = new Integer[]{1,3,5, 6, 0, 0, 0, 0, 0};
        Integer[] actualResult = Homework5.moveZeros(input);
        assertArrayEquals(expArray, actualResult);
    }

    public static void test_moveZeros_noZeros() {
        Integer[] input = new Integer[]{4,5,1,5,3,5,5,40,6};
        Integer[] expArray = new Integer[]{4,5,1,5,3,5,5,40,6};
        Integer[] actualResult = Homework5.moveZeros(input);
        assertArrayEquals(expArray, actualResult);
    }

    public static void test_moveZeros_onlyZeros() {
        Integer[] input = new Integer[]{0, 0, 0, 0, 0};
        Integer[] expArray = new Integer[]{0, 0, 0, 0, 0};
        Integer[] actualResult = Homework5.moveZeros(input);
        assertArrayEquals(expArray, actualResult);
    }

    public static void test_matchParens_happyPath() {
        String input = "()()(())";
        boolean actualResult = Homework5.matchParens(input);
        assertTrue(actualResult);
    }

    public static void test_matchParens_invalidParens() {
        String input = "()()(()))))";
        boolean actualResult = Homework5.matchParens(input);
        assertFalse(actualResult);
    }

    public static void test_matchParens_noParensInput() {
        String input = "hello wold";
        boolean actualResult = Homework5.matchParens(input);
        assertTrue(actualResult);
    }

    public static void test_countDiff_happyPath(){
        Integer[] input = new Integer[]{4, 1, -2, 94, 3, 35, -4, -100};
        Integer expResult = 243;
        Integer actualResult = Homework5.countDiff(input);
        assertEquals(expResult, actualResult);
    }

    public static void test_countDiff_noNegative(){
        Integer[] input = new Integer[]{4, 1, 94, 3, 35};
        Integer expResult = 137;
        Integer actualResult = Homework5.countDiff(input);
        assertEquals(expResult, actualResult);
    }

    public static void test_countDiff_allNegative(){
        Integer[] input = new Integer[]{ -4, -100};
        Integer expResult = 104;
        Integer actualResult = Homework5.countDiff(input);
        assertEquals(expResult, actualResult);
    }

    public static void test_findDupes_noDupes(){
        Integer[] input = new Integer[]{ -4, -100};
        Integer expResult = 104;
        Homework5.findDupes(input);
    }

    public static void test_findDupes_happyPath(){
        Integer[] input = new Integer[]{ -4, -100, -4};
        Integer expResult = 104;
        Homework5.findDupes(input);
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
        // vowel counter
        test_vowelCounter_happyPath();
        test_vowelCounter_noVowels();
        test_vowelCounter_emptyInput();
        // move zeros
        test_moveZeros_happyPath();
        test_moveZeros_noZeros();
        test_moveZeros_onlyZeros();
        // match Parens
        test_matchParens_happyPath();
        test_matchParens_invalidParens();
        test_matchParens_noParensInput();
        // count diff
        test_countDiff_happyPath();
        test_countDiff_noNegative();
        test_countDiff_allNegative();
        //findDupes
        test_findDupes_noDupes();
        test_findDupes_happyPath();

        System.out.println("----- TESTS COMPLETE -----");
    }

}

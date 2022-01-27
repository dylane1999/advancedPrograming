package hw1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Homework1 {

    // insertAfterVowels -> insert a given phrase after each occurance (assumes base
    // string is lowecase)

    public static String insertAfterVowels(String baseString, String insertString) {
        // go through all lettesr
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        String newString = "";
        for (int i = 0; i < baseString.length(); i++) {
            // if a letter is capital throw err
            Character currentChar = Character.valueOf(baseString.charAt(i));
            if (Character.isUpperCase(currentChar)) {
                throw new RuntimeException("capital letters in the base string");
            }
            // if vowel insert vowel then the word
            if (vowels.contains(currentChar)) {
                newString += String.valueOf(currentChar);
                newString += insertString;
            } else {
                // add the current char to the string
                newString += String.valueOf(currentChar);
            }

        }
        return newString;

    }

    // addinString -> goes through a string and adds each numner and retune the
    // result ( IndexOutOfBoundsException if out of range )
    public static Integer addInString(String input) {
        // go through each letter in string and add to tallly if number
        Integer runningCount = 0;
        for (int index = 0; index < input.length(); index++) {
            // if number add to the running tally
            if (Character.isDigit(input.charAt(index))) {
                runningCount += Integer.valueOf(String.valueOf(input.charAt(index)));
            }

        }
        return runningCount;

    }

    // takes ina string and inedex. trunes the string w./ the idnx delted
    public static String deleteByIndex(String str, int index) {
        // check if index out of bounds
        if (index >= str.length()) {
            throw new IndexOutOfBoundsException("out of bounds");
        }
        StringBuilder sb = new StringBuilder(str);
        sb.deleteCharAt(index);
        return sb.toString();

    }

    // check if acceptable password. Acceptable passwords: have at least 7
    // characters long; contain both upper and lowercase alphabetic characters; and
    // contain at least 1 digit.

    public static boolean passwordChecker(String str) {
        // check 7 chars
        // contain both upper and lowercase alphabetic characters
        // contain at least 1 digit
        boolean isValidLength = str.length() >= 7;
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasOneDigit = false;

        for (int i = 0; i < str.length(); i++) {
            // speed up process by stopping loop if conditions are met
            if (hasUpper && hasLower && hasOneDigit) {
                break;
            }
            if (Character.isUpperCase(str.charAt(i))) {
                hasUpper = true;
            }
            if (Character.isLowerCase(str.charAt(i))) {
                hasLower = true;
            }
            if (Character.isDigit(str.charAt(i))) {
                hasOneDigit = true;
            }
        }
        return isValidLength && hasUpper && hasLower && hasOneDigit;

    }

    // a "triple" in a string is a character appearing three times in a row. // go
    // through in a sliding window approach to find triples
    // return the number of triples in the string
    public static Integer countTriple(String str) {
        // check if string not long enough for triples
        if (str.length() < 3) {
            return 0;
        }
        Integer numTriples = 0;
        // go through in a sliding window (size =3) approach to find triples
        for (int i = 0; i < str.length() - 2; i++) { // remove 3 due to 3+ window
            Character charOne = Character.valueOf(str.charAt(i));
            Character charTwo = Character.valueOf(str.charAt(i + 1));
            Character charThree = Character.valueOf(str.charAt(i + 2));
            if (charOne.equals(charTwo) && charTwo.equals(charThree)) {
                numTriples++;
            }

        }
        return numTriples;

    }

    // func that takes a positive non-zero integer as its parameter and returns
    // whether the integer is prime or not.
    public static boolean isPrime(int num) {
        // if negative or zero thro illegal arg exception
        if (num <= 0) {
            throw new IllegalArgumentException("input not allowed, cannot be prime");
        }

        boolean isPrime = true;
        for (int i = 2; i <= num / 2; ++i) {
            // condition for nonprime number
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;

    }

    // Example: if the input is “stephen strange”, your method should print the
    // following results:
    // The full name is: Strange, Stephen.
    // The initial is: SS.
    // The name contains 14 characters, excluding the space.
    // Welcome, Stephen!

    public static String nameFormatter(String name) {
        name = name.trim(); // trim name
        // check if blank or formatted incorrectly
        if (name.isEmpty()) {
            throw new IllegalArgumentException("empty string");
        }
        String[] splitName = name.split(" ");
        // if not first last format
        if (splitName.length != 2) {
            throw new IllegalArgumentException("not in first last format");
        }
        // get name
        String firstName = splitName[0];
        String lastName = splitName[1];
        StringBuilder formattedName = new StringBuilder();
        return formattedName.toString();

    }

}

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Homework5 {

    public static double[] reverseNumbers(double[] input) {
        double[] reversedArray = new double[input.length];
        for (int i = 0; i < input.length; i++) {
            int currentIndex = (input.length - 1) - i;
            reversedArray[i] = input[currentIndex];
        }
        return reversedArray;
    }

    // Write a method called sentenceLength that takes a String (assuming each word
    // is separated by a space) as its parameter, and returns an integer array to
    // record the length of each word of the given sentence.
    public static Integer[] sentenceLength(String sentance) {
        sentance = sentance.strip();
        if (sentance.isBlank()) {
            return new Integer[] {};
        }
        String[] splitSentance = sentance.split(" ");
        Integer[] lengths = new Integer[splitSentance.length];
        for (int i = 0; i < splitSentance.length; i++) {
            String[] splitWord = splitSentance[i].split("");
            lengths[i] = splitWord.length;
        }
        return lengths;
    }

    // Write a method called usernameChecker that takes a String as its parameter
    // and returns true if the String is an acceptable username. An acceptable
    // username: has at least 5 characters; doesn’t contain special characters (@ ,
    // # and space); and contains at least 1 uppercase, 1 lowercase and 1 digit
    public static boolean usernameChecker(String username) {
        if (username.length() < 5) {
            return false;
        }
        if (username.contains("#") || username.contains("@") || username.contains(" ") || username.contains("   ")) {
            return false;
        }
        boolean hasLowercase = false;
        boolean hasUpercase = false;
        boolean hasDigit = false;
        // check contains 1 lowecase 1 upercase 1 digit
        for (int i = 0; i < username.length(); i++) {
            if (hasDigit && hasLowercase && hasUpercase) {
                return true;
            } else if (Character.isLowerCase(username.charAt(i))) {
                hasLowercase = true;
            } else if (Character.isUpperCase(username.charAt(i))) {
                hasUpercase = true;
            } else if (Character.isDigit(username.charAt(i))) {
                hasDigit = true;
            }
        }
        return hasDigit && hasLowercase && hasUpercase;

    }

    // Write a method called vowelCounter that takes a String as its parameter and
    // returns an array of integers representing the counts of each vowel in the
    // String. The array returned by your method should hold 5 elements: the first
    // is the count of a, the second is the count of e, the third i, the fourth o,
    // and the fifth u. Assume that the string only contains lowercase letters.

    // Example: if the input is "i think, therefore i am", this method should return
    // [1, 3, 3, 1, 0].

    public static Integer[] vowelCounter(String input) {
        Map<String, Integer> vowels = new HashMap<>();
        vowels.put("a", 0);
        vowels.put("e", 0);
        vowels.put("i", 0);
        vowels.put("o", 0);
        vowels.put("u", 0);
        String[] splitSentance = input.split(" ");
        for (String word : splitSentance) {
            String[] splitWord = word.split("");
            for (String letter : splitWord) {
                if (vowels.containsKey(letter)) {
                    // increment by 1 if appears
                    vowels.put(letter, vowels.get(letter) + 1);
                }
            }
        }
        // now make result array
        return new Integer[] { vowels.get("a"), vowels.get("e"), vowels.get("i"), vowels.get("o"), vowels.get("u") };
    }

    public static Integer[] moveZeros(Integer[] inputArray) {
        // get non zero elements and number of zeros
        // create new arr w elements and then add num of zeros
        Integer numZeros = 0;
        Integer[] newArray = new Integer[inputArray.length];
        Arrays.fill(newArray, 0);
        Integer newArrIndex = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == 0) {
                numZeros++;
            } else {
                newArray[newArrIndex] = inputArray[i];
                newArrIndex++;
            }
        }
        return newArray;
    }

    public static boolean matchParens(String input) {
        // should create a stack of open parens and when we reach a close paren pop one
        // off the stack
        // if the leftover amount is > 0 then it is not valid
        Stack<Character> parens = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            Character currentCharacter = input.charAt(i);
            if (currentCharacter.equals('(')) {
                parens.push('(');
            } else if (currentCharacter.equals(')')) {
                if (parens.size() == 0) {
                    return false;
                }
                parens.pop();
            }
        }
        return parens.isEmpty();
    }

    // returns the differences between the sum of all positive numbers and the sum
    // of all negative numbers.
    public static Integer countDiff(Integer[] inputArray) {
        // get positive numbers
        Integer positiveSum = 0;
        Integer negativeSum = 0;
        for (Integer integer : inputArray) {
            if (integer < 0) {
                negativeSum += integer;
            } else {
                positiveSum += integer;
            }
        }
        return positiveSum - negativeSum;

    }

    public static void findDupes(Integer[] inputArr) {
        // print duplicates
        Set<Integer> dupes = new HashSet<>();
        for (Integer integer : inputArr) {
            if (dupes.contains(integer)) {
                System.out.println(integer);
            } else {
                dupes.add(integer);
            }
        }

    }

    public static void findAllPairs(Integer[] array, Integer target) {
        //prints all pairs whose sum equals the target number 
        // for each try each number after
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] + array[j] == target) {
                    System.out.println(String.format("%d + %d = %d", array[i], array[j], target));
                }
            }
        }
        
    }

}

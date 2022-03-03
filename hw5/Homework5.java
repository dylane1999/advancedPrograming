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
    // # and space); and contains at least 1 uppercase, 1 lowercase and 1 digit.

    // Example: if the input is "snowFlake123@ gmail", this method should return
    // false.
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
            }
            else if (Character.isLowerCase(username.charAt(i))) {
                hasLowercase = true;
            } else if (Character.isUpperCase(username.charAt(i))) {
                hasUpercase = true;
            } else if (Character.isDigit(username.charAt(i))) {
                hasDigit = true;
            }
        }
        return hasDigit && hasLowercase && hasUpercase;

    }

}

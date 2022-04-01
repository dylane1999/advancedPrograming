public class Homework7 {

    public static void fizzbuzz(Integer numRuns) {
        if (numRuns < 1) {
            throw new IllegalArgumentException("numRuns can not be below 1");
        }
        for (int i = 0; i < numRuns; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Buzz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(String.valueOf(i));
            }
        }
    }

    public static int oddSum(int start, int end) {
        if (start == end) {
            return 0;
        }
        if (end < start) {
            throw new IllegalArgumentException("end cannot be before start");
        }
        // return the sum of all odd integerrs between the start and end
        Integer rollingSum = 0;
        for (int i = start; i < end + 1; i++) {
            if (i % 2 != 0) {
                rollingSum += i;
            }
        }
        return rollingSum;
    }

    public static int countChar(String str, char c) {
        // count how many times the char appears
        Integer charAppearances = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                charAppearances++;
            }
        }
        return charAppearances;
    }

    public static boolean isPalindrome(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            Integer otherIndex = (str1.length() - 1) - i;
            if (str1.charAt(i) != str2.charAt(otherIndex)) {
                return false;
            }
        }
        return true;
    }

    public static int combination(int m, int n) {
        // If M is less than N or if N is less than 0, the combination should be 0;
        if (m < n) {
            return 0;
        }
        else if (n < 0){
            return 0;
        }
        // If N is 0, the combination should be 1;
        else if (n == 0) {
            return 1;
        } else {
            // Otherwise, Combination( M, N ) is the sum of the combination of choosing N-1
            // things from M-1 items and the combination of choosing N things from M-1 items
            int x = combination(m - 1, n - 1);
            int y = combination(m-1, n);
            return x + y;
        }
    }

}

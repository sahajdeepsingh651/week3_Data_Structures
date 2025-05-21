public class PalindromeChecker {
    public static void main(String[] args) {
        String input = "madam";

        boolean isPalindrome = checkPalindrome(input);
        System.out.println(input + " is palindrome? " + isPalindrome);
    }

    public static boolean checkPalindrome(String str) {
        int left = 0, right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}

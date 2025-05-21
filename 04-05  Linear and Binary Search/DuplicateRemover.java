import java.util.HashSet;

public class DuplicateRemover {
    public static void main(String[] args) {
        String input = "sreayas";
        String result = removeDuplicates(input);
        System.out.println("Input: " + input);
        System.out.println("After removing duplicates: " + result);
    }

    public static String removeDuplicates(String str) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();

        for (char ch : str.toCharArray()) {
            if (!seen.contains(ch)) {
                seen.add(ch);
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}

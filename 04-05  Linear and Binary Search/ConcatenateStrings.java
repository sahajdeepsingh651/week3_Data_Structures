public class StringConcatenator {
    public static void main(String[] args) {
        String[] words = {"I", "am", "learning", "String", "Buffer"};
        String result = concatenateStrings(words);
        System.out.println("Concatenated string: " + result);
    }

    public static String concatenateStrings(String[] strings) {
        StringBuffer sb = new StringBuffer();
        for (String s : strings) {
            sb.append(s);
        }
        return sb.toString().trim();
    }
}

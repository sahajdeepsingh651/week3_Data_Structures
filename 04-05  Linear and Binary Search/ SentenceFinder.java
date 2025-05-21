public class SentenceFinder {
    public static void main(String[] args) {
        String[] sentences = {"hi how are you", "i am fine", "what about you"};
        String targetWord = "fine";

        String result = findSentenceContainingWord(sentences, targetWord);
        System.out.println("Result: " + result);
    }

    public static String findSentenceContainingWord(String[] sentences, String target) {
        for (String sentence : sentences) {
            if (sentence.contains(target)) {
                return sentence;
            }
        }
        return "Not Found";
    }
}

public class BufferBuilderPerformance {
    public static void main(String[] args) {
        int n = 1_000_000;
        String word = "hello";

        StringBuffer stringBuffer = new StringBuffer();
        long startBuffer = System.nanoTime();
        for (int i = 0; i < n; i++) {
            stringBuffer.append(word);
        }
        long endBuffer = System.nanoTime();
        long timeBuffer = endBuffer - startBuffer;

        StringBuilder stringBuilder = new StringBuilder();
        long startBuilder = System.nanoTime();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(word);
        }
        long endBuilder = System.nanoTime();
        long timeBuilder = endBuilder - startBuilder;

        System.out.println("Time taken by StringBuffer: " + timeBuffer / 1_000_000 + " ms");
        System.out.println("Time taken by StringBuilder: " + timeBuilder / 1_000_000 + " ms");
    }
}

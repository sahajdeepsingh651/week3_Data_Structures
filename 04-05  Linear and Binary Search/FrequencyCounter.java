import java.util.HashMap;
import java.util.Map;

public class FrequencyCounter {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 4, 5};

        Map<Integer, Integer> freqMap = countFrequency(arr);
        System.out.println("Element frequencies: " + freqMap);
    }

    public static Map<Integer, Integer> countFrequency(int[] arr) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int num : arr) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        return frequency;
    }
}

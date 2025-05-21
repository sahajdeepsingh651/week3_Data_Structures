public class FirstNegativeFinder {
    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 7, -3, 8, -1};

        int index = findFirstNegative(arr);

        if (index != -1) {
            System.out.println("First negative number is at index: " + index);
            System.out.println("Value: " + arr[index]);
        } else {
            System.out.println(-1);
        }
    }

    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }
}

import java.util.Stack;

public class StockSpan {

    // Function to calculate stock span
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n]; // To store the span of each day
        Stack<Integer> stack = new Stack<>(); // Stack to store indices of the prices

        for (int i = 0; i < n; i++) {
            // Pop elements from the stack while the current price is greater than the price at the index stored at the top of the stack
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If the stack is empty, it means the current price is greater than all previous prices
            if (stack.isEmpty()) {
                span[i] = i + 1; // Span is i+1 if the stack is empty
            } else {
                // Otherwise, the span is the difference between the current index and the index at the top of the stack
                span[i] = i - stack.peek();
            }

            // Push the current index onto the stack
            stack.push(i);
        }

        return span;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] prices = { 100, 80, 60, 70, 60, 75, 85 };

        // Calculate stock span for each day
        int[] result = calculateSpan(prices);

        // Print the stock span for each day
        System.out.println("Stock spans: ");
        for (int span : result) {
            System.out.print(span + " ");
        }
    }
}

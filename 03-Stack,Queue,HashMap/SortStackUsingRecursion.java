import java.util.Stack;

public class SortStackUsingRecursion {

    // Method to sort the stack using recursion
    public static void sort(Stack<Integer> stack) {
        // Base condition: If stack is empty, return
        if (stack.isEmpty()) {
            return;
        }

        // Pop the top element
        int top = stack.pop();

        // Recursively sort the remaining stack
        sort(stack);

        // Insert the popped element back at the correct position
        insertAtCorrectPosition(stack, top);
    }

    // Method to insert an element at the correct position in the sorted stack
    private static void insertAtCorrectPosition(Stack<Integer> stack, int element) {
        // Base condition: If stack is empty or the element is greater than the top of the stack, insert element
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
            return;
        }

        // If the element is smaller, pop the top and recursively insert the element
        int top = stack.pop();
        insertAtCorrectPosition(stack, element);

        // Push the popped element back
        stack.push(top);
    }

    // Main method for testing
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);

        System.out.println("Original Stack: " + stack);

        // Sort the stack using recursion
        sort(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}

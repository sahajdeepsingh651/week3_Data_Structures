import java.util.Stack;

public class QueueUsingStacks {
    private Stack<Integer> stack1; // For enqueue
    private Stack<Integer> stack2; // For dequeue

    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation (O(1))
    public void enqueue(int data) {
        stack1.push(data);
        System.out.println(data + " enqueued.");
    }

    // Dequeue operation (amortized O(1))
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }

        if (stack2.isEmpty()) {
            // Transfer all elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    // Peek at front element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Display queue elements
    public void display() {
        System.out.print("Queue: ");
        if (!stack2.isEmpty()) {
            for (int i = stack2.size() - 1; i >= 0; i--) {
                System.out.print(stack2.get(i) + " ");
            }
        }

        for (int i = 0; i < stack1.size(); i++) {
            System.out.print(stack1.get(i) + " ");
        }

        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.display();

        System.out.println("Dequeued: " + queue.dequeue());
        queue.display();

        queue.enqueue(40);
        System.out.println("Front element: " + queue.peek());

        queue.display();
    }
}

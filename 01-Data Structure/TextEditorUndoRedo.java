class TextState {
    String content;
    TextState prev;
    TextState next;

    public TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

public class TextEditorUndoRedo {
    private TextState head;
    private TextState current;
    private int size = 0;
    private final int MAX_SIZE = 10;

    public void type(String newText) {
        TextState newState = new TextState(newText);

        // Remove forward history after undo
        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
        }

        // Add new state
        if (head == null) {
            head = newState;
        } else {
            current.next = newState;
            newState.prev = current;
        }
        current = newState;
        size++;

        // Limit size
        if (size > MAX_SIZE) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("Undo not possible.");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("Redo not possible.");
        }
    }

    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current Text: " + current.content);
        } else {
            System.out.println("Editor is empty.");
        }
    }

    public static void main(String[] args) {
        TextEditorUndoRedo editor = new TextEditorUndoRedo();

        // Simulate user typing
        editor.type("Hello");
        editor.type("Hello World");
        editor.type("Hello World!");
        editor.displayCurrentState();  // Hello World!

        // Undo steps
        editor.undo();
        editor.displayCurrentState();  // Hello World

        editor.undo();
        editor.displayCurrentState();  // Hello

        // Redo step
        editor.redo();
        editor.displayCurrentState();  // Hello World

        // Add more text after undo (resets redo history)
        editor.type("Hello Java");
        editor.displayCurrentState();  // Hello Java

        // Try to redo (shouldn't work)
        editor.redo();  // Redo not possible.

        // Fill up editor to trigger history limit
        for (int i = 1; i <= 10; i++) {
            editor.type("Line " + i);
        }
        editor.displayCurrentState();  // Line 10
    }
}

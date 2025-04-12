class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

public class TaskScheduler {
    private Task head = null;
    private Task tail = null;
    private Task current = null;

    // Add at beginning
    public void addAtBeginning(int taskId, String name, int priority, String dueDate) {
        Task newTask = new Task(taskId, name, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            newTask.next = newTask;
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head;
        }
    }

    // Add at end
    public void addAtEnd(int taskId, String name, int priority, String dueDate) {
        Task newTask = new Task(taskId, name, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            newTask.next = newTask;
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head;
        }
    }

    // Add at specific position (1-based)
    public void addAtPosition(int position, int taskId, String name, int priority, String dueDate) {
        if (position <= 1 || head == null) {
            addAtBeginning(taskId, name, priority, dueDate);
            return;
        }

        Task newTask = new Task(taskId, name, priority, dueDate);
        Task current = head;
        for (int i = 1; i < position - 1 && current.next != head; i++) {
            current = current.next;
        }

        newTask.next = current.next;
        current.next = newTask;
        if (current == tail) {
            tail = newTask;
        }
    }

    // Remove task by ID
    public void removeById(int taskId) {
        if (head == null) return;

        Task current = head;
        Task prev = tail;
        do {
            if (current.taskId == taskId) {
                if (current == head) {
                    if (head == tail) {
                        head = tail = null;
                    } else {
                        head = head.next;
                        tail.next = head;
                    }
                } else {
                    prev.next = current.next;
                    if (current == tail) {
                        tail = prev;
                    }
                }
                System.out.println("Task removed: " + taskId);
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        System.out.println("Task ID not found: " + taskId);
    }

    // View current task
    public void viewCurrentTask() {
        if (current == null) current = head;
        if (current == null) {
            System.out.println("No tasks scheduled.");
            return;
        }
        System.out.println("Current Task:");
        printTask(current);
    }

    // Move to next task
    public void moveToNextTask() {
        if (current == null) current = head;
        else current = current.next;
        viewCurrentTask();
    }

    // Display all tasks
    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }

        Task temp = head;
        System.out.println("All Tasks:");
        do {
            printTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // Search task by priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks to search.");
            return;
        }

        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                printTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority: " + priority);
        }
    }

    private void printTask(Task t) {
        System.out.println("ID: " + t.taskId + ", Name: " + t.taskName + ", Priority: " + t.priority + ", Due: " + t.dueDate);
    }

    // Main method for testing
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addAtEnd(101, "Write Report", 1, "2025-04-16");
        scheduler.addAtBeginning(102, "Code Review", 2, "2025-04-15");
        scheduler.addAtPosition(2, 103, "Team Meeting", 3, "2025-04-17");

        scheduler.displayTasks();

        scheduler.viewCurrentTask();
        scheduler.moveToNextTask();
        scheduler.moveToNextTask();

        scheduler.searchByPriority(2);
        scheduler.removeById(103);
        scheduler.displayTasks();
    }
}

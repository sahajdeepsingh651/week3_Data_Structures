class Process {
    int processId;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime = 0;
    int turnaroundTime = 0;
    Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

public class RoundRobinScheduler {
    private Process head = null;
    private Process tail = null;
    private int totalWaitingTime = 0;
    private int totalTurnaroundTime = 0;
    private int processCount = 0;

    // Add process to end of circular list
    public void addProcess(int pid, int bt, int pr) {
        Process newProcess = new Process(pid, bt, pr);
        processCount++;

        if (head == null) {
            head = tail = newProcess;
            newProcess.next = newProcess;
        } else {
            tail.next = newProcess;
            newProcess.next = head;
            tail = newProcess;
        }
    }

    // Remove a process from the list
    private void removeProcess(Process toRemove) {
        if (head == null || toRemove == null) return;

        if (head == toRemove && head == tail) {
            head = tail = null;
            processCount--;
            return;
        }

        Process prev = head;
        while (prev.next != toRemove && prev.next != head) {
            prev = prev.next;
        }

        if (toRemove == head) head = head.next;
        if (toRemove == tail) tail = prev;

        prev.next = toRemove.next;
        processCount--;
    }

    // Display current process list
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        Process temp = head;
        System.out.println("Current Process Queue:");
        do {
            System.out.println("PID: " + temp.processId +
                    ", BT: " + temp.burstTime +
                    ", RT: " + temp.remainingTime +
                    ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }

    // Round Robin Scheduling Simulation
    public void simulate(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int currentTime = 0;
        Process current = head;

        System.out.println("Starting Round Robin Scheduling with Time Quantum: " + timeQuantum);

        while (processCount > 0) {
            if (current.remainingTime > 0) {
                int execTime = Math.min(timeQuantum, current.remainingTime);
                currentTime += execTime;
                current.remainingTime -= execTime;

                System.out.println("\nExecuted Process " + current.processId +
                        " for " + execTime + " units. Remaining: " + current.remainingTime);

                if (current.remainingTime == 0) {
                    current.turnaroundTime = currentTime;
                    current.waitingTime = current.turnaroundTime - current.burstTime;

                    totalWaitingTime += current.waitingTime;
                    totalTurnaroundTime += current.turnaroundTime;

                    System.out.println("Process " + current.processId + " completed.");
                    Process toDelete = current;
                    current = current.next;
                    removeProcess(toDelete);
                } else {
                    current = current.next;
                }

                displayProcesses();
            } else {
                current = current.next;
            }
        }

        System.out.println("\nAll processes completed.");
        System.out.printf("Average Waiting Time: %.2f\n", (float) totalWaitingTime / (totalTurnaroundTime / timeQuantum));
        System.out.printf("Average Turnaround Time: %.2f\n", (float) totalTurnaroundTime / (totalTurnaroundTime / timeQuantum));
    }

    // Main to demonstrate
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        scheduler.addProcess(1, 6, 1);
        scheduler.addProcess(2, 8, 2);
        scheduler.addProcess(3, 7, 1);
        scheduler.addProcess(4, 3, 3);

        scheduler.displayProcesses();
        scheduler.simulate(4); // Time quantum = 4
    }
}

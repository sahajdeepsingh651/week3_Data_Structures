class Student {
    int rollNo;
    String name;
    int age;
    char grade;
    Student next;

    public Student(int rollNo, String name, int age, char grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

public class StudentLinkedList {
    private Student head;

    // Add at beginning
    public void addAtBeginning(int rollNo, String name, int age, char grade) {
        Student newStudent = new Student(rollNo, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    // Add at end
    public void addAtEnd(int rollNo, String name, int age, char grade) {
        Student newStudent = new Student(rollNo, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    // Add at specific position (1-based index)
    public void addAtPosition(int position, int rollNo, String name, int age, char grade) {
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }
        if (position == 1) {
            addAtBeginning(rollNo, name, age, grade);
            return;
        }
        Student newStudent = new Student(rollNo, name, age, grade);
        Student temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of range.");
            return;
        }
        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    // Delete by Roll Number
    public void deleteByRollNumber(int rollNo) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.rollNo == rollNo) {
            head = head.next;
            System.out.println("Deleted student with Roll Number " + rollNo);
            return;
        }

        Student prev = head;
        Student current = head.next;
        while (current != null && current.rollNo != rollNo) {
            prev = current;
            current = current.next;
        }
        if (current == null) {
            System.out.println("Student with Roll Number " + rollNo + " not found.");
            return;
        }
        prev.next = current.next;
        System.out.println("Deleted student with Roll Number " + rollNo);
    }

    // Search by Roll Number
    public void searchStudent(int rollNo) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                System.out.println("Student found: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with Roll Number " + rollNo + " not found.");
    }

    // Update Grade by Roll Number
    public void updateGrade(int rollNo, char newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                temp.grade = newGrade;
                System.out.println("Grade updated for Roll Number " + rollNo);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with Roll Number " + rollNo + " not found.");
    }

    // Display all records
    public void displayRecords() {
        if (head == null) {
            System.out.println("No student records to display.");
            return;
        }
        Student temp = head;
        System.out.println("Student Records:");
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNo + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        StudentLinkedList list = new StudentLinkedList();

        list.addAtBeginning(101, "Alice", 20, 'A');
        list.addAtEnd(102, "Bob", 21, 'B');
        list.addAtPosition(2, 103, "Charlie", 22, 'C');

        list.displayRecords();

        list.searchStudent(102);
        list.updateGrade(103, 'A');
        list.deleteByRollNumber(101);

        list.displayRecords();
    }
}

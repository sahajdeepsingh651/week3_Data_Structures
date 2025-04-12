class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    public Item(String name, int id, int qty, double price) {
        this.itemName = name;
        this.itemId = id;
        this.quantity = qty;
        this.price = price;
        this.next = null;
    }
}

public class InventoryManager {
    private Item head = null;

    // Add item at beginning
    public void addAtBeginning(String name, int id, int qty, double price) {
        Item newItem = new Item(name, id, qty, price);
        newItem.next = head;
        head = newItem;
    }

    // Add item at end
    public void addAtEnd(String name, int id, int qty, double price) {
        Item newItem = new Item(name, id, qty, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item current = head;
        while (current.next != null)
            current = current.next;
        current.next = newItem;
    }

    // Add item at specific position (1-based)
    public void addAtPosition(int pos, String name, int id, int qty, double price) {
        if (pos <= 1 || head == null) {
            addAtBeginning(name, id, qty, price);
            return;
        }
        Item newItem = new Item(name, id, qty, price);
        Item current = head;
        for (int i = 1; i < pos - 1 && current.next != null; i++) {
            current = current.next;
        }
        newItem.next = current.next;
        current.next = newItem;
    }

    // Remove item by ID
    public void removeById(int id) {
        if (head == null) return;
        if (head.itemId == id) {
            head = head.next;
            System.out.println("Item removed.");
            return;
        }
        Item current = head;
        while (current.next != null && current.next.itemId != id)
            current = current.next;

        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("Item removed.");
        } else {
            System.out.println("Item ID not found.");
        }
    }

    // Update quantity
    public void updateQuantity(int id, int newQty) {
        Item current = head;
        while (current != null) {
            if (current.itemId == id) {
                current.quantity = newQty;
                System.out.println("Quantity updated.");
                return;
            }
            current = current.next;
        }
        System.out.println("Item ID not found.");
    }

    // Search by ID
    public void searchById(int id) {
        Item current = head;
        while (current != null) {
            if (current.itemId == id) {
                printItem(current);
                return;
            }
            current = current.next;
        }
        System.out.println("Item not found.");
    }

    // Search by Name
    public void searchByName(String name) {
        Item current = head;
        boolean found = false;
        while (current != null) {
            if (current.itemName.equalsIgnoreCase(name)) {
                printItem(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No item found with name: " + name);
    }

    // Calculate total inventory value
    public void calculateTotalValue() {
        double total = 0;
        Item current = head;
        while (current != null) {
            total += current.quantity * current.price;
            current = current.next;
        }
        System.out.println("Total Inventory Value: ₹" + total);
    }

    // Display all items
    public void displayInventory() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("Inventory Items:");
        Item current = head;
        while (current != null) {
            printItem(current);
            current = current.next;
        }
    }

    // Print item details
    private void printItem(Item item) {
        System.out.println("ID: " + item.itemId + ", Name: " + item.itemName +
                ", Quantity: " + item.quantity + ", Price: ₹" + item.price);
    }

    // Sort inventory by field (name or price) and order (asc/desc)
    public void sortInventory(String field, boolean ascending) {
        head = mergeSort(head, field, ascending);
        System.out.println("Inventory sorted by " + field + " (" + (ascending ? "ASC" : "DESC") + ")");
    }

    // Merge sort implementation for linked list
    private Item mergeSort(Item head, String field, boolean ascending) {
        if (head == null || head.next == null) return head;

        Item mid = getMiddle(head);
        Item nextOfMid = mid.next;
        mid.next = null;

        Item left = mergeSort(head, field, ascending);
        Item right = mergeSort(nextOfMid, field, ascending);

        return sortedMerge(left, right, field, ascending);
    }

    private Item getMiddle(Item head) {
        if (head == null) return head;
        Item slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Item sortedMerge(Item a, Item b, String field, boolean ascending) {
        if (a == null) return b;
        if (b == null) return a;

        boolean condition;
        if (field.equalsIgnoreCase("name")) {
            condition = ascending ? a.itemName.compareToIgnoreCase(b.itemName) <= 0
                    : a.itemName.compareToIgnoreCase(b.itemName) > 0;
        } else { // price
            condition = ascending ? a.price <= b.price : a.price > b.price;
        }

        if (condition) {
            a.next = sortedMerge(a.next, b, field, ascending);
            return a;
        } else {
            b.next = sortedMerge(a, b.next, field, ascending);
            return b;
        }
    }

    // Main for testing
    public static void main(String[] args) {
        InventoryManager inv = new InventoryManager();
        inv.addAtEnd("Pen", 101, 20, 5.0);
        inv.addAtBeginning("Notebook", 102, 15, 25.0);
        inv.addAtPosition(2, "Pencil", 103, 30, 2.5);

        inv.displayInventory();
        inv.updateQuantity(102, 50);
        inv.searchById(101);
        inv.searchByName("Pencil");
        inv.calculateTotalValue();

        inv.sortInventory("name", true);
        inv.displayInventory();

        inv.sortInventory("price", false);
        inv.displayInventory();

        inv.removeById(103);
        inv.displayInventory();
    }
}

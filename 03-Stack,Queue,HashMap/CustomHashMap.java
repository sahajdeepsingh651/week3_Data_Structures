import java.util.LinkedList;

class CustomHashMap<K, V> {
    // Define the initial capacity of the HashMap
    private static final int CAPACITY = 16;
    private LinkedList<Node<K, V>>[] table;

    // Node class for storing key-value pairs in the linked list
    static class Node<K, V> {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor
    public CustomHashMap() {
        table = new LinkedList[CAPACITY];
        for (int i = 0; i < CAPACITY; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Hash function
    private int hash(K key) {
        return Math.abs(key.hashCode()) % CAPACITY;
    }

    // Insert key-value pair into the map
    public void put(K key, V value) {
        int index = hash(key);
        LinkedList<Node<K, V>> bucket = table[index];

        // Check if key already exists and update the value if it does
        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }

        // If key doesn't exist, add a new node
        bucket.add(new Node<>(key, value));
    }

    // Retrieve value for a given key
    public V get(K key) {
        int index = hash(key);
        LinkedList<Node<K, V>> bucket = table[index];

        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }

        return null; // Key not found
    }

    // Remove a key-value pair from the map
    public void remove(K key) {
        int index = hash(key);
        LinkedList<Node<K, V>> bucket = table[index];

        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                bucket.remove(node);
                return;
            }
        }
    }

    // Check if the map contains a key
    public boolean containsKey(K key) {
        int index = hash(key);
        LinkedList<Node<K, V>> bucket = table[index];

        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                return true;
            }
        }

        return false;
    }

    // Display the hash map (for testing)
    public void display() {
        for (int i = 0; i < CAPACITY; i++) {
            if (!table[i].isEmpty()) {
                System.out.print("Bucket " + i + ": ");
                for (Node<K, V> node : table[i]) {
                    System.out.print("[" + node.key + "=" + node.value + "] ");
                }
                System.out.println();
            }
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();

        // Test insertion
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);

        // Test retrieval
        System.out.println("Alice's age: " + map.get("Alice"));
        System.out.println("Bob's age: " + map.get("Bob"));

        // Test update
        map.put("Alice", 26);
        System.out.println("Alice's updated age: " + map.get("Alice"));

        // Test removal
        map.remove("Bob");
        System.out.println("Bob's age after removal: " + map.get("Bob"));

        // Display the map
        map.display();
    }
}

import java.util.*;

class User {
    int userId;
    String name;
    int age;
    List<Integer> friends;  // List of friend User IDs
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<>();
        this.next = null;
    }

    public void addFriend(int friendId) {
        if (!friends.contains(friendId)) {
            friends.add(friendId);
        }
    }

    public void removeFriend(int friendId) {
        friends.remove(Integer.valueOf(friendId));
    }

    public void displayFriends() {
        if (friends.isEmpty()) {
            System.out.println("No friends.");
        } else {
            System.out.println("Friends: " + friends);
        }
    }

    public int countFriends() {
        return friends.size();
    }
}

public class SocialMediaApp {
    private User head = null;

    public void addUser(int id, String name, int age) {
        User newUser = new User(id, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newUser;
        }
    }

    private User findUserById(int id) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    private User findUserByName(String name) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void addFriendConnection(int id1, int id2) {
        User user1 = findUserById(id1);
        User user2 = findUserById(id2);

        if (user1 != null && user2 != null && id1 != id2) {
            user1.addFriend(id2);
            user2.addFriend(id1);
            System.out.println("Friend connection added.");
        } else {
            System.out.println("Invalid users or IDs are the same.");
        }
    }

    public void removeFriendConnection(int id1, int id2) {
        User user1 = findUserById(id1);
        User user2 = findUserById(id2);

        if (user1 != null && user2 != null) {
            user1.removeFriend(id2);
            user2.removeFriend(id1);
            System.out.println("Friend connection removed.");
        } else {
            System.out.println("Users not found.");
        }
    }

    public void displayFriendsOfUser(int id) {
        User user = findUserById(id);
        if (user != null) {
            System.out.println("User: " + user.name);
            user.displayFriends();
        } else {
            System.out.println("User not found.");
        }
    }

    public void findMutualFriends(int id1, int id2) {
        User user1 = findUserById(id1);
        User user2 = findUserById(id2);

        if (user1 != null && user2 != null) {
            List<Integer> mutual = new ArrayList<>(user1.friends);
            mutual.retainAll(user2.friends);
            System.out.println("Mutual Friends between " + user1.name + " and " + user2.name + ": " + mutual);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    public void searchUserById(int id) {
        User user = findUserById(id);
        if (user != null) {
            System.out.println("User Found: " + user.name + " (ID: " + user.userId + ")");
        } else {
            System.out.println("User not found.");
        }
    }

    public void searchUserByName(String name) {
        User user = findUserByName(name);
        if (user != null) {
            System.out.println("User Found: " + user.name + " (ID: " + user.userId + ")");
        } else {
            System.out.println("User not found.");
        }
    }

    public void countAllFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.countFriends() + " friend(s).");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        SocialMediaApp app = new SocialMediaApp();

        // Adding Users
        app.addUser(1, "Alice", 22);
        app.addUser(2, "Bob", 25);
        app.addUser(3, "Charlie", 24);
        app.addUser(4, "Diana", 21);

        // Add Friend Connections
        app.addFriendConnection(1, 2);
        app.addFriendConnection(1, 3);
        app.addFriendConnection(2, 3);
        app.addFriendConnection(3, 4);

        // Display Friends
        app.displayFriendsOfUser(1);

        // Search Users
        app.searchUserById(2);
        app.searchUserByName("Diana");

        // Mutual Friends
        app.findMutualFriends(1, 2);
        app.findMutualFriends(2, 4);

        // Remove Connection
        app.removeFriendConnection(1, 3);
        app.displayFriendsOfUser(1);

        // Friend Count
        app.countAllFriends();
    }
}

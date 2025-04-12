class Movie {
    String title;
    String director;
    int releaseYear;
    double rating;
    Movie prev, next;

    public Movie(String title, String director, int releaseYear, double rating) {
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.prev = null;
        this.next = null;
    }
}

public class MovieManagementSystem {
    private Movie head, tail;

    // Add at beginning
    public void addAtBeginning(String title, String director, int releaseYear, double rating) {
        Movie newMovie = new Movie(title, director, releaseYear, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add at end
    public void addAtEnd(String title, String director, int releaseYear, double rating) {
        Movie newMovie = new Movie(title, director, releaseYear, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Add at specific position (1-based)
    public void addAtPosition(int position, String title, String director, int releaseYear, double rating) {
        if (position <= 1 || head == null) {
            addAtBeginning(title, director, releaseYear, rating);
            return;
        }

        Movie newMovie = new Movie(title, director, releaseYear, rating);
        Movie current = head;
        for (int i = 1; current != null && i < position - 1; i++) {
            current = current.next;
        }

        if (current == null || current.next == null) {
            addAtEnd(title, director, releaseYear, rating);
        } else {
            newMovie.next = current.next;
            newMovie.prev = current;
            current.next.prev = newMovie;
            current.next = newMovie;
        }
    }

    // Remove by title
    public void removeByTitle(String title) {
        Movie current = head;
        while (current != null && !current.title.equalsIgnoreCase(title)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Movie not found: " + title);
            return;
        }

        if (current == head) head = head.next;
        if (current == tail) tail = tail.prev;
        if (current.prev != null) current.prev.next = current.next;
        if (current.next != null) current.next.prev = current.prev;

        System.out.println("Movie removed: " + title);
    }

    // Search by Director
    public void searchByDirector(String director) {
        boolean found = false;
        Movie current = head;
        while (current != null) {
            if (current.director.equalsIgnoreCase(director)) {
                printMovie(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No movies found by director: " + director);
    }

    // Search by Rating
    public void searchByRating(double minRating) {
        boolean found = false;
        Movie current = head;
        while (current != null) {
            if (current.rating >= minRating) {
                printMovie(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No movies found with rating >= " + minRating);
    }

    // Update rating by title
    public void updateRating(String title, double newRating) {
        Movie current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                System.out.println("Rating updated for " + title);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found: " + title);
    }

    // Display forward
    public void displayForward() {
        System.out.println("Movies (Forward):");
        Movie current = head;
        while (current != null) {
            printMovie(current);
            current = current.next;
        }
    }

    // Display reverse
    public void displayReverse() {
        System.out.println("Movies (Reverse):");
        Movie current = tail;
        while (current != null) {
            printMovie(current);
            current = current.prev;
        }
    }

    private void printMovie(Movie movie) {
        System.out.println("Title: " + movie.title + ", Director: " + movie.director +
                ", Year: " + movie.releaseYear + ", Rating: " + movie.rating);
    }

    // Main method for testing
    public static void main(String[] args) {
        MovieManagementSystem system = new MovieManagementSystem();

        system.addAtEnd("Inception", "Christopher Nolan", 2010, 8.8);
        system.addAtBeginning("The Godfather", "Francis Ford Coppola", 1972, 9.2);
        system.addAtPosition(2, "Interstellar", "Christopher Nolan", 2014, 8.6);

        system.displayForward();
        system.displayReverse();

        system.searchByDirector("Christopher Nolan");
        system.searchByRating(9.0);

        system.updateRating("Interstellar", 9.0);
        system.removeByTitle("The Godfather");

        system.displayForward();
    }
}

package  TEAM_14;

class MovieLibrary {
    Movie head;

    void add(int id, String title, String genre, double rating) {
        Movie newMovie = new Movie(id, title, genre, rating);

        if (head == null) {
            head = newMovie;
            return;
        }

        Movie current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newMovie;
    }

    void display() {
        if (head == null) {
            System.out.println("No movies available");
            return;
        }

        System.out.println("\nID\tTitle\t\tGenre\t\tRating");
        System.out.println("========================================");

        Movie current = head;
        while (current != null) {
            System.out.printf("%d\t%-15s%-15s%.1f\n",
                    current.id, current.title, current.genre, current.rating);
            current = current.next;
        }
    }

    void search(String title) {
        Movie current = head;
        boolean found = false;

        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                System.out.println("\nFound -> ID: " + current.id +
                        " | Title: " + current.title +
                        " | Genre: " + current.genre +
                        " | Rating: " + current.rating);
                found = true;
                break;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("Movie not found");
        }
    }

    void sortByRating() {
        if (head == null) {
            System.out.println("No movies to sort");
            return;
        }

        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            Movie current = head;

            while (current.next != null) {
                if (current.rating < current.next.rating) {
                    swapMovies(current, current.next);
                    sorted = false;
                }
                current = current.next;
            }
        }

        System.out.println("Movies sorted by rating");
        display();
    }

    private void swapMovies(Movie m1, Movie m2) {
        int tempId = m1.id;
        m1.id = m2.id;
        m2.id = tempId;

        String tempTitle = m1.title;
        m1.title = m2.title;
        m2.title = tempTitle;

        String tempGenre = m1.genre;
        m1.genre = m2.genre;
        m2.genre = tempGenre;

        double tempRating = m1.rating;
        m1.rating = m2.rating;
        m2.rating = tempRating;
    }

    void topMovie() {
        if (head == null) {
            System.out.println("No movies available");
            return;
        }

        Movie best = head;
        Movie current = head;

        while (current != null) {
            if (current.rating > best.rating) {
                best = current;
            }
            current = current.next;
        }

        System.out.println("\nTop Rated: " + best.title + " (" + best.rating + "/10)");
    }
}
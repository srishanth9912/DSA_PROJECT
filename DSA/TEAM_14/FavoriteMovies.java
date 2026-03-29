package TEAM_14;

import java.util.HashMap;

class FavoriteMovies {
    private HashMap<String, Boolean> favorites;

    FavoriteMovies() {
        favorites = new HashMap<>();
    }

    void add(String title) {
        if (favorites.containsKey(title)) {
            System.out.println(title + " is already in favorites");
            return;
        }

        favorites.put(title, true);
        System.out.println(title + " added to favorites");
    }

    void remove(String title) {
        if (favorites.remove(title) == null) {
            System.out.println(title + " not in favorites");
        } else {
            System.out.println(title + " removed from favorites");
        }
    }

    void display() {
        if (favorites.isEmpty()) {
            System.out.println("No favorite movies");
            return;
        }

        System.out.println("\nFavorite Movies:");
        int count = 1;
        for (String title : favorites.keySet()) {
            System.out.println(count + ". " + title);
            count++;
        }
    }

    boolean exists(String title) {
        return favorites.containsKey(title);
    }
}
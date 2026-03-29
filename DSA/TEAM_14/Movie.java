 package TEAM_14;

class Movie {
    int id;
    String title;
    String genre;
    double rating;
    Movie next;

    Movie(int id, String title, String genre, double rating) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.next = null;
    }
}
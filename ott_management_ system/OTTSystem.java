package TEAM_14;

import java.util.Scanner;

public class OTTSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MovieLibrary library = new MovieLibrary();
        ViewingHistory history = new ViewingHistory();
        WatchQueue watchQueue = new WatchQueue();
        FavoriteMovies favorites = new FavoriteMovies();
        PriorityMovieList priorityList = new PriorityMovieList();

        // Default data
        library.add(1, "RRR", "Action", 9.0);
        library.add(2, "Baahubali", "Epic", 9.2);
        library.add(3, "Pushpa", "Drama", 8.5);
        library.add(4, "KGF", "Action", 9.1);

        int choice;

        do {
            System.out.println("\n========== OTT SYSTEM ==========");
            System.out.println("1. Add Movie");
            System.out.println("2. View All Movies");
            System.out.println("3. Search Movie");
            System.out.println("4. Sort by Rating");
            System.out.println("5. Top Rated Movie");
            System.out.println("6. Add to History");
            System.out.println("7. Remove from History");
            System.out.println("8. View Last Watched");
            System.out.println("9. View All History");
            System.out.println("10. Add to Watch Queue");
            System.out.println("11. Start Watching");
            System.out.println("12. View Watch Queue");
            System.out.println("13. Add to Favorites");
            System.out.println("14. Remove from Favorites");
            System.out.println("15. View Favorites");
            System.out.println("16. Add to Priority List");
            System.out.println("17. View Priority List");
            System.out.println("18. Remove from Priority List");
            System.out.println("19. Exit");
            System.out.print("Choose: ");

            choice = sc.nextInt();
            sc.nextLine(); // important

            switch (choice) {

                case 1:
                    System.out.print("Movie ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Genre: ");
                    String genre = sc.nextLine();
                    System.out.print("Rating: ");
                    double rating = sc.nextDouble();
                    library.add(id, title, genre, rating);
                    System.out.println("Movie added");
                    break;

                case 2:
                    library.display();
                    break;

                case 3:
                    System.out.print("Enter title: ");
                    library.search(sc.nextLine());
                    break;

                case 4:
                    library.sortByRating();
                    break;

                case 5:
                    library.topMovie();
                    break;

                case 6:
                    System.out.print("Movie: ");
                    history.push(sc.nextLine());
                    break;

                case 7:
                    history.pop();
                    break;

                case 8:
                    history.peekLast();
                    break;

                case 9:
                    history.showAll();
                    break;

                case 10:
                    System.out.print("Movie: ");
                    watchQueue.enqueue(sc.nextLine());
                    break;

                case 11:
                    watchQueue.dequeue();
                    break;

                case 12:
                    watchQueue.display();
                    break;

                case 13:
                    System.out.print("Movie: ");
                    favorites.add(sc.nextLine());
                    break;

                case 14:
                    System.out.print("Movie: ");
                    favorites.remove(sc.nextLine());
                    break;

                case 15:
                    favorites.display();
                    break;

                case 16:
                    System.out.print("Movie: ");
                    String movieTitle = sc.nextLine();
                    System.out.print("Priority (1=High, 2=Medium, 3=Low): ");
                    int priority = sc.nextInt();
                    priorityList.addWithPriority(movieTitle, priority);
                    break;

                case 17:
                    priorityList.display();
                    break;

                case 18:
                    System.out.print("Movie: ");
                    priorityList.remove(sc.nextLine());
                    break;

                case 19:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 19);

        sc.close();
    }
}
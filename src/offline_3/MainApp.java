package offline_3;

public class MainApp {
    public static void main(String[] args) {
        ServerSide DesiFlix = new ServerSide();

        // Creating users
        User Alice = new User("Alice");
        User Bob = new User("Bob");
        User Charlie = new User("Charlie");

        // Adding favorite genres for users
        Alice.addFavoriteGenre(Genres.THRILLER);
        Alice.addFavoriteGenre(Genres.HORROR);
        Bob.addFavoriteGenre(Genres.COMEDY);    
        Charlie.addFavoriteGenre(Genres.HORROR);
        Charlie.addFavoriteGenre(Genres.COMEDY);

        // Adding users as subscribers
        DesiFlix.addSubscriber(Alice);
        DesiFlix.addSubscriber(Bob);
        DesiFlix.addSubscriber(Charlie);

        // Uploading a new movie
        DesiFlix.uploadMovie("Edge of Tomorrow", Genres.THRILLER);
        DesiFlix.uploadMovie("The Conjuring", Genres.HORROR);
        DesiFlix.uploadMovie("The Hangover", Genres.COMEDY);

        // Updating user preferences
        Alice.removeFavoriteGenre(Genres.THRILLER);
        Alice.addFavoriteGenre(Genres.COMEDY);
        DesiFlix.updateUserInfo(Alice);

        // Uploading a new movie    
        DesiFlix.uploadMovie("The Dark Knight", Genres.THRILLER);
        DesiFlix.uploadMovie("The Shining", Genres.HORROR);
        DesiFlix.uploadMovie("Superbad", Genres.COMEDY);

        // Removing a user
        DesiFlix.removeSubscriber(Charlie);

        // Uploading a new movie
        DesiFlix.uploadMovie("Inception", Genres.THRILLER);
        DesiFlix.uploadMovie("The Exorcist", Genres.HORROR);
        DesiFlix.uploadMovie("Step Brothers", Genres.COMEDY);

        // Shutting down the service
        DesiFlix.shutdown();
    }
}

package offline_3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ServerSide{
    private final Map<Genres, MovieGenre> genreMap;

    public ServerSide() {
        this.genreMap = new HashMap<>();

        for (Genres genre : Genres.values()) {
            genreMap.put(genre, new MovieGenre(genre));
        }
    }

    public Genres getGenre(String genre) {
        return Genres.valueOf(genre.toUpperCase());
    }

    public void addSubscriber(Observer observer) {
        if (observer instanceof User) {
            User user = (User) observer;
            Set<Genres> favoriteGenres = user.getFavoriteGenres();

            for (Genres genre : favoriteGenres) {
                genreMap.get(genre).subscribe(observer);
            }
        } else {
            throw new IllegalArgumentException("Observer must be an instance of User");
        }
    }

    public void removeSubscriber(Observer observer) {
        if (observer instanceof User) {
            User user = (User) observer;
            Set<Genres> favoriteGenres = user.getFavoriteGenres();

            for (Genres genre : favoriteGenres) {
                genreMap.get(genre).unSubscribe(observer);
            }
        } else {
            throw new IllegalArgumentException("Observer must be an instance of User");
        }
    }

    public void updateUserInfo(Observer observer) {
        if (observer instanceof User) {
            User user = (User) observer;
            Set<Genres> newPreferences = user.getFavoriteGenres();

            for (Genres genre : Genres.values()) {
                Set<Observer> observers = genreMap.get(genre).getSubscribers();

                // If the user is subscribed to a genre but no longer prefers it
                if (observers.contains(user) && !newPreferences.contains(genre)) {
                    genreMap.get(genre).unSubscribe(user);
                }
            }

            for (Genres genre : newPreferences) {
                genreMap.get(genre).subscribe(user);
            }
        } else {
            throw new IllegalArgumentException("Observer must be an instance of User");
        }
    }

    public void uploadMovie(String movieName, Genres genre) {
        genreMap.get(genre).notifySubscribers(movieName);
    }

    public void shutdown() {
        for (MovieGenre genre : genreMap.values()) {
            genre.shutdown();
        }
    }
}

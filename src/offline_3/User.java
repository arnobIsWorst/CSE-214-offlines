package offline_3;

import java.util.HashSet;
import java.util.Set;

public class User implements Observer{
    private final String userName;
    private final Set<Genres> favoriteGenres = new HashSet<>();

    public User(String name) {
        this.userName = name;
    }

    public Set<Genres> getFavoriteGenres() {
        return favoriteGenres;
    }

    public void addFavoriteGenre(Genres genre) {
        favoriteGenres.add(genre);
    }

    public void removeFavoriteGenre(Genres genre) {
        favoriteGenres.remove(genre);
    }

    public void notify(String movieName) {
        System.out.println("User " + userName + " notified about " + movieName);
    }
} 

package offline_3;

import java.util.Set;

public class BackendStore {
    private final NotificationService notificationService;

    public BackendStore() {
        notificationService = new NotificationService();
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }

    public void addSubscriber(Observer observer) {
        if (observer instanceof User) {
            User user = (User) observer;
            Set<Genres> favoriteGenres = user.getFavoriteGenres();

            for (Genres genre : favoriteGenres) {
                notificationService.subscribe(genre, observer);
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
                notificationService.unsubscribe(genre, observer);
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
                Set<Observer> observers = notificationService.getSubscribers(genre);

                // If the user is subscribed to a genre but no longer prefers it
                if (observers.contains(user) && !newPreferences.contains(genre)) {
                    notificationService.unsubscribe(genre, user);
                }
            }

            for (Genres genre : newPreferences) {
                notificationService.subscribe(genre, user);
            }
        } else {
            throw new IllegalArgumentException("Observer must be an instance of User");
        }
    }

    public void uploadMovie(String movieName, Genres genre) {
        notificationService.notifySubscribers(genre, movieName);
    }

    public void shutdown() {
        notificationService.shutdown();
    }
}

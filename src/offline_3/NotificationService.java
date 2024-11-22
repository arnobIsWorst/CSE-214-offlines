package offline_3;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class NotificationService {
    private final ConcurrentHashMap<Genres, Set<Observer>> subscribers;
    private final ExecutorService executorService;
    private final ReadWriteLock lock;

    public NotificationService() {
        subscribers = new ConcurrentHashMap<>();
        for (Genres genre : Genres.values()) {
            subscribers.put(genre, ConcurrentHashMap.newKeySet());
        }

        this.executorService = Executors.newCachedThreadPool();
        this.lock = new ReentrantReadWriteLock();
    }

    public void subscribe(Genres genre, Observer observer) {
        lock.writeLock().lock();
        try {
            subscribers.get(genre).add(observer);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void unsubscribe(Genres genre, Observer observer) {
        lock.writeLock().lock();
        try {
            subscribers.get(genre).remove(observer);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public Set<Observer> getSubscribers(Genres genre) {
        return subscribers.get(genre);
    }

    public void notifySubscribers(Genres genre, String movieName) {
        lock.readLock().lock();
        try {
            Set<Observer> genreSubscribers = subscribers.get(genre);
            for (Observer observer : genreSubscribers) {
                executorService.submit(() -> observer.notify(movieName));
            }
        } finally {
            lock.readLock().unlock();
        }
    }

    public void shutdown() {
        executorService.shutdown();
    }
}


// public class NotificationService {
//     private final ConcurrentHashMap<Genres, Set<Observer>> subscribers;
//     private final ExecutorService executorService;

//     public NotificationService() {
//         subscribers = new ConcurrentHashMap<>();
//         // Arrays.stream(Genres.values())
//         //       .forEach(genre -> subscribers.put(genre, ConcurrentHashMap.newKeySet()));
//         for (Genres genre : Genres.values()) {
//             subscribers.put(genre, ConcurrentHashMap.newKeySet());
//         }

//         this.executorService = Executors.newCachedThreadPool();
//     }

//     public void subscribe(Genres genre, Observer observer) {
//         subscribers.get(genre).add(observer); 
//     }

//     public void unsubscribe(Genres genre, Observer observer) {
//         subscribers.get(genre).remove(observer);
//     }

//     public Set<Observer> getSubscribers(Genres genre) {
//         return subscribers.get(genre);
//     }

//     public void notifySubscribers(Genres genre, String movieName) {
//         Set<Observer> genreSubscribers = subscribers.get(genre);
//         // if (genreSubscribers != null && !genreSubscribers.isEmpty()) {
//         //     ExecutorService executor = Executors.newFixedThreadPool(genreSubscribers.size());

//         //     for (Observer observer : genreSubscribers) {
//         //         executor.submit(() -> observer.notify(movieName));
//         //     }

//         //     executor.shutdown();
//         // }

//         for (Observer observer : genreSubscribers) {
//             executorService.submit(() -> observer.notify(movieName));
//         }
//     }

//     public void shutdown() {
//         executorService.shutdown();
//     }
// }


// import java.util.Arrays;
// import java.util.ArrayList;
// import java.util.List;

// public class NotificationService {
//     private final ConcurrentHashMap<Genres, List<Observer>> subscribers;
    
//     public NotificationService() {
//         subscribers = new ConcurrentHashMap<>();
//         Arrays.stream(Genres.values()).forEach(genre -> subscribers.put(genre, new ArrayList<>()));
//     }

//     public void subscribe(Genres genre, Observer observer) {
//         subscribers.get(genre).add(observer);
//     }

//     public void unsubscribe(Genres genre, Observer observer) {
//         subscribers.get(genre).remove(observer);
//     }

//     public void notifySubscribers(Genres genre, String movieName) {
//         ExecutorService executor = java.util.concurrent.Executors.newFixedThreadPool(subscribers.get(genre).size());

//         for (Observer observer : subscribers.get(genre)) {
//             executor.submit(() -> observer.notify(movieName));
//         }
//         executor.shutdown();
//     }
// }


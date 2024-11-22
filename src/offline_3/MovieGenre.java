package offline_3;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MovieGenre implements Subject{
    private final Genres genre;
    private final Set<Observer> subscribers;
    private final ExecutorService executorService;
    private final ReadWriteLock lock;

    public MovieGenre(Genres genre) {
        this.genre = genre;
        this.subscribers = ConcurrentHashMap.newKeySet();
        this.executorService = Executors.newCachedThreadPool();
        this.lock = new ReentrantReadWriteLock();
    }

    public Genres getGenre() {
        return genre;
    }

    @Override
    public void subscribe(Observer observer) {
        lock.writeLock().lock();
        try {
            subscribers.add(observer);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public void unSubscribe(Observer observer) {
        lock.writeLock().lock();
        try {
            subscribers.remove(observer);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public Set<Observer> getSubscribers() {
        return subscribers;
    }

    @Override
    public void notifySubscribers(String movieName) {
        lock.readLock().lock();
        try {
            Set<Observer> genreSubscribers = getSubscribers();
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

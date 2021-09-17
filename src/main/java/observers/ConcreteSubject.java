package observers;

import solver.Solver;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//This template class is for the book Reactive Programming in Spring
public class ConcreteSubject implements Subject<String> {
  private final ExecutorService executorService = Executors.newCachedThreadPool();
  private final Set<Observer<String>> observers = new CopyOnWriteArraySet<>();

  public void registerObserver(Observer<String> observer) {
    observers.add(observer);
  }

  public void unregisterObserver(Observer<String> observer) {
    observers.remove(observer);
  }

  public void notifyObservers(String event) {
    observers.forEach(observer ->
      executorService.submit(
        () -> observer.observe(event)
      )
    );
  }
}

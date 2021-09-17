package observers;

public interface Observer<T> {
  void observe(T event);
}

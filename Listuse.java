import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Function;


public interface Listuse<T>{
    int getListSize();

    Listuse<T> filter(Predicate<T> predicate);
    <R> Listuse<R> map(Function<T, R> changeFunction);

    Listuse<T> addFront(T element);

    <R> R fold(R initial, BiFunction<R, T, R> accumulate);

    void forEach(Consumer<T> action);

}

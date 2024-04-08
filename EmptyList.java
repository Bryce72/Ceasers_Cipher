import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmptyList<T> implements Listuse<T> {
    @Override
    public int getListSize() {
        return 0;
    }

    @Override
    public Listuse<T> filter(Predicate<T> predicate) {
        return new EmptyList<>();
    }

    @Override
    public <R> Listuse<R> map(Function<T, R> changeFunction) {
        return new EmptyList<>();
    }

    @Override
    public Listuse<T> addFront(T element) {
        return new NotEmptyList<>(element, this);
    }

    @Override
    public <R> R fold(R initial, BiFunction<R, T, R> accumulate) {
        return initial;
    }

    @Override
    public void forEach(Consumer<T> action) {
    }
}

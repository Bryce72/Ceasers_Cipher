
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
public class NotEmptyList<T> implements Listuse<T> {
    private T head;
    private Listuse<T> tail;

    NotEmptyList(T head, Listuse<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public int getListSize() {
        return 1 + tail.getListSize();
    }

    @Override
    public Listuse<T> filter(Predicate<T> predicate) {
        if (predicate.test(head)) {
            return new NotEmptyList<>(head, tail.filter(predicate));
        }
        else {
            return tail.filter(predicate);
        }
    }

    @Override
    public <R> Listuse<R> map(Function<T, R> changeFunction) {
        return new NotEmptyList<>(changeFunction.apply(head), tail.map(changeFunction));
    }

    @Override
    public Listuse<T> addFront(T element) {
        return new NotEmptyList<>(element, this);
    }

    @Override
    public <R> R fold(R initial, BiFunction<R, T, R> accumulate) {
        return this.tail.fold(accumulate.apply(initial, head), accumulate);
    }

    @Override
    public void forEach(Consumer<T> action) {
        action.accept(this.head);
        this.tail.forEach(action);
    }
}


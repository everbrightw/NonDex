package java.util;
import java.util.function.Consumer;
import java.util.HashMap.ForEachProvider;

public class SpliteratorShuffler<T> {
    private final Iterator<T> iter;

    public SpliteratorShuffler(ForEachProvider<T> spliterator) {
        final List<T> elements = new ArrayList<>();

        spliterator.original_forEachRemaining(elements::add);

        List<T> shuffled = edu.illinois.nondex.shuffling.ControlNondeterminism.shuffle(elements);

        iter = shuffled.iterator();
    }

    public void forEachRemaining(Consumer<? super T> action) {
        iter.forEachRemaining(action);
    }
}
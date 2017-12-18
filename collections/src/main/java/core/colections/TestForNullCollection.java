package core.colections;



import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Stream;

import static core.colections.CheckHelper.newInstance;
import static core.colections.CheckHelper.safeForNPE;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.StringUtils.join;
import static org.apache.commons.lang3.StringUtils.leftPad;

public class TestForNullCollection {

    private static void checkForNull(final Class<? extends Collection> clazz) {
        final Collection m = newInstance(clazz);
        System.out.println(join(
                (Stream.of(m.getClass().getSimpleName(),
                        safeForNPE(() -> m.add(null))).map(v -> leftPad(v,22))
                        .collect(toList())),"    |"));

    }
    private static void nullTests() {
        System.out.println(join(
                Stream.of("Коллекция",
                        "null-значение").map(v -> leftPad(v,22)).collect(toList()),"    |"));

        Stream.of(HashSet.class,
                ArrayList.class,
                LinkedList.class,
                PriorityQueue.class,
                ArrayDeque.class,
                Vector.class,
                Stack.class,
                CopyOnWriteArrayList.class,
                CopyOnWriteArraySet.class,
                ConcurrentSkipListSet.class,
                DelayQueue.class
        ).forEach(TestForNullCollection::checkForNull);

    }
    public static void main(final String[] vars) {
        nullTests();
    }
}

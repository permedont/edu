package core.colections;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

import static core.colections.CheckHelper.newInstance;
import static core.colections.CheckHelper.safeForNPE;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.StringUtils.*;


public class TestForNullMap {

    private static void checkForNull(final Class<? extends Map> clazz) {
        final Map m = newInstance(clazz);
        System.out.println(join(
                (Stream.of(m.getClass().getSimpleName(),
                safeForNPE(() -> m.put(null, EMPTY)),
                safeForNPE(() -> m.put(EMPTY, null))).map(v -> leftPad(v,20))
                        .collect(toList())),"    |"));

    }

    private static void nullTests() {
        System.out.println(join(
                Stream.of("Коллекция",
                "null-ключ",
                 "null-значение").map(v -> leftPad(v,20)).collect(toList()),"    |"));

        Stream.of(HashMap.class,
                LinkedHashMap.class,
                TreeMap.class,
                Hashtable.class,
                ConcurrentHashMap.class,
                WeakHashMap.class
        ).forEach(TestForNullMap::checkForNull);
    }

    public static void main(final String[] vars) {
        nullTests();
    }
}

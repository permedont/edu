package core.maps;

import com.sun.istack.internal.NotNull;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Stream;


public class SimpleMap {

    private static Map getMap(final Class<? extends Map> clazz) {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }


    private static void checkMap(@NotNull final Map<String,String> m)
    {
        m.put("1", "test");
        m.put("1", "test");
        m.put("1", "null");
    }

    public static void main(final String[] vars) throws Exception {
        Stream.of(HashMap.class, LinkedHashMap.class, TreeMap.class).forEach((m) -> checkMap(getMap(m)));
    }
}

package core.colections;

import java.lang.reflect.InvocationTargetException;

public class CheckHelper {

    public static <T> T newInstance(final Class<? extends T> clazz) {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String safeForNPE(final Runnable r) {
        try {
            r.run();
        } catch (final NullPointerException e) {
            return " НЕТ";
        }
        return " ДА";
    }
}

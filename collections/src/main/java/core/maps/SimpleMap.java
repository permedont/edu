package core.maps;

import java.util.Map;
import java.util.TreeMap;


public class SimpleMap {
    public static void main(final String[] vars) {
        final Map<String, String> m1 = new TreeMap<String, String>();
        m1.put(null, "test");
        m1.put(null, "test");
        m1.put(null, "null");
        System.out.println(m1.get(null));
    }
}

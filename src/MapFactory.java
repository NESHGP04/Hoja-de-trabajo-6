import java.util.AbstractMap;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;

public class MapFactory {
    
    public static final int HASHMAP_TYPE = 0;
    public static final int TREEMAP_TYPE = 1;
    public static final int LINKEDHASH_MAP = 2;
    
    public static <K, V> AbstractMap<K, V> getMap(int type) {
        switch (type) {
            case HASHMAP_TYPE:
                return new HashMap<K, V>();
            case TREEMAP_TYPE:
                return new TreeMap<K, V>();
            case LINKEDHASH_MAP:
                return new LinkedHashMap<K, V>();
            default:
                throw new IllegalArgumentException("Tipo de mapa no soportado.");
        }
    }
}

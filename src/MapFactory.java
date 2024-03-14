import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapFactory {
    
    public static final int HASHMAP_TYPE = 0;
    public static final int TREEMAP_TYPE = 1;
    public static final int LINKEDHASH_MAP = 2;
    
    public static Map getMap(int type) {
        switch (type) {
            case HASHMAP_TYPE:
                return new HashMap();
            case TREEMAP_TYPE:
                return new TreeMap();
            case LINKEDHASH_MAP:
                return new LinkedHashMap();
            default:
                throw new IllegalArgumentException("Tipo de mapa no soportado.");
        }
    }
}

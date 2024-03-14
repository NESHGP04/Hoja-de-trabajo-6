package test;

import org.junit.Test;

import MapFactory;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapFactoryTest {

    @Test
    public void testGetHashMap() {
        Map<?, ?> map = MapFactory.getMap(MapFactory.HASHMAP_TYPE);
        assertTrue("Debería devolver una instancia de HashMap", map instanceof HashMap);
    }

    @Test
    public void testGetTreeMap() {
        Map<?, ?> map = MapFactory.getMap(MapFactory.TREEMAP_TYPE);
        assertTrue("Debería devolver una instancia de TreeMap", map instanceof TreeMap);
    }

    @Test
    public void testGetLinkedHashMap() {
        Map<?, ?> map = MapFactory.getMap(MapFactory.LINKEDHASH_MAP);
        assertTrue("Debería devolver una instancia de LinkedHashMap", map instanceof LinkedHashMap);
    }

    @Test
    public void testInvalidMapType() {
        try {
            MapFactory.getMap(-1); // Se pasa un tipo de mapa inválido
            fail("Debería haber lanzado una IllegalArgumentException para tipos de mapa no soportados");
        } catch (IllegalArgumentException e) {
            // Test pasa si se captura IllegalArgumentException
        }
    }
}

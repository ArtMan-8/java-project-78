package hexlet.code.schemas;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapSchemaTest {
    @Test
    void requiredTest() {
        MapSchema schema = new MapSchema();

        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap<>()));

        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap<>()));
    }

    @Test
    void sizeofTest() {
        MapSchema schema = new MapSchema();
        var map = new HashMap<>();
        assertTrue(schema.isValid(map));

        schema.sizeof(2);
        assertFalse(schema.isValid(map));

        map.put("key1", "value1");
        assertFalse(schema.isValid(map));

        map.put("key2", "value2");
        assertTrue(schema.isValid(map));
    }
}

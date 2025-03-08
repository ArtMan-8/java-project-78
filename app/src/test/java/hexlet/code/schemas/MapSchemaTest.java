package hexlet.code.schemas;

import hexlet.code.Validator;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapSchemaTest {
    @Test
    void requiredTest() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap<>()));

        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap<>()));
    }

    @Test
    void sizeofTest() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        Map<String, String> map = new HashMap<>();
        assertTrue(schema.isValid(map));

        schema.sizeof(2);
        assertFalse(schema.isValid(map));

        map.put("key1", "value1");
        assertFalse(schema.isValid(map));

        map.put("key2", "value2");
        assertTrue(schema.isValid(map));
    }

    @Test
    void shapeTest() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", v.string().required());
        schemas.put("lastName", v.string().required().minLength(2));
        schema.shape(schemas);

        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        assertTrue(schema.isValid(human1));

        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        assertFalse(schema.isValid(human2));

        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Anna");
        human3.put("lastName", "B");
        assertFalse(schema.isValid(human3));
    }
}

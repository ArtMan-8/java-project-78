package hexlet.code.schemas;

import hexlet.code.Validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberSchemaTest {
    @Test
    void requiredTest() {
        Validator v = new Validator();
        NumberSchema schema = v.number();

        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(0));
        assertTrue(schema.isValid(-10));
        assertTrue(schema.isValid(10));

        schema.required();
        assertFalse(schema.isValid(null));
    }

    @Test
    void positiveTest() {
        Validator v = new Validator();
        NumberSchema schema = v.number();

        assertTrue(schema.isValid(-10));
        assertTrue(schema.isValid(10));

        schema.positive();
        assertFalse(schema.isValid(-10));
        assertFalse(schema.isValid(0));
        assertTrue(schema.isValid(10));
    }

    @Test
    void rangeTest() {
        Validator v = new Validator();
        NumberSchema schema = v.number();

        assertTrue(schema.isValid(-10));
        assertTrue(schema.isValid(10));

        schema.range(5, 10);
        assertFalse(schema.isValid(-10));
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(15));
    }
}

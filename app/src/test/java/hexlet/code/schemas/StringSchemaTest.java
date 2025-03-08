package hexlet.code.schemas;

import hexlet.code.Validator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StringSchemaTest {
    @Test
    void notRequiredTest() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        schema.minLength(5).contains("Java");

        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid("Java Core"));
        assertFalse(schema.isValid("Java"));
    }

    @Test
    void requiredTest() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        schema.minLength(5).contains("Java").required();

        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
        assertTrue(schema.isValid("Java Core"));
        assertFalse(schema.isValid("Java"));
    }
}

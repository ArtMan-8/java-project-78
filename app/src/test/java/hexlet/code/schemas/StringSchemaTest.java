package hexlet.code.schemas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StringSchemaTest {
    @Test
    void notRequiredTest() {
        StringSchema schema = new StringSchema();
        schema.minLength(5).contains("Java");

        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid("Java Core"));
        assertFalse(schema.isValid("Java"));
    }

    @Test
    void requiredTest() {
        StringSchema schema = new StringSchema();
        schema.minLength(5).contains("Java").required();

        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
        assertTrue(schema.isValid("Java Core"));
        assertFalse(schema.isValid("Java"));
    }
}

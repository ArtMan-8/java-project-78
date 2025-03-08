package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.NumberSchema;

/** Класс Validator для создания схем проверки данных. */
public class Validator {
    /**
     * Метод создаёт схему проверки строк.
     * @return StringSchema
     */
    public StringSchema string() {
        return new StringSchema();
    }

    /**
     * Метод создаёт схему проверки чисел.
     * @return NumberSchema
     */
    public NumberSchema number() {
        return new NumberSchema();
    }

    /**
     * Метод создаёт схему проверки Map.
     * @return MapSchema
     */
    public MapSchema map() {
        return new MapSchema();
    }
}

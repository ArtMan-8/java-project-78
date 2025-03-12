package hexlet.code.schemas;

import java.util.Map;
import java.util.HashMap;
import java.util.function.Predicate;

/**
 * Базовый класс BaseSchema для создания схем проверок данных.
 * @param <T> тип данных для проверки
 * */
public class BaseSchema<T> {
    protected boolean isRequired = false;
    protected final Map<String, Predicate<T>> schemas = new HashMap<>();

    /**
     * Метод добавляет правило валидации, что значение должно быть не null.
     * @return BaseSchema<T>
     */
    public BaseSchema<T> required() {
        this.isRequired = true;
        return this;
    }

    /**
     * Метод добавляет схему валидации в общий список схем.
     * @param name название схемы валидации
     * @param predicate предикат для проверки данных
     */
    public void addSchema(String name, Predicate<T> predicate) {
        schemas.put(name, predicate);
    }

    /**
     * Метод валидирует данные по определённой схеме.
     * @param data проверяемые данные
     * @return true, если данные соответствуют схеме, иначе false
     */
    public boolean isValid(T data) {
        if (data == null) {
            return !isRequired;
        }

        for (Predicate<T> predicate : schemas.values()) {
            if (!predicate.test(data)) {
                return false;
            }
        }

        return true;
    }
}

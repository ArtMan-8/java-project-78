package hexlet.code.schemas;

/**
 * Базовый класс BaseSchema для создания схем проверок данных.
 * @param <T> тип данных для проверки
 * */
public class BaseSchema<T> {
    /**
     * Метод валидирует данные по определённой схеме.
     * @param data проверяемые данные
     * @return true, если данные соответствуют схеме, иначе false
     */
    public boolean isValid(T data) {
        throw new RuntimeException("not implemented");
    }
}

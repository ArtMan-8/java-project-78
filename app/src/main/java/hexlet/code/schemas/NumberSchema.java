package hexlet.code.schemas;

/** Класс NumberSchema для создания схем проверки чисел. */
public class NumberSchema extends BaseSchema<Integer> {
    private boolean isRequired = false;
    private boolean isPositive = false;
    private Integer min = Integer.MIN_VALUE;
    private Integer max = Integer.MAX_VALUE;

    public NumberSchema() { }

    /**
     * Метод валидирует данные по определённой схеме.
     * @param data проверяемые данные
     * @return true, если данные соответствуют схеме, иначе false
     */
    @Override
    public boolean isValid(Integer data) {
        if (data == null) {
            return !isRequired;
        }

        if (isPositive && data <= 0) {
            return false;
        }

        return data >= min && data <= max;
    }

    /**
     * Метод добавляет правило валидации, что число должно быть.
     * @return NumberSchema
     */
    public NumberSchema required() {
        this.isRequired = true;
        return this;
    }

    /**
     * Метод добавляет правило валидации, что число должно быть положительным.
     * @return NumberSchema
     */
    public NumberSchema positive() {
        this.isPositive = true;
        return this;
    }

    /**
     * Метод добавляет правило валидации, что число должно быть в определённом диапазоне.
     * @param minNumber минимальное значение диапазона
     * @param maxNumber максимальное значение диапазона
     * @return NumberSchema
     */
    public NumberSchema range(Integer minNumber, Integer maxNumber) {
        this.min = minNumber;
        this.max = maxNumber;
        return this;
    }
}

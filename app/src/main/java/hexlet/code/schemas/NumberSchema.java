package hexlet.code.schemas;

/** Класс NumberSchema для создания схем проверки чисел. */
public class NumberSchema extends BaseSchema<Integer> {
    @Override
    public final NumberSchema required() {
        super.required();
        return this;
    }

    /**
     * Метод добавляет правило валидации, что число должно быть положительным.
     * @return NumberSchema
     */
    public NumberSchema positive() {
        this.addSchema("positiveNumber", data -> data > 0);
        return this;
    }

    /**
     * Метод добавляет правило валидации, что число должно быть в определённом диапазоне.
     * @param min минимальное значение диапазона
     * @param max максимальное значение диапазона
     * @return NumberSchema
     */
    public NumberSchema range(Integer min, Integer max) {
        this.addSchema("numberInRange", data -> data >= min && data <= max);
        return this;
    }
}

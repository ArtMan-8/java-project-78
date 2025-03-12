package hexlet.code.schemas;

/** Класс StringSchema для создания схем проверки строк. */
public class StringSchema extends BaseSchema<String> {
    @Override
    public final StringSchema required() {
        super.required();
        this.addSchema("noEmptyString", (data) -> !data.isEmpty());
        return this;
    }

    /**
     * Метод добавляет правило валидации, что строка должна быть не короче определённой длины.
     * @param min минимальная длина строки
     * @return StringSchema
     */
    public StringSchema minLength(int min) {
        this.addSchema("minLength", (data) -> data.length() >= min);
        return this;
    }

    /**
     * Метод добавляет правило валидации, что строка должна содержать определённую подстроку.
     * @param text подстрока
     * @return StringSchema
     */
    public StringSchema contains(String text) {
        this.addSchema("containsText", (data) -> data.contains(text));
        return this;
    }
}

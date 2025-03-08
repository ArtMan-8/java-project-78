package hexlet.code.schemas;

/** Класс StringSchema для создания схем проверки строк. */
public class StringSchema extends BaseSchema<String> {
    private boolean isRequired = false;
    private int minLength = 0;
    private String text = "";

    public StringSchema() { }

    /**
     * Метод валидирует данные по определённой схеме.
     * @param data проверяемые данные
     * @return true, если данные соответствуют схеме, иначе false
     */
    @Override
    public boolean isValid(String data) {
        if (!isRequired && data == null) {
            return true;
        }

        if (!isRequired && data.isEmpty()) {
            return true;
        }

        if (data == null || data.isEmpty()) {
            return false;
        }

        if (data.length() < minLength) {
            return false;
        }

        return data.contains(text);
    }

    /**
     * Метод добавляет правило валидации, что строка должна быть не пустой.
     * @return StringSchema
     */
    public StringSchema required() {
        this.isRequired = true;
        return this;
    }

    /**
     * Метод добавляет правило валидации, что строка должна быть не короче определённой длины.
     * @param min минимальная длина строки
     * @return StringSchema
     */
    public StringSchema minLength(int min) {
        this.minLength = min;
        return this;
    }

    /**
     * Метод добавляет правило валидации, что строка должна содержать определённую подстроку.
     * @param str подстрока
     * @return StringSchema
     */
    public StringSchema contains(String str) {
        this.text = str;
        return this;
    }
}
